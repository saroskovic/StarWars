package axiomq.com.starwars.controllers;

import axiomq.com.starwars.services.CharacterService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CharacterController {

    private CharacterService characterService;

    @GetMapping("/populatedb")
    public void populate(){
        characterService.populateDatabase();
    }
}
