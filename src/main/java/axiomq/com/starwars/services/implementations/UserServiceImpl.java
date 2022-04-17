package axiomq.com.starwars.services.implementations;

import axiomq.com.starwars.entities.User;
import axiomq.com.starwars.repositories.RoleRepository;
import axiomq.com.starwars.repositories.UserRepository;
import axiomq.com.starwars.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException(String.format("User: %d not found", userId)));
    }

    @Override
    public User updateUser(Long userId, User newUser) {
        User user = getUserById(userId);
        user.setEmail(newUser.getEmail());
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = getUserById(userId);
        userRepository.delete(user);

    }
}
