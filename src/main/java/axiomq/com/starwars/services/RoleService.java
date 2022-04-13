package axiomq.com.starwars.services;


import axiomq.com.starwars.entities.Role;

import java.util.List;

public interface RoleService {

    Role saveRole(Role role);

    List<Role> fetchAllRoles();

    Role getRoleById(Long roleId);

    Role updateRole(Long roleId, Role role);

    void deleteRole(Long roleId);

}
