package axiomq.com.starwars.services;

import axiomq.com.starwars.entities.Characters;

import java.util.List;

public interface CharactersService {

    List<Characters> fetchAllCharacters();

    Characters getCharactterById(Long characterId);

    void deleteCharacter(Long characterId);


}
