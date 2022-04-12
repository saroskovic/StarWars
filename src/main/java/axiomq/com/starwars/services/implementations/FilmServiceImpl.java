package axiomq.com.starwars.services.implementations;

import axiomq.com.starwars.entities.Film;
import axiomq.com.starwars.entities.dto.FilmExt;
import axiomq.com.starwars.entities.dto.FilmInit;
import axiomq.com.starwars.repositories.FilmRepository;
import axiomq.com.starwars.services.FilmService;
import axiomq.com.starwars.services.converters.FilmConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final RestTemplate restTemplate;

    private final FilmConverter filmConverter;

    private final FilmRepository filmRepository;

    String url = "https://swapi.dev/api/films";

    @Override
    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film updateFilm(Film newFilm, Long filmId) {
        Film film = getById(filmId);
        if(newFilm.getName() != null)
            film.setName(newFilm.getName());
        return filmRepository.save(film);
    }

    @Override
    public Film getById(Long filmId) {
        return filmRepository.findById(filmId)
                .orElseThrow(() -> new NoSuchElementException(String.format("Film: %d not found", filmId)));
    }

    @Override
    public void deleteFilm(Long filmId) {
        Film film = getById(filmId);
        filmRepository.delete(film);
    }

    @Override
    public void populateDatabase() {

        Set<Film> filmsDb = new HashSet<>();

        while(url!=null) {
            FilmExt response = restTemplate.getForObject(url, FilmExt.class);
            List<FilmInit> films = new ArrayList<>(response.getResults());
            films.forEach(filmInit -> filmsDb.add(filmConverter.toFilm(filmInit)));
            filmRepository.saveAll(filmsDb);
            url = response.getNext();
        }
    }
}
