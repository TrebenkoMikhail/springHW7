package ru.gb.cart;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.dto.ProductDto;

import java.util.ArrayList;

@Data
@Slf4j
@Service
public class CartService {

    private  ArrayList<CartProductDto> cartProductDtoList = new ArrayList<>();

    public void delete(Long id) {
        ArrayList<CartProductDto> cartProductDtoForIteration = ArrayList<>(cartProductDtoList);
        for (CartProductDto product : cartProductDtoForIteration) {
            if (product.getId().equals(id)) {
                cartProductDtoList.remove(product);
            }
        }
    }

    public CartProductDto addProduct (ProductDto productDto) {
        boolean isExist = false;
        CartProductDto cartProductDto = new CartProductDto(
                    productDto.getId(),
                    productDto.getTitle(),
                    productDto.getPrice(),
        1);
        for (CartProductDto product : cartProductDtoList) {
            if (product.getId().equals(productDto.getId())) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            cartProductDtoList.add(cartProductDto);
        }
        return cartProductDto;
    }

    public CartProductDto changeProductCount(Long id, Integer count) {
        ArrayList<CartProductDto> cartProductsForIteration = new ArrayList<>();
        Integer newCount;
        CartProductDto cartProductDto = null;
        for (CartProductDto product : cartProductsForIteration) {
            if (product.getId().equals(id)) {
                newCount = product.getCount() + count;
                if (newCount < 1) {
                    newCount = 1;
                }
                CartProductDto newCartProduct = new CartProductDto(
                        product.getId(),
                        product.getTitle(),
                        product.getPrice(),
                        newCount);
                newNewCartProductDto = newCartProduct;
                cartProductDtoList.remove(product);
                cartProductDtoList.add(newCartProduct);
                break;
            }
        }
        return newNewCartProductDto;
    }
}
