package axiomq.com.starwars.controllers;

import axiomq.com.starwars.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<?> login(@RequestParam("user") String email, @RequestParam("password") String pwd){
       return userService.login(email, pwd);
    }

}
