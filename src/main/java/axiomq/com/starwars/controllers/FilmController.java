package axiomq.com.starwars.controllers;

import axiomq.com.starwars.entities.Character;
import axiomq.com.starwars.entities.Film;
import axiomq.com.starwars.services.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/film")
public class FilmController {

    private FilmService filmService;

    @GetMapping
    public List<Film> fetchAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public Film getFilm(@PathVariable Long id) {
        return filmService.getById(id);
    }

    @PostMapping
    public Film saveFilm(@RequestBody Film film) {
        return filmService.saveFilm(film);
    }

    @PutMapping("/{id}")
    public Film updateFilm(@RequestBody Film film, @PathVariable Long id) {
        return filmService.updateFilm(film, id);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
    }

    @GetMapping("/character/{id}")
    public Set<Character> charactersInFilm(@PathVariable Long id){
        return filmService.charactersInFilm(id);
    }

}
