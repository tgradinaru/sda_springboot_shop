package com.sda.traiangradinaru.webshop.controller;

import com.sda.traiangradinaru.webshop.error.ResourceNotFoundException;
import com.sda.traiangradinaru.webshop.model.Product;
import com.sda.traiangradinaru.webshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products") //<- aici e implementarea, aceasta adnotare
    public List<Product> getAllProducts() {  //metoda asta nu are legatura cu REST
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
        Optional<Product> product = productService.findById(productId);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        }
        throw new ResourceNotFoundException("product with id: " + productId + " was not found!");
    }

    @PostMapping("/products")
    public String createProduct(@RequestBody Product product) {
        productService.save(product);
        return "Product saved";
    }
}
