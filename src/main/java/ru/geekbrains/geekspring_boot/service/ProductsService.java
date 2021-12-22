package ru.geekbrains.geekspring_boot.service;


import ru.geekbrains.geekspring_boot.entites.Product;
import ru.geekbrains.geekspring_boot.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    public ProductsService() {
    }

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product getProductById(int id) {
        return productsRepository.findOneById(id);
    }

    public List<Product> getProducts() {
        return productsRepository.findAll();
    }

    public void addProduct(Product product) {
        productsRepository.addProduct(product);
    }
}