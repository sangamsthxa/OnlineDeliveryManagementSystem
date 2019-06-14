package com.example.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinedelivery.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);

	void save(org.springframework.security.core.userdetails.User user);

}
