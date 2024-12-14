package mk.ukim.finki.wp.lab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig {


    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("elena.atanasoska")
                .password(passwordEncoder().encode("ea"))
                .roles("USER")
                .build();

        UserDetails user2 = User.builder()
                .username("darko.sasanski")
                .password(passwordEncoder().encode("ds"))
                .roles("USER")
                .build();

        UserDetails user3 = User.builder()
                .username("ana.todorovska")
                .password(passwordEncoder().encode("at"))
                .roles("USER")
                .build();

        UserDetails user4 = User.builder()
                .username("nikolas.kuzmanovski")
                .password(passwordEncoder().encode("nk"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3, user4, admin);
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}