package ru.gb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/app/products")
public abstract class ProductController implements ProductRepository{
    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/{id}")
    public Long getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow().getId();
    }

    @GetMapping(value = "/all")
    public List<Product> getAllProducts() {
        return productRepository.findAll();

    @GetMapping(value = "/add")
    public List<Product> addProduct(@RequestParam  title) {
            productRepository.save(createProduct("Mango"));
            return productRepository;
    }

    @GetMapping(value = "/del")
        public List<Product> delProduct(@PathVariable Long id) {
        productRepository.deleteById(id);

        }

}

    private Product createProduct(String title) {
        Product product = new Product();
        product.setTitle(title);
        return product;
    }
    }