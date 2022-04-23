package com.waa.g7onlinemarket.services;


import com.waa.g7onlinemarket.models.dto.CreateFollowerDto;
import com.waa.g7onlinemarket.models.dto.FollowDto;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface FollowService {
    List<FollowDto> findAll();

    FollowDto findById(long id);

    FollowDto add(CreateFollowerDto dto);

    void deleteById(long id);

    void unfollow(long followerId, long followeeId) throws ValidationException;
}
