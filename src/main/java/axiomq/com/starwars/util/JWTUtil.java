package axiomq.com.starwars.util;

import axiomq.com.starwars.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JWTUtil {


    @Value("${spring.security.secret-key}")
    private String secretKey;

    @Value("${spring.security.token-duration}")
    private Integer tokenDuration;

    public String getJWTToken(User user){
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
