package axiomq.com.starwars.services.implementations;

import axiomq.com.starwars.entities.Character;
import axiomq.com.starwars.services.CharacterService;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.net.ssl.HttpsURLConnection;
import java.util.List;

public class CharacterServiceImpl implements CharacterService {


    @Override
    public void populateDatabase() {

    }

    @Override
    public List<Character> fetchAllCharacters() {

        return null;
    }

    @Override
    public Character getCharacterById(Long characterId) {
        return null;
    }

    @Override
    public void deleteCharacter(Long characterId) {

    }
}
