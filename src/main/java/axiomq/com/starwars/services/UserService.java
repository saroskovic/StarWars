package axiomq.com.starwars.services;

import axiomq.com.starwars.entities.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> fetchAllUsers();

    User getUserById(Long userId);

    User updateUser(Long userId, User user);

    void deleteUser(Long userId);


}
