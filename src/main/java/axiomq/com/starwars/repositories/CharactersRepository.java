package axiomq.com.starwars.repositories;

import axiomq.com.starwars.entities.Characters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharactersRepository extends JpaRepository<Characters, Long> {


}
