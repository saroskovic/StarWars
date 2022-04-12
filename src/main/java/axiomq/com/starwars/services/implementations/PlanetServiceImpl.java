package axiomq.com.starwars.services.implementations;

import axiomq.com.starwars.entities.Planet;
import axiomq.com.starwars.entities.dto.PlanetExt;
import axiomq.com.starwars.entities.dto.PlanetInit;
import axiomq.com.starwars.repositories.PlanetRepository;
import axiomq.com.starwars.services.PlanetService;
import axiomq.com.starwars.services.converters.PlanetConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PlanetServiceImpl implements PlanetService {

    private final PlanetRepository planetRepository;

    private final RestTemplate restTemplate;

    private final PlanetConverter planetConverter;

    String url = "https://swapi.dev/api/planets";

    @Override
    public Planet savePlanet(Planet planet) {
        return planetRepository.save(planet);
    }

    @Override
    public List<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    @Override
    public Planet updatePlanet(Planet newPlanet, Long planetId) {
        Planet planet = getById(planetId);
        if(newPlanet.getName() != null)
            planet.setName(newPlanet.getName());
        return planetRepository.save(planet);
    }

    @Override
    public Planet getById(Long planetId) {
        return planetRepository.findById(planetId)
                .orElseThrow(() -> new NoSuchElementException(String.format("Planet: %d not found", planetId)));
    }

    @Override
    public void deletePlanet(Long id) {
        Planet planet = getById(id);
        planetRepository.delete(planet);

    }

    @Override
    public void populateDatabase() {

        Set<Planet> planetsDb = new HashSet<>();

        while(url!=null) {
            PlanetExt response = restTemplate.getForObject(url, PlanetExt.class);
            List<PlanetInit> planets = new ArrayList<>(response.getResults());
            planets.forEach(planetInit -> planetsDb.add(planetConverter.toPlanet(planetInit)));
            planetRepository.saveAll(planetsDb);
            url = response.getNext();
        }

    }
}
