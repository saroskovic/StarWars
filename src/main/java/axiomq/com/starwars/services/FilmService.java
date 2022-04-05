package axiomq.com.starwars.services;

import axiomq.com.starwars.entities.Film;

import java.util.List;
import java.util.Set;

public interface FilmService {

    Film saveFilm(Film film);

    List<Film> getAllFilms();

    Film updateFilm(Film film, Long filmId);

    Film getById(Long filmId);

    void deleteFilm(Long id);
}
