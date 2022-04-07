package axiomq.com.starwars.entities.dto;

import axiomq.com.starwars.entities.Character;
import axiomq.com.starwars.entities.Film;
import axiomq.com.starwars.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
//@RequiredArgsConstructor
public class CharacterConverter {

    //private final FilmService filmService;

    public Character toCharacter(CharacterInit characterInit){
        return Character.builder()
                .name(characterInit.getName())
                .planet(characterInit.getHomeworld())
                .gender(characterInit.getGender())
                .films(null)
                .votersCount(0)
                .build();
    }

    public Film toFilm(FilmInit filmInit){
        return Film.builder()
                .name(filmInit.getTitle())
                .characters(null)
                .build();
    }




}
