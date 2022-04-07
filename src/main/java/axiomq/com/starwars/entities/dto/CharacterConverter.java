package axiomq.com.starwars.entities.dto;

import axiomq.com.starwars.entities.Character;
import axiomq.com.starwars.entities.Film;
import axiomq.com.starwars.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharacterConverter {

    private final FilmService filmService;

    public Character toCharacter(CharacterInit characterInit){
        return Character.builder()
                .name(characterInit.getName())
                .planet(characterInit.getHomeworld())
                .gender(characterInit.getGender())
                .films(null)
                //.films(filmConverter(characterInit.getFilms()))
                .votersCount(0)
                .build();
    }

    public Set<Film> filmConverter(Set<String> films){
        Set<Film> filmSet = new HashSet<>();
        String prefix = "https://swapi.dev/api/films/";
        Set<Long> filmIds = films.stream()
                .map(film -> Long.valueOf(getPlainNumber(prefix, film)))
                .collect(Collectors.toSet());

        filmSet = filmIds.stream()
                .map(filmService::getById)
                .collect(Collectors.toSet());

        return filmSet;
    }

    public int getPlainNumber(String prefix, String name){
        String numberAsString = name.substring(0, name.length()-1);
        numberAsString = numberAsString.substring(prefix.length());
        return Integer.parseInt(numberAsString);
    }
}
