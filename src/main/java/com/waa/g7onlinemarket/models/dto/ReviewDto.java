package com.waa.g7onlinemarket.models.dto;


import com.waa.g7onlinemarket.models.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewDto {
    private long id;

    private Rating rating;

    private String comment;

    private boolean isApproved;

    private long productId;

    private LightUserDto user;
}
