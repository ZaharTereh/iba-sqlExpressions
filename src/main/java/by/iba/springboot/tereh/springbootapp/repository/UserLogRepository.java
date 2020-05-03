package by.iba.springboot.tereh.springbootapp.repository;


import by.iba.springboot.tereh.springbootapp.model.User;
import by.iba.springboot.tereh.springbootapp.model.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLogRepository extends JpaRepository<UserLog,Long> {
    List<UserLog> findUserLogsByUserIs(User user);
}
