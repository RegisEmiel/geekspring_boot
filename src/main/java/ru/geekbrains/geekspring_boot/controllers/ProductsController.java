package ru.geekbrains.geekspring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.geekspring_boot.entites.Product;
import ru.geekbrains.geekspring_boot.service.ProductsService;


import java.util.List;

@RequestMapping("/product")
@Controller
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    //Показать страницу со списком продуктов
    //http://localhost:8189/product/showProducts
    @RequestMapping("/showProducts")
    public String showProducts(Model Model) {
        Model.addAttribute("products", productsService.getProducts());
        return "products";
    }

    //Получить json со списком продуктов
    //http://localhost:8189/product/findAll
    @GetMapping("/findAll")
    @ResponseBody
    public List<Product> findAllUsers() {
        return productsService.getProducts();
    }

    //Получить json продукта по id
    //http://localhost:8189/product/showProductById?id=1
    @RequestMapping(path = "/showProductById", method = RequestMethod.GET)
    @ResponseBody
    public Product showProductById(Model uiModel, @RequestParam int id) {
        return productsService.getProductById(id);
    }

    //Получить json продукта по id
    //http://localhost:8189/product/showProductById/1
    @RequestMapping(path = "/showProductById/{sid}", method = RequestMethod.GET)
    @ResponseBody
    public Product showProductById(@PathVariable("sid") int id) {
        return productsService.getProductById(id);
    }


    //Открыть страничку ввода данных и добавления нового продукта
    //http://localhost:8189/product/addProductForm
    @GetMapping("/addProductForm")
    public String showSimpleForm(Product product) {
        return "products-form";
    }

    @PostMapping("/addProductForm")
    public String processForm(Product product) {
        productsService.addProduct(product);
        return "product-form-result";
    }
}
