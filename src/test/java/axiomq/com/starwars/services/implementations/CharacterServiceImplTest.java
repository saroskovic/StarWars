package axiomq.com.starwars.services.implementations;

import axiomq.com.starwars.entities.dto.CharacterConverter;
import axiomq.com.starwars.repositories.CharacterRepository;
import axiomq.com.starwars.services.CharacterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class CharacterServiceImplTest {


    private CharacterServiceImpl characterService;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private CharacterConverter characterConverter;

    @Mock
    private CharacterRepository characterRepository;

    @BeforeEach
    void setUp() {
        characterService = new CharacterServiceImpl(restTemplate, characterConverter, characterRepository);
    }

    @Test
    void populateDatabase() {
        //given

        //when

        //then
    }

    @Test
    void fetchAllCharacters() {
    }

    @Test
    void saveCharacter() {
    }

    @Test
    void getCharacterById() {
    }

    @Test
    void updateCharacter() {
    }

    @Test
    void deleteCharacter() {
    }
}