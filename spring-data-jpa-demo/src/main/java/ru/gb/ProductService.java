package ru.gb;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.Reposetories.ProductRepository;
import ru.gb.Specifications.ProductSpecifications;
import ru.gb.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Page<Product> find(Integer minPrice, Integer maxPrice, String partName, Integer page) {
        Specification<Product> spec = Specification.where(null);
        if (minPrice != null) {
            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThan(BigDecimal.valueOf(minPrice)));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecifications.priceLesserOrEqualsThan(BigDecimal.valueOf(maxPrice)));
        }
        if (partName != null) {
                spec = spec.and(ProductSpecifications.titleLike(partName));
        }
        return productRepository.findAll(spec, PageRequest.of(page -1, 5));
    }
    public List<Product> getAllProducts(){return productRepository.findAll();}
    public Optional<Product> findById(Long id) {return productRepository.findById(id);}
    public List<Product> deleteById(Long id) {return productRepository.deleteById(id);
    }


    @Transactional
    public void changePrice(Long productId, Integer delta) {
        Product product = productRepository.findById(productId).orElseThrow()-> new ServerProperties.Tomcat.Resource();
                product.setPrice(product.getPrice() + delta);
    }

    public ProductDto save(ProductDto dto) {return (ProductDto) productRepository.save(dto);
    }
}
