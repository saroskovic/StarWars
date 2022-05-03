package axiomq.com.starwars.repositories;

import axiomq.com.starwars.entities.Role;
import axiomq.com.starwars.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(UserType name);
}
