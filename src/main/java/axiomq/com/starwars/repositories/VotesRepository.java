package axiomq.com.starwars.repositories;

import axiomq.com.starwars.entities.Votes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotesRepository extends JpaRepository<Votes, Long> {

}
