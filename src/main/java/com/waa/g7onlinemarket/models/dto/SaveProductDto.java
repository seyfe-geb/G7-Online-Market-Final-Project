package com.waa.g7onlinemarket.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SaveProductDto {
    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    private double price;

    @NotNull
    private String description;

    @NotNull
    private int quantity;

    private List<ImageDto> images;
}
