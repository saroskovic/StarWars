package axiomq.com.starwars.controllers;

import axiomq.com.starwars.entities.User;
import axiomq.com.starwars.entities.dto.UserDto;
import axiomq.com.starwars.services.UserService;
import axiomq.com.starwars.util.Encryption;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Value("${spring.security.secret-key}")
    private String secretKey;

    @Value("${spring.security.token-duration}")
    private Integer tokenDuration;

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("user") String email, @RequestParam("password") String pwd){
        User user = userService.findByEmail(email)
                .orElseThrow(()-> new NoSuchElementException(String.format("Could not find user: {}", email)));
        if(user != null && Encryption.validatePassword(pwd, user.getPassword())){
            String token = getJWTToken(user);
            UserDto userDto = new UserDto();
            userDto.setUser(email);
            userDto.setToken(token);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
        return new ResponseEntity<>("Wrong credentials", HttpStatus.UNAUTHORIZED);
    }

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

    private String getJWTToken(User user){
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(user.getRole().getName().toString());
        String token = Jwts.builder().setId("JWT").setSubject(user.getEmail())
                .claim("authorities", grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + this.tokenDuration))
                .signWith(SignatureAlgorithm.HS512, this.secretKey.getBytes()).compact();
        return "Bearer " + token;
    }
}
