package com.waa.g7onlinemarket.models.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemDto {

    private long id;

    private int quantity;

    private ProductDto product;

    @JsonBackReference
    private OrderDto order;
}
