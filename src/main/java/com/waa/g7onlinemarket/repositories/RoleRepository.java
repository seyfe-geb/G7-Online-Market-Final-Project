package com.waa.g7onlinemarket.repositories;

import com.waa.g7onlinemarket.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByAuthority(String authority);
    boolean existsByAuthority(String name);
}
