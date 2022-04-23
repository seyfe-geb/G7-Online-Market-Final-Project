package com.waa.g7onlinemarket.services;



import com.waa.g7onlinemarket.models.dto.ProductDto;
import com.waa.g7onlinemarket.models.dto.SaveProductDto;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    List<ProductDto> findAllByUserId();

    ProductDto findById(long id);

    ProductDto add(SaveProductDto dto) throws ValidationException;

    void deleteById(long id) throws ValidationException;

    ProductDto updateById(long id, SaveProductDto dto);

}
