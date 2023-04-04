package springexample.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springexample.database.entity.Employee;
import springexample.database.entity.Office;

import java.util.List;

public interface OfficeDAO extends JpaRepository<Office, Long> {

    @Query("FROM Office o order by o.city asc")
    List<Office> getAllOffices();
}
