package axiomq.com.starwars.services.converters;

import axiomq.com.starwars.entities.Film;
import axiomq.com.starwars.entities.dto.FilmInit;
import org.springframework.stereotype.Service;

@Service
public class FilmConverter {

    public Film toFilm(FilmInit filmInit){
        return Film.builder()
                .name(filmInit.getTitle())
                .characters(null)
                .build();
    }


}
