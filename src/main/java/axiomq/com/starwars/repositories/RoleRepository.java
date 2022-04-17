package axiomq.com.starwars.repositories;

import axiomq.com.starwars.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
