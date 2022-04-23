package com.waa.g7onlinemarket.services;



import com.waa.g7onlinemarket.models.dto.*;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCartDto findCart();

    ShoppingCartDto updateCart(SaveShoppingCartDto dto);

    List<ShoppingCartItemDto> findAllItems();
    ShoppingCartItemDto findItemById(long id);

    ShoppingCartItemDto addItem(CreateShoppingCartItemDto dto);
    ShoppingCartItemDto updateItemById(long id, UpdateShoppingCartItemDto dto);

    void deleteItemById(long id);
}
