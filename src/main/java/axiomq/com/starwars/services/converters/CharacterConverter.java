package axiomq.com.starwars.services.converters;

import axiomq.com.starwars.entities.Character;
import axiomq.com.starwars.entities.Film;
import axiomq.com.starwars.entities.Planet;
import axiomq.com.starwars.entities.dto.CharacterInit;
import axiomq.com.starwars.services.FilmService;
import axiomq.com.starwars.services.PlanetService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


@Service
public class CharacterConverter {

    private final PlanetService planetService;
    private final FilmService filmService;

    public CharacterConverter(PlanetService planetService, FilmService filmService) {
        this.planetService = planetService;
        this.filmService = filmService;
    }

    public Character toCharacter(CharacterInit characterInit) {
        return Character.builder()
                .name(characterInit.getName())
                .planet(homeworldToPlanet(characterInit.getHomeworld()))
                .gender(characterInit.getGender())
                .films(stringToFilm(characterInit.getFilms()))
                .votersCount(0)
                .build();
    }

    public Planet homeworldToPlanet(String homeworld) {
        String homeworldId = homeworld.replaceAll("[^0-9]", "");
        Long planetId = Long.parseLong(homeworldId);
        return planetService.getById(planetId);
    }

    public Set<Film> stringToFilm(Set<String> filmUrls){
        Set<Long> filmId = filmUrls.stream().map(film -> Long.parseLong(film.replaceAll("[^0-9]", ""))).collect(Collectors.toSet());
        Set<Film> films = filmId.stream().map(id -> filmService.getById(id)).collect(Collectors.toSet());
        return films;
    }
}
