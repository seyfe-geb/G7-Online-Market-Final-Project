package com.waa.g7onlinemarket.services;


import com.waa.g7onlinemarket.models.PaymentMethod;
import com.waa.g7onlinemarket.models.dto.PaymentMethodDto;
import com.waa.g7onlinemarket.models.dto.SavePaymentMethodDto;
import com.waa.g7onlinemarket.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService{

    private final PaymentMethodRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<PaymentMethodDto> findAll() {
        return repository.findAll().stream()
                .map(p -> modelMapper.map(p, PaymentMethodDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PaymentMethodDto findById(long id) {
        return modelMapper.map(repository.findById(id).orElse(null), PaymentMethodDto.class);
    }

    @Override
    public PaymentMethodDto add(SavePaymentMethodDto dto) {
        PaymentMethod entity = modelMapper.map(dto, PaymentMethod.class);
        return modelMapper.map(repository.save(entity), PaymentMethodDto.class);
    }

    @Override
    public PaymentMethodDto updateById(long id, SavePaymentMethodDto dto) {
        PaymentMethod entity = modelMapper.map(dto, PaymentMethod.class);
        entity.setId(id);

        return modelMapper.map(repository.save(entity), PaymentMethodDto.class);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
