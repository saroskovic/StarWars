package axiomq.com.starwars.repositories;

import axiomq.com.starwars.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}
