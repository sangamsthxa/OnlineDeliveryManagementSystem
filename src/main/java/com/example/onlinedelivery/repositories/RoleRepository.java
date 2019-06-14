package com.example.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinedelivery.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByRoleName(String roleName);

}
