package nl.inholland.apidemo.service;

import nl.inholland.apidemo.model.User;
import nl.inholland.apidemo.repository.UserRepository;
import nl.inholland.apidemo.security.JwtTokenProvider;
import nl.inholland.apidemo.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private AuthenticationManager manager;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  private UserRepository userRepository;

  public String login(String username, String password) {
    try {
      manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
      return jwtTokenProvider.createToken(username, userRepository.findUserByUsername(username).getRoles());
    } catch (AuthenticationException ae) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid credentials");
    }
  }

  public String add(String username, String password, List<Role> roles) {
    if (userRepository.findUserByUsername(username) == null) {
      User user = new User();
      user.setUsername(username);
      user.setPassword(passwordEncoder().encode(password));
      if (roles.size() == 0) {
        user.setRoles(List.of(Role.ROLE_USER, Role.ROLE_ADMIN));

      } else {
        user.setRoles(roles);
      }
      System.out.println(user);
      userRepository.save(user);
      return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
    } else {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Username already in use");
    }
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
  }
}