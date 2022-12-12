package ru.gb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFilter {
    @Autowired
    private ProductRepository repository;
    @EventListener(ApplicationReadyEvent.class)
    public  void  fillDatabaseOnMinMax(){
        repository.sort(Product.price);
    }
    private Product createProduct(String title){
        Product product = new Product();
        product.setTitle(title);
        return product;
    }
}
