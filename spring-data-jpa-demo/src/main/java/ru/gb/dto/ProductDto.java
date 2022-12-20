package ru.gb.dto;

import ru.gb.Product;

public class ProductDto extends Product {
    private  Long id;
    private  String title;
    private int price;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

public ProductDto(Product product){
        this.title = product.getTitle();
        this.id = product.getId();
        this.price = getPrice();
}
}
