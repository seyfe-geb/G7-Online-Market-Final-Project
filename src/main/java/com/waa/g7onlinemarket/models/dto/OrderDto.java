package com.waa.g7onlinemarket.models.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.waa.g7onlinemarket.models.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDto {

    private long id;

    private OrderStatus status;

    private Date createdAt;
    private Date modifiedAt;

    @NotNull
    private double price;

    @JsonManagedReference
    private List<OrderItemDto> orderItems;

    private AddressDto shippingAddress;

    private PaymentMethodDto paymentMethod;

    private LightUserDto user;

    private String invoiceUri;
}
