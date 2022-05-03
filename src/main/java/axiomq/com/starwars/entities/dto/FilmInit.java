package axiomq.com.starwars.entities.dto;

import axiomq.com.starwars.entities.Character;
import lombok.Data;

import java.util.Set;

@Data
public class FilmInit {

    private String title;
    private Set<String> characters;
}
