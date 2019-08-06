package com.example.onlinedelivery.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.onlinedelivery.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUserName(String username);

	 @Query(value = "SELECT * FROM USERS WHERE roleName = ?VENDOR", nativeQuery = true)
	  User findByroleName(String roleName);
	
}
