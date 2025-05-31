package ua.opnu.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.shop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
