package by.iba.springboot.tereh.springbootapp.repository;

import by.iba.springboot.tereh.springbootapp.model.Tables;
import by.iba.springboot.tereh.springbootapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findOneByUsername(String username);
    Optional<User> findUserById(Long id);
}
