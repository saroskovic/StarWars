package axiomq.com.starwars.repositories;

import axiomq.com.starwars.entities.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
