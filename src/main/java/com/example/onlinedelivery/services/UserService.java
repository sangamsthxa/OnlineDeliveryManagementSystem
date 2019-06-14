package com.example.onlinedelivery.services;

import com.example.onlinedelivery.model.User;
import com.example.onlinedelivery.util.UserDto;

public interface UserService {

	void save(UserDto user);

    User findByUsername(String username);
}
