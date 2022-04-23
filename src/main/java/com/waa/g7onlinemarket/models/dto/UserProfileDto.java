package com.waa.g7onlinemarket.models.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserProfileDto extends UserDto{
    private String username;

    @JsonManagedReference
    private List<AddressDto> addresses;


    @JsonManagedReference
    private List<PaymentMethodDto> paymentMethods;
}
