package axiomq.com.starwars.services.converters;

import axiomq.com.starwars.entities.Planet;
import axiomq.com.starwars.entities.dto.PlanetInit;
import axiomq.com.starwars.services.CharacterService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class PlanetConverter {

    private final CharacterService characterService;

    public PlanetConverter(@Lazy CharacterService characterService) {
        this.characterService = characterService;
    }

    public Planet toPlanet(PlanetInit planetInit) {
        return Planet.builder()
                .name(planetInit.getName())
                .characters(null)
                .build();
    }
}
