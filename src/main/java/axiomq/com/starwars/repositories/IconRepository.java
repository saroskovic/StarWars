package axiomq.com.starwars.repositories;

import axiomq.com.starwars.entities.Icon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IconRepository extends JpaRepository<Icon, Long> {

}
