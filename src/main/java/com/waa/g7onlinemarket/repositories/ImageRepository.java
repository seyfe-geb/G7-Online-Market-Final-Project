package com.waa.g7onlinemarket.repositories;

import com.waa.g7onlinemarket.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
