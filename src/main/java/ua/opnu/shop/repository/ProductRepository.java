package ua.opnu.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.shop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> { }