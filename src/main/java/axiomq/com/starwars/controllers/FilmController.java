package axiomq.com.starwars.controllers;

import axiomq.com.starwars.entities.Film;
import axiomq.com.starwars.services.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/film")
public class FilmController {

    private FilmService filmService;

    @GetMapping
    public List<Film> fetchAllFilms(){
        return filmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public Film getFilm(@PathVariable Long id){
        return filmService.getById(id);
    }

    @PostMapping
    public Film saveFilm(@RequestBody Film film){
        return filmService.saveFilm(film);
    }

    @PutMapping("/{id}")
    public Film updateFilm(@RequestBody Film film, @PathVariable Long id){
        return filmService.updateFilm(film, id);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Long id){
        filmService.deleteFilm(id);
    }

}