package ua.opnu.shop.init;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.opnu.shop.model.*;
import ua.opnu.shop.repository.*;

import java.util.List;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OrderItemRepository orderItems;
    private final OrderRepository orders;
    private final ProductRepository products;
    private final UserRepository users;
    private final RoleRepository roles;

    public DataInitializer(OrderItemRepository orderItems, OrderRepository orders, ProductRepository products, UserRepository users, RoleRepository roles) {
        this.orderItems = orderItems;
        this.orders = orders;
        this.products = products;
        this.users = users;
        this.roles = roles;
    }

    @Override
    @Transactional
    public void run(String... args) {

        Role userRole = new Role(null, "ROLE_USER");
        Role adminRole = new Role(null, "ROLE_ADMIN");

        roles.saveAll(List.of(adminRole, userRole));

        User user = new User(null, "user",
                "userpass",
                "useremail@gmail.com",
                Set.of(userRole));
        User admin = new User(null,
                "admin",
                "adminpass",
                "adminemail@gmail.com",
                Set.of(adminRole));

        user = users.save(user);
        admin = users.save(admin);

        List<Product> savedProducts = products.saveAll(List.of(
                new Product("Laptop", "Electronics", 1200.00, 10),
                new Product("Smartphone", "Electronics", 800.00, 15),
                new Product("Headphones", "Electronics", 50.00, 30)
        ));

        Order order1 = orders.save(new Order(user.getLogin(), 5L));
        Order order2 = orders.save(new Order(user.getLogin(), 23L));
        Order order3 = orders.save(new Order(admin.getLogin(), 14L));

        orderItems.saveAll(List.of(
                new OrderItem(order2, savedProducts.get(1), 2),
                new OrderItem(order2, savedProducts.get(2), 1),
                new OrderItem(order3, savedProducts.get(1), 6)
        ));
    }

}

