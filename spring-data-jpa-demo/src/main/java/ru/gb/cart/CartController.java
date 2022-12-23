package ru.gb.cart;

import lombok.RequiredArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import ru.gb.Product;
import ru.gb.ProductService;
import ru.gb.converters.ProductConverter;
import ru.gb.dto.ProductDto;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CartController {
    private final ProductConverter productConverter;
    private final ProductService productService;
    private final CartService cartService;
    private int count;
    @GetMapping
    public List<CartProductDto> getCartList(){
        return cartService.getCartProductDto(productDto);
    }

    @PostMapping
    public CartProductDto addProductToCart(@RequestParam (value = "id") Long id) {
        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("File not found, id: " + id));
        ProductDto productDto = productConverter.entityToDto(product);
        return cart.addProduct(productDto);
    }
    @PutMapping
    public CartProductDto updateProductCount(@RequestParam (value = "id") Long id, @RequestParam (value = "count") Integer count) {
        productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("File not found, id: " + id));
        return cart.changeProductCount(id, count);
    }
    @DeleteMapping("/{id}")
    public  void deleteById(@PathVariable Long id){

    }

}
