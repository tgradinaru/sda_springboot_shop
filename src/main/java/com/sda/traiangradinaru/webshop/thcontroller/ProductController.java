package com.sda.traiangradinaru.webshop.thcontroller;

import com.sda.traiangradinaru.webshop.model.Product;
import com.sda.traiangradinaru.webshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String showProductsPage(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(value = "id") Long id, Model model){
        productService.delete(id);

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/add-product")
    public String showAddProductPage(Product product){
        return "add-product";
    }
    @PostMapping("/add-product")
    public String addProduct(@Valid Product product, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-product";
        } else{
            productService.save(product);
        }
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

}
