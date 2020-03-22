package stancis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@Profile("user-pass-auth")
public class UserPasswordAuthConfig extends WebSecurityConfigurerAdapter {
  @Bean
  @Override
  public UserDetailsService userDetailsService() {
    return new InMemoryUserDetailsManager(
        User.builder().username("user").password(passwordEncoder().encode("user")).roles("USER").build(),
        User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}