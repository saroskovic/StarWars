package axiomq.com.starwars.controllers;

import axiomq.com.starwars.services.CharacterService;
import axiomq.com.starwars.services.PlanetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/populatedb")
public class DatabaseController {

    private PlanetService planetService;

    private CharacterService characterService;

    @GetMapping
    public void populate(){
        planetService.populateDatabase();
        characterService.populateDatabase();
    }

}
