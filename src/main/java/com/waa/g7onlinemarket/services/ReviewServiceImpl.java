package com.waa.g7onlinemarket.services;


import com.waa.g7onlinemarket.models.Review;
import com.waa.g7onlinemarket.models.dto.LightReviewDto;
import com.waa.g7onlinemarket.models.dto.ReviewDto;
import com.waa.g7onlinemarket.repositories.ReviewRepository;
import com.waa.g7onlinemarket.util.service.LoggedInUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository repository;
    private final ModelMapper modelMapper;
    private final LoggedInUserService loggedInUserService;

    @Override
    public List<ReviewDto> findAll() {
        return repository.findAll().stream()
                .map(r -> modelMapper.map(r, ReviewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDto> findAllByApproved(boolean approved) {
        return repository.findAllByIsApproved(approved).stream()
                .map(r -> modelMapper.map(r, ReviewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDto findById(long id) {
        return modelMapper.map(repository.findById(id).orElse(null), ReviewDto.class);
    }

    @Override
    public LightReviewDto add(LightReviewDto dto) {
        Review review = modelMapper.map(dto, Review.class);
        review.setUser(loggedInUserService.getLoggedInUser());

        return modelMapper.map(repository.save(review), LightReviewDto.class);
    }

    @Override
    public LightReviewDto updateById(long id, LightReviewDto dto) {
        Review review = repository.getById(id);
        review.setComment(dto.getComment());
        review.setRating(dto.getRating());

        return modelMapper.map(repository.save(review), LightReviewDto.class);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public ReviewDto approveById(long id) {
        Review review = repository.getById(id);
        review.setApproved(true);
        return modelMapper.map(repository.save(review), ReviewDto.class);
    }
}
