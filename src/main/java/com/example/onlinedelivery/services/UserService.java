package com.example.onlinedelivery.services;

import com.example.onlinedelivery.model.User;

public interface UserService {

	void save(User user);

    User findByUsername(String username);
}
