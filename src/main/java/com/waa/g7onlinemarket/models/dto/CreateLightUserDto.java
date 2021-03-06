package com.waa.g7onlinemarket.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateLightUserDto {
    @NotBlank
    private String username;

    @NotBlank
    private String fname;
    @NotBlank
    private String lname;

    @Email
    private String email;

    @NotBlank
    private String password;
    @NotBlank
    private String rePassword;
}
