package axiomq.com.starwars.entities.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CharacterInit {

    private String name;
    private String gender;
    private String homeworld;
    private Set<String> films;
}
