package me.afibarra.catalog.services;

import lombok.extern.slf4j.Slf4j;
import me.afibarra.catalog.model.Product;
import me.afibarra.catalog.repositories.IProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductByCode(String code) {
        return productRepository.findByCode(code);
    }
}
