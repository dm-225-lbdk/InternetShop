package ua.opnu.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.opnu.shop.model.Product;
import ua.opnu.shop.service.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productService.getProductsById(id);
        model.addAttribute("isProduct", product.isPresent());
        product.ifPresent(value -> model.addAttribute("product", value));
        return "product";
    }

    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        productService.createProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-create";
    }

}
