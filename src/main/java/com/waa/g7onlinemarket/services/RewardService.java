package com.waa.g7onlinemarket.services;


import com.waa.g7onlinemarket.models.dto.RewardDto;
import com.waa.g7onlinemarket.models.dto.SaveRewardDto;

import java.util.List;

public interface RewardService {
    List<RewardDto> findAll();
    RewardDto findById(long id);

    RewardDto add(SaveRewardDto dto);
    RewardDto updateById(long id, SaveRewardDto dto);

    void deleteById(long id);
}
