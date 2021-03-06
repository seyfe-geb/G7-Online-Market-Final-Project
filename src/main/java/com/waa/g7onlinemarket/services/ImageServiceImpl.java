package com.waa.g7onlinemarket.services;

import com.waa.g7onlinemarket.models.Image;
import com.waa.g7onlinemarket.models.dto.ImageDto;
import com.waa.g7onlinemarket.repositories.ImageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService{

    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;

    public ImageServiceImpl(ImageRepository imageRepository, ModelMapper modelMapper) {
        this.imageRepository = imageRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<ImageDto> findAll() {
        return imageRepository.findAll().stream()
                .map(i -> modelMapper.map(i, ImageDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ImageDto findById(long id) {
        return modelMapper.map(imageRepository.findById(id).orElse(null), ImageDto.class);
    }

    @Override
    public ImageDto add(ImageDto dto) {
        return modelMapper.map(imageRepository.save(modelMapper.map(dto, Image.class)), ImageDto.class);
    }

    @Override
    public ImageDto updateById(long id, ImageDto dto) {
        dto.setId(id);
        return modelMapper.map(imageRepository.save(modelMapper.map(dto, Image.class)), ImageDto.class);
    }

    @Override
    public void deleteById(long id) {
        imageRepository.deleteById(id);
    }
}
