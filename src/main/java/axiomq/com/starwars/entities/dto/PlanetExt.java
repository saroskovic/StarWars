package axiomq.com.starwars.entities.dto;

import lombok.Data;

import java.util.List;

@Data
public class PlanetExt {

    private String next;
    private List<PlanetInit> results;
}
