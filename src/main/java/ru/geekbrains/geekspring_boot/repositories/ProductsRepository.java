package ru.geekbrains.geekspring_boot.repositories;

import ru.geekbrains.geekspring_boot.entites.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsRepository {
    private List<Product> products;

    public ProductsRepository() {

        products = new ArrayList<>();

        for (int i = 1; i < 11; i++)
            products.add(new Product(i, "Pr_" + i, i * 100));
    }

    public Product findOneById(int id) {
        for (Product product: products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return new Product();
    }

    public List<Product> findAll() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}