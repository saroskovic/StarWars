package axiomq.com.starwars.controllers;

import axiomq.com.starwars.entities.Role;
import axiomq.com.starwars.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    @PostMapping("/createrole")
    public Role createNewRole(@RequestBody Role role){
        return roleService.saveRole(role);
    }
}
