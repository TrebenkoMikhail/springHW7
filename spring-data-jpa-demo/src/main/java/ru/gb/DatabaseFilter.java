package ru.gb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public abstract class DatabaseFilter extends ProductController implements ProductRepository{

    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductController productController;

    @EventListener(ProductRepository.class)
    public String sortByMinPrice(int price) {
        Sort.Order.by(String.valueOf(price));
        return String.valueOf(price);
    }

    @EventListener(ProductRepository.class)
    public String sortByMaxPrice(int price){
        Sort.Order.by(String.valueOf(price));
        return String.valueOf(price);
        }

    @EventListener(ProductRepository.class)
    public String sortByMinMaxPrice(int price){
        Sort.Order.by(String.valueOf(price));
        return String.valueOf(price);
    }


    private Product createProduct(String title){
        Product product = new Product();
        product.setTitle(title);
        return product;
    }
}
