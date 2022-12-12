package ru.gb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, List<Product> {
    @Query(value = "select product from products where id = :id")
    Long getProductById(Long id);

    @Query(value = "select * product from products")
    List<Product> getAllProducts();

    @Query(value = "insert title from products where title= :title ")
    List<Product> addProduct(String title);
    @Query(value = "delete title from products where title= :title ")
    List<Product> delProduct(Long id);
}
