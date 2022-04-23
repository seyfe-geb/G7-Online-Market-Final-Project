package com.waa.g7onlinemarket.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UnApprovedSellerDto {
    private long id;

    private String fname;
    private String lname;

    private String email;

    private Date createdAt;
    private Date modifiedAt;
}
