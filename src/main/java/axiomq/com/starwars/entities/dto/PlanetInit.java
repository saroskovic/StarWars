package axiomq.com.starwars.entities.dto;

import lombok.Data;

import java.util.Set;

@Data
public class PlanetInit {

    private String name;
    private Set<String> residents;
}
