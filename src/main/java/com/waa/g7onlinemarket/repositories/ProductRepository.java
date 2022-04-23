package com.waa.g7onlinemarket.repositories;

import com.waa.g7onlinemarket.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByUserId(long userId);
}
