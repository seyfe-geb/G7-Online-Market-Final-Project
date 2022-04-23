package com.waa.g7onlinemarket.repositories;


import com.waa.g7onlinemarket.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
