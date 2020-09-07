package me.afibarra.catalog.services;

import me.afibarra.catalog.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAllProducts();

    Optional<Product> findProductByCode(String code);
}
