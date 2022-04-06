package axiomq.com.starwars.repositories;

import axiomq.com.starwars.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
