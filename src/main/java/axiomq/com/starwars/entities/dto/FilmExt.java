package axiomq.com.starwars.entities.dto;

import lombok.Data;

import java.util.List;

@Data
public class FilmExt {

    private String next;
    private List<FilmInit> results;
}
