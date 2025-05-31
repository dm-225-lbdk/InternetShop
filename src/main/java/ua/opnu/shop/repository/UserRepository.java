package ua.opnu.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.shop.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
