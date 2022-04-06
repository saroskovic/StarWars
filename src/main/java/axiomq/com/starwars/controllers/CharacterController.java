package axiomq.com.starwars.controllers;

import axiomq.com.starwars.services.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {

    private CharacterService characterService;

    @GetMapping("/populatedb")
    public void populate(){
        characterService.populateDatabase();
    }
}
