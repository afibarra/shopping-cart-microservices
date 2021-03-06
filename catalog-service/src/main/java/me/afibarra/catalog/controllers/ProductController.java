package me.afibarra.catalog.controllers;

import lombok.extern.slf4j.Slf4j;
import me.afibarra.catalog.model.Product;
import me.afibarra.catalog.services.IProductService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> allProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/{code}")
    public Product productByCode(@PathVariable String code) {
        return productService.findProductByCode(code).orElseThrow(
                () -> new RuntimeException("Product with code: " + "code " + " was not found.")
        );
    }
}
