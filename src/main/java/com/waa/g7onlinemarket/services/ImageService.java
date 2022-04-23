package com.waa.g7onlinemarket.services;


import com.waa.g7onlinemarket.models.dto.ImageDto;

import java.util.List;

public interface ImageService {

    List<ImageDto> findAll();

    ImageDto findById(long id);

    ImageDto add(ImageDto dto);

    ImageDto updateById(long id, ImageDto dto);

    void deleteById(long id);
}
