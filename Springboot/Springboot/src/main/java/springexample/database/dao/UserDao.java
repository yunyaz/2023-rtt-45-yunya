package springexample.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springexample.database.entity.User;

public interface UserDAO extends JpaRepository<User, Long> {

    User findByEmail(String email);

    boolean existsByEmail(String email);

}
