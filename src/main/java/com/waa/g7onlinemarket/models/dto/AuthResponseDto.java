package com.waa.g7onlinemarket.models.dto;


import com.waa.g7onlinemarket.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthResponseDto {

    private String id;

    private String fname;

    private String lname;

    private String token;

    private List<Role> authorities;
}
