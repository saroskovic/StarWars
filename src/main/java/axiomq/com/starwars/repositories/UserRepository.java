package axiomq.com.starwars.repositories;

import axiomq.com.starwars.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}