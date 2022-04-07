package axiomq.com.starwars.services.implementations;

import axiomq.com.starwars.entities.Film;
import axiomq.com.starwars.repositories.FilmRepository;
import axiomq.com.starwars.services.FilmService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

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
}
