package com.waa.g7onlinemarket.models.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShoppingCartItemDto {
    private long id;

    @JsonBackReference
    private ShoppingCartDto cart;

    private int quantity;

    private ProductDto product;
}
