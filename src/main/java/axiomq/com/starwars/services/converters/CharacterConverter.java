package axiomq.com.starwars.services.converters;

import axiomq.com.starwars.entities.Character;
import axiomq.com.starwars.entities.Planet;
import axiomq.com.starwars.entities.dto.CharacterInit;
import axiomq.com.starwars.services.PlanetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CharacterConverter {

    private final PlanetService planetService;

    public Character toCharacter(CharacterInit characterInit) {
        return Character.builder()
                .name(characterInit.getName())
                .planet(homeworldToPlanet(characterInit.getHomeworld()))
                .gender(characterInit.getGender())
                .films(null)
                .votersCount(0)
                .build();
    }

    public Planet homeworldToPlanet(String homeworld) {
        String homeworldId = homeworld.replaceAll("[^0-9]", "");
        Long planetId = Long.parseLong(homeworldId);
        return planetService.getById(planetId);
    }


}
