package com.waa.g7onlinemarket.services;



import com.waa.g7onlinemarket.models.dto.*;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto findById(long id);
    UserProfileDto findProfile();

    UserDto add(CreateUserDto dto);
    UserDto updateById(long id, LightUserDto dto);
    void deleteById(long id);

    UserDto addBuyer(CreateLightUserDto dto);
    UserDto addSeller(CreateLightUserDto dto);

    boolean existsByUsername(String username);

    List<UnApprovedSellerDto> findSellersByApproved(boolean approved);

    UserDto approveById(long id);
}
