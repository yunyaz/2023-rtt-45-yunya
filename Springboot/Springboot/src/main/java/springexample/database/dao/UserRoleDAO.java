package springexample.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springexample.database.entity.UserRole;

import java.util.List;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(Integer id);
}
