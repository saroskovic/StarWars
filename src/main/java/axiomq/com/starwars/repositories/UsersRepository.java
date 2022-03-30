package axiomq.com.starwars.repositories;

import axiomq.com.starwars.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
