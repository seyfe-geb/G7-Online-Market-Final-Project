package com.waa.g7onlinemarket.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SaveShoppingCartDto {
    private Set<CreateShoppingCartItemDto> items = new HashSet<>();
}
