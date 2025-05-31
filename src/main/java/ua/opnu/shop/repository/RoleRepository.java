package ua.opnu.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.shop.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(String name);

}
