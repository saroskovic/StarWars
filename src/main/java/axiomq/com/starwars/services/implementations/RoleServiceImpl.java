package axiomq.com.starwars.services.implementations;

import axiomq.com.starwars.entities.Role;
import axiomq.com.starwars.repositories.RoleRepository;
import axiomq.com.starwars.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> fetchAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new NoSuchElementException(String.format("Role: %d not find", roleId)));
    }

    @Override
    public Role updateRole(Long roleId, Role newRole) {
        Role role = getRoleById(roleId);
        role.setName(newRole.getName());
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        Role role = getRoleById(roleId);
        roleRepository.delete(role);
    }
}
