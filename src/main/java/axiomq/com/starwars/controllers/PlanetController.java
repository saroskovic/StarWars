package axiomq.com.starwars.controllers;

import axiomq.com.starwars.entities.Planet;
import axiomq.com.starwars.services.PlanetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/planet")
public class PlanetController {

    private PlanetService planetService;

    @GetMapping
    public List<Planet> fetchAllPlanets() {
        return planetService.getAllPlanets();
    }

    @GetMapping("/{id}")
    public Planet getPlanet(@PathVariable Long id) {
        return planetService.getById(id);
    }

    @PutMapping("/{id}")
    public Planet updatePlanet(@RequestBody Planet planet, @PathVariable Long id) {
        return planetService.updatePlanet(planet, id);
    }

    @PostMapping
    public Planet savePlanet(@RequestBody Planet planet) {
        return planetService.savePlanet(planet);
    }

    @DeleteMapping("/{id}")
    public void deletePlanet(@PathVariable Long id) {
        planetService.deletePlanet(id);
    }

}
