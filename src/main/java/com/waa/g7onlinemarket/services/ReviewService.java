package com.waa.g7onlinemarket.services;



import com.waa.g7onlinemarket.models.dto.LightReviewDto;
import com.waa.g7onlinemarket.models.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findAll();

    List<ReviewDto> findAllByApproved(boolean approved);

    ReviewDto findById(long id);

    LightReviewDto add(LightReviewDto dto);

    void deleteById(long id);

    LightReviewDto updateById(long id, LightReviewDto dto);

    ReviewDto approveById(long id);
}
