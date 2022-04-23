package com.waa.g7onlinemarket.services;


import com.waa.g7onlinemarket.models.dto.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAll();
    RoleDto findById(long id);

    RoleDto add(RoleDto dto);
    RoleDto updateById(long id, RoleDto dto);
    void deleteById(long id);

    boolean existsByAuthority(String name);
}
