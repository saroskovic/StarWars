package axiomq.com.starwars.entities.dto;

import lombok.Data;

import java.util.List;

@Data
public class CharacterExt {

    private String next;
    private List<CharacterInit> results;
}
