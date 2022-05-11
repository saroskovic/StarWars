package axiomq.com.starwars.services.implementations;

import axiomq.com.starwars.entities.Character;
import axiomq.com.starwars.repositories.FilmRepository;
import axiomq.com.starwars.services.converters.CharacterConverter;
import axiomq.com.starwars.entities.dto.CharacterExt;
import axiomq.com.starwars.entities.dto.CharacterInit;
import axiomq.com.starwars.repositories.CharacterRepository;
import axiomq.com.starwars.services.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final RestTemplate restTemplate;

    private final CharacterConverter characterConverter;

    private final CharacterRepository characterRepository;

    private final FilmRepository filmRepository;

    String url = "https://swapi.dev/api/people";

    @Override
    public void populateDatabase() {

        Set<Character> charactersDb = new HashSet<>();
        while (url != null) {
            CharacterExt response = restTemplate.getForObject(url, CharacterExt.class);
            List<CharacterInit> characters = new ArrayList<>(response.getResults());
            characters.forEach(characterInit -> charactersDb.add(characterConverter.toCharacter(characterInit)));
            characterRepository.saveAll(charactersDb);
            url = response.getNext();
        }
    }

    @Override
    public List<Character> fetchAllCharacters() {
        return characterRepository.findAll();
    }

    @Override
    public Character saveCharacter(Character character) {
        return characterRepository.save(character);
    }

    @Override
    public Character getCharacterById(Long characterId) {
        return characterRepository.findById(characterId)
                .orElseThrow(() -> new NoSuchElementException(String.format("Character: %d not found", characterId)));
    }

    @Override
    public Character updateCharacter(Character newCharacter, Long characterId) {
        Character character = getCharacterById(characterId);
        if (newCharacter.getName() != null)
            character.setName(newCharacter.getName());
        if (newCharacter.getGender() != null)
            character.setGender(newCharacter.getGender());
        if (newCharacter.getPlanet() != null)
            character.setPlanet(newCharacter.getPlanet());
        return characterRepository.save(character);
    }

    @Override
    public void deleteCharacter(Long characterId) {
        Character character = getCharacterById(characterId);
        characterRepository.delete(character);
    }
}
