package axiomq.com.starwars.services.implementations;

import axiomq.com.starwars.entities.User;
import axiomq.com.starwars.entities.dto.UserDto;
import axiomq.com.starwars.repositories.UserRepository;
import axiomq.com.starwars.services.UserService;
import axiomq.com.starwars.util.Encryption;
import axiomq.com.starwars.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final JWTUtil jwtUtil;

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

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException(String.format("Could not find user: {}", email)));
    }

    @Override
    public ResponseEntity<?> login(String email, String pwd){
        User user = findByEmail(email);
        if(user != null && Encryption.validatePassword(pwd, user.getPassword())){
            String token = jwtUtil.getJWTToken(user);
            UserDto userDto = new UserDto();
            userDto.setUser(email);
            userDto.setToken(token);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
        return new ResponseEntity<>("Wrong credentials", HttpStatus.UNAUTHORIZED);
    }
}
