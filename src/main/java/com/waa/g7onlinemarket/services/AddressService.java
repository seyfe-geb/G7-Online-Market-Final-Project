package com.waa.g7onlinemarket.services;



import com.waa.g7onlinemarket.models.dto.AddressDto;
import com.waa.g7onlinemarket.models.dto.SaveAddressDto;

import java.util.List;

public interface AddressService {
    List<AddressDto> findAll();

    AddressDto findById(long id);

    AddressDto add(SaveAddressDto dto);

    void deleteById(long id);

    AddressDto updateById(long id, SaveAddressDto dto);
}
