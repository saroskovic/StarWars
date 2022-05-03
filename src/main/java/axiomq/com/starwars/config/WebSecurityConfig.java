package axiomq.com.starwars.config;

import axiomq.com.starwars.enums.UserType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.secret-key}")
    private String secretKey;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers("/api/**").hasAnyAuthority(UserType.ROLE_USER.name(), UserType.ROLE_ADMIN.name())
                .antMatchers("/admin/**").hasAnyAuthority(UserType.ROLE_ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .addFilterAfter(new JWTAuthorizationFilter(secretKey),
                        UsernamePasswordAuthenticationFilter.class);
    }
}
