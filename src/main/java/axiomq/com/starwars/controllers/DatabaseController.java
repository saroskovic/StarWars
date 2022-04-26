package axiomq.com.starwars.controllers;

import axiomq.com.starwars.services.CharacterService;
import axiomq.com.starwars.services.FilmService;
import axiomq.com.starwars.services.PlanetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/admin/populatedb")
public class DatabaseController {

    private PlanetService planetService;

    private CharacterService characterService;

    private FilmService filmService;

    @GetMapping
    public void populate() {
        planetService.populateDatabase();
        filmService.populateDatabase();
        characterService.populateDatabase();

    }

}
