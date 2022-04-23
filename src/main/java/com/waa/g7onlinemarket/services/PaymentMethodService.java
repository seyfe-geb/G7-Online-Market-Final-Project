package com.waa.g7onlinemarket.services;



import com.waa.g7onlinemarket.models.dto.PaymentMethodDto;
import com.waa.g7onlinemarket.models.dto.SavePaymentMethodDto;

import java.util.List;


public interface PaymentMethodService {
    List<PaymentMethodDto> findAll();
    PaymentMethodDto findById(long id);
    PaymentMethodDto add(SavePaymentMethodDto dto);
    PaymentMethodDto updateById(long id, SavePaymentMethodDto dto);
    void deleteById(long id);
}
