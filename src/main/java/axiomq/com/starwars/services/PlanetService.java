package axiomq.com.starwars.services;

import axiomq.com.starwars.entities.Planet;

import java.util.List;

public interface PlanetService {

    Planet savePlanet(Planet planet);

    List<Planet> getAllPlanets();

    Planet updatePlanet(Planet planet, Long planetId);

    Planet getById(Long planetId);

    void deletePlanet(Long id);

    void populateDatabase();
}
