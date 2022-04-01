package axiomq.com.starwars.repositories;

import axiomq.com.starwars.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {


}
