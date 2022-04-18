package axiomq.com.starwars.services;

import axiomq.com.starwars.entities.JwtRequest;
import axiomq.com.starwars.entities.JwtResponse;
import axiomq.com.starwars.entities.User;
import axiomq.com.starwars.repositories.UserRepository;
import axiomq.com.starwars.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class JwtService implements UserDetailsService {

    private UserRepository userRepository;

    private JwtUtil jwtUtil;

    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception{
        String userName = jwtRequest.getUsername();
        String password = jwtRequest.getPassword();
        authenticate(userName, password);

        final UserDetails userDetails = loadUserByUsername(userName);

        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        User user = userRepository.findByUsername(userName).get();

        return new JwtResponse(user, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).get();
        if(user != null){
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    getAuthorities(user));
        }else{
            throw new UsernameNotFoundException("Username is not valid");

        }
    }

    private Set getAuthorities(User user){
        Set authorities = new HashSet();

        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole().name()));
        });

        return authorities;
    }

    private void authenticate(String userName, String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        }catch (DisabledException e){
            throw  new Exception("User is disabled");
        } catch (BadCredentialsException e){
            throw new Exception(("Bad credentials from user"));
        }

    }
}
