package rest.webservice.restfulwebservice.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        //  All requests should be authenticated
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
                );

       // If a request is not authenticated, use http basic
        httpSecurity.httpBasic(Customizer.withDefaults());

        // diable CSRF -> POST, PUT
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}
