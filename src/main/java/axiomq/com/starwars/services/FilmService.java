package axiomq.com.starwars.services;

import axiomq.com.starwars.entities.Film;

import java.util.List;

public interface FilmService {

    Film saveFilm(Film film);

    List<Film> getAllFilms();

    Film updateFilm(Film film, Long filmId);

    Film getById(Long filmId);

    void deleteFilm(Long id);

    void populateDatabase();
}
