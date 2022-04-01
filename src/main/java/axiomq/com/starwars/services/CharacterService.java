package axiomq.com.starwars.services;

import axiomq.com.starwars.entities.Character;

import java.util.List;

public interface CharacterService {

    List<Character> fetchAllCharacters();

    Character getCharacterById(Long characterId);

    void deleteCharacter(Long characterId);

    void populateDatabase();


}
