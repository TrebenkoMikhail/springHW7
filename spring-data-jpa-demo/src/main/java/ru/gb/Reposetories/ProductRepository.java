package ru.gb.Reposetories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.gb.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    Long getProductById(Long id);
    List<Product> getAllProducts();
    List<Product> addProduct(String title);
    void deleteById(Long id);
    Product save(Product product);

}
