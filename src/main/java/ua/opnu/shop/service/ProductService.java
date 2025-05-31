package ua.opnu.shop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ua.opnu.shop.model.Product;
import ua.opnu.shop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {this.productRepository = productRepository;}

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductsById(Long id){
        return productRepository.findById(id);
    }

    public void createProduct(Product product){
        productRepository.save(product);
    }
}
