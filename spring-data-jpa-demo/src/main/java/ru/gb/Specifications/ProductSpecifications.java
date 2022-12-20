package ru.gb.Specifications;


import org.springframework.data.jpa.domain.Specification;
import ru.gb.Product;

import java.math.BigDecimal;

import static antlr.build.ANTLR.root;

public class ProductSpecifications {
    public static Specification<Product> priceGreaterOrEqualsThan(BigDecimal minPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }
    public static Specification<Product> priceLesserOrEqualsThan(BigDecimal maxPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }
    public static Specification<Product> titleLike(String titlePart) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%",titlePart));
    }
    public static Specification<Product> genreIs(Long genreId) {
        return (Specification<Product>) (root, criteriaQuery, criteraBuilder) -> criteraBuilder.equal(root.get("genre").get("id"), genreId);
    }


}
