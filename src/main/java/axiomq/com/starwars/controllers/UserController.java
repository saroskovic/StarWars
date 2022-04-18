package axiomq.com.starwars.controllers;

import axiomq.com.starwars.entities.User;
import axiomq.com.starwars.services.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @GetMapping
    public List<User> fetchAllUsers() {
        return userService.fetchAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/foradmin")
    public String forAdmin(){
        return "This URL is for admin only";
    }

    @GetMapping("/foruser")
    public String forUser(){
        return "This URL is for user only";
    }


}
