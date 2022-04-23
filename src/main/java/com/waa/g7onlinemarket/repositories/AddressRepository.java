package com.waa.g7onlinemarket.repositories;


import com.waa.g7onlinemarket.models.Address;
import com.waa.g7onlinemarket.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
//    @Query("select  a from Address a WHERE a.user :user")
    List<Address> findAddressByUser(User user);
}
