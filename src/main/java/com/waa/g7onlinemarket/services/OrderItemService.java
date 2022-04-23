package com.waa.g7onlinemarket.services;


import com.waa.g7onlinemarket.models.dto.OrderItemDto;
import com.waa.g7onlinemarket.models.dto.SaveOrderItemDto;

import java.util.List;

public interface OrderItemService {
    List<OrderItemDto> findAll();

    OrderItemDto findById(long id);

    SaveOrderItemDto add(SaveOrderItemDto dto);

    void deleteById(long id);
}
