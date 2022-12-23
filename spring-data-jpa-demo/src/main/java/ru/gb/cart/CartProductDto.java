package ru.gb.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class CartProductDto {

    private final List<CartProductDto> cartProductDtoList;
    public List<CartProductDto> getId(Long id) {
        cartProductDtoList.get(id);
    }
}
