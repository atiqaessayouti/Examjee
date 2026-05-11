package ma.enset.atiqaessayouti.locationvehicule.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

        return new InMemoryUserDetailsManager(
                User.withUsername("client").password(passwordEncoder.encode("1234")).roles("CLIENT").build(),
                User.withUsername("employe").password(passwordEncoder.encode("1234")).roles("EMPLOYE").build(),
                User.withUsername("admin").password(passwordEncoder.encode("1234")).roles("ADMIN", "EMPLOYE").build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers("/api/vehicules/disponibles").hasAnyRole("CLIENT", "EMPLOYE", "ADMIN")
                        .requestMatchers("/api/vehicules/louer").hasRole("CLIENT") // الكراء للزبون فقط
                        .requestMatchers("/api/agences/**").hasAnyRole("EMPLOYE", "ADMIN") // الوكالات للموظفين
                        .anyRequest().authenticated()
                )
                .headers(h -> h.frameOptions(f -> f.disable()))
                .httpBasic(hb -> {});

        return http.build();
    }
}