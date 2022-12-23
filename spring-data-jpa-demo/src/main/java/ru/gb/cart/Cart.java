package ru.gb.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.Product;
import ru.gb.converters.ProductConverter;
import ru.gb.dto.ProductDto;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.sun.crypto.provider.AESCrypt.log;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private ProductConverter productConverter;
    private Cart cart;
    private List<CartProductDto> productDtoList;
    private String title;
    private  int quantity;
    private  int price;

    @PostConstruct
    private  void  createCart () {
        productDtoList = new ArrayList<>();
    }
    public  void addProductToCart(Product product) {
        ProductDto productDto = productConverter.entityToDto(product);
        cart.getProductDtoList().add(productDto);
        cart.setPrice(productDto.getPrice());
        cart.setQuantity(cart.getProductDtoList().size());
        log.debug(String.valueOf(cart.getProductDtoList()));
        System.out.println(cart.getProductDtoList());
    }

    public void delete(Long id) {
        List<CartProductDto> cartProducts = cart.getProductDtoList();
        for (int i = 0; i < cartProducts.size(); i++) {
            if (cartProducts.get(i).getId().equals(id)) {
                cartProducts.remove(i);
            }
        }
    }
    public void clear() {
        cart.getProductDtoList().clear();
    }


}
