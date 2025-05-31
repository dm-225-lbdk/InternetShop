package ua.opnu.shop.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.opnu.shop.model.Product;
import ua.opnu.shop.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> GetProducts(){
        return productService.getAllProducts();

    }

    @GetMapping("/{id}")
    public Optional<Product> GetProductById(@PathVariable(value = "id") long id){
        return productService.getProductsById(id);
    }

    @PostMapping
    public void PostProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

}
