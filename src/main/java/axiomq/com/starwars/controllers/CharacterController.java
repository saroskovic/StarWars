package axiomq.com.starwars.controllers;

import axiomq.com.starwars.entities.Character;
import axiomq.com.starwars.services.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/character")
public class CharacterController {

    private CharacterService characterService;

    @PostMapping
    public Character saveCharacter(@RequestBody Character character) {
        return characterService.saveCharacter(character);
    }

    @GetMapping
    public List<Character> fetchAllCharacters() {
        return characterService.fetchAllCharacters();
    }

    @GetMapping("/{id}")
    public Character getCharacter(@PathVariable Long id) {
        return characterService.getCharacterById(id);
    }

    @PutMapping("/{id}")
    public Character updateCharacter(@RequestBody Character character, @PathVariable Long id) {
        return characterService.updateCharacter(character, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
    }
}
