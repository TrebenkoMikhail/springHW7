package ru.gb.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.gb.Product;
import ru.gb.ProductService;
import ru.gb.Reposetories.ProductRepository;
import ru.gb.dto.ProductDto;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController  {

    ProductService productService;

    @GetMapping(value = "/{id}")
    public Long getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow().getId();
    }

    @GetMapping(value = "/all")
    public Page<ProductDto> getAllProducts(
            @RequestParam (name = "p", defaultValue = "1") Integer page,
            @RequestParam (name = "min_price", defaultValue = "0") Integer minPrice,
            @RequestParam (name = "max_price", defaultValue = "1000") Integer maxPrice,
            @RequestParam (name = "name_part", required = false) String namePart
    ) {
        if (page < 1) {
            page = 1;
    }
        return  productService.find(minPrice,maxPrice,namePart,page).map(
                p -> new ProductDto(p)
        );
    }

    @GetMapping
    public List<Product> addProduct(@RequestParam  Product title) {
        productService.save((ProductDto) createProduct("Mango"));
            return (List<Product>) productService;
    }

    @DeleteMapping(value = "/{id}")
        public List<Product> deleteById (@RequestParam Long id) {
        return productService.deleteById(id);
    }
    @PostMapping
        public Product save(Product product) {
        product.setId(null);
        return productService.save((ProductDto) product);
        }
    @PutMapping
    public Product updateProd(Product product) {
        return productService.save((ProductDto) product);
    }


    private Product createProduct(String title) {
        Product product = new Product();
        product.setTitle(title);
        return product;
    }
    }