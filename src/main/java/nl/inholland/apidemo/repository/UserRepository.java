package nl.inholland.apidemo.repository;

import nl.inholland.apidemo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  User findUserByUsername(String username);
}
