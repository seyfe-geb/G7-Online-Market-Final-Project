package com.waa.g7onlinemarket.models.dto;


import com.waa.g7onlinemarket.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FollowDto {

    private Long id;

    private User follower;

    private User followee;
}
