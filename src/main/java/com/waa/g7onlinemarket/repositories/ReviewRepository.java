package com.waa.g7onlinemarket.repositories;

import com.waa.g7onlinemarket.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByIsApproved(boolean approved);
}
