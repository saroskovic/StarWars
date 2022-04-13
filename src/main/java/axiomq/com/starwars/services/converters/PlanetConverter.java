package axiomq.com.starwars.services.converters;

import axiomq.com.starwars.entities.Planet;
import axiomq.com.starwars.entities.dto.PlanetInit;
import org.springframework.stereotype.Service;

@Service
public class PlanetConverter {

    public Planet toPlanet(PlanetInit planetInit){
        return Planet.builder()
                .name(planetInit.getName())
                .build();
    }
}
