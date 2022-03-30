package axiomq.com.starwars.services;

import axiomq.com.starwars.entities.Users;

import java.util.List;

public interface UsersService {

    Users createUser(Users user);

    List<Users> fetchAllUsers();

    Users getUserById(Long userIs);

    Users updateUser(Long userId, Users user);

    void deleteUser(Long userId);


}
