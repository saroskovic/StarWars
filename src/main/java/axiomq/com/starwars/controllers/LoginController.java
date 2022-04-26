package axiomq.com.starwars.controllers;

import axiomq.com.starwars.entities.User;
import axiomq.com.starwars.entities.dto.UserDto;
import axiomq.com.starwars.services.UserService;
import axiomq.com.starwars.util.Encryption;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    @Value("${spring.security.secret-key}")
    private String secretKey;

    @Value("${spring.security.token-duration}")
    private Integer tokenDuration;

    private final UserService userService;

    @PostMapping()
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
