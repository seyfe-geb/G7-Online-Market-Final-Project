package com.waa.g7onlinemarket.repositories;

import com.waa.g7onlinemarket.models.User;
import com.waa.g7onlinemarket.models.dto.UnApprovedSellerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    @Query(name = "findSellersByApproved", nativeQuery = true)
    List<UnApprovedSellerDto> findSellersByApproved(boolean approved);
}
