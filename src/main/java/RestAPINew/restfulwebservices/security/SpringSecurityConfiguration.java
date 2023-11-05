package RestAPINew.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class SpringSecurityConfiguration {
    @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //all requests should be authenticated
        http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
        //If a request is not authorized,a webpage is shown
        http.httpBasic(withDefaults());
        //csrf->POST,PUT
        http.csrf().disable();

        return http.build();
    }
}
