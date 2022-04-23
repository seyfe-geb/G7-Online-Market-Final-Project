package com.waa.g7onlinemarket.services;


import com.waa.g7onlinemarket.models.OrderStatus;
import com.waa.g7onlinemarket.models.dto.OrderDto;
import com.waa.g7onlinemarket.models.dto.SaveOrderDto;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface OrderService {
    List<OrderDto> findAll();
    List<OrderDto> findAllByUserId();
    List<OrderDto> findSellerOrders();

    OrderDto findById(long id);

    OrderDto add(SaveOrderDto dto) throws ValidationException;

    OrderDto changeStatusById(long id, OrderStatus status) throws ValidationException;
}
