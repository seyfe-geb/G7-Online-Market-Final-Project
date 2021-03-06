package com.waa.g7onlinemarket.controllers;

import com.waa.g7onlinemarket.models.OrderStatus;
import com.waa.g7onlinemarket.models.Role;
import com.waa.g7onlinemarket.models.dto.OrderDto;
import com.waa.g7onlinemarket.models.dto.SaveOrderDto;
import com.waa.g7onlinemarket.services.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Orders")
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @GetMapping
    @PreAuthorize("hasRole('" + Role.ADMIN + "')")
    public List<OrderDto> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public OrderDto get(@PathVariable("id") long id){
        return service.findById(id);
    }

    @PostMapping
    public OrderDto add(@RequestBody SaveOrderDto dto) throws Exception {
        return service.add(dto);
    }

    @PutMapping("/change-order-status/{id}/{status}")
    public OrderDto changeOrderStatus(@PathVariable("id") long id, @PathVariable("status") OrderStatus status) throws Exception {
        return service.changeStatusById(id, status);
    }

    @GetMapping("/order-history")
    public List<OrderDto> getOrderHistory(){
        return service.findAllByUserId();
    }

    @GetMapping("/seller-orders")
    public List<OrderDto> getSellerOrders(){
        return service.findSellerOrders();
    }

}
