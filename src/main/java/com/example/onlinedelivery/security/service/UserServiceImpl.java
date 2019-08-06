package com.example.onlinedelivery.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.onlinedelivery.model.User;
import com.example.onlinedelivery.repositories.UserRepository;
import com.example.onlinedelivery.util.UserDto;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("cryptPasswordEncoder")
	private BCryptPasswordEncoder cryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	
	@Override
	public void registerUser(UserDto userDto) {
		User user = new User();
		user.setUserName(userDto.getUserName());
		user.setPassword(cryptPasswordEncoder.encode(userDto.getPassword()));
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setAddress(userDto.getAddress());
		user.setContactNo(userDto.getContactNo());
		user.setGender(userDto.getGender());
		user.setDob(userDto.getDob());
		user.setCreatedBy(userDto.getCreatedBy());
		user.setCreatedAt(userDto.getCreatedAt());
		user.setUpdatedAt(userDto.getUpdatedAt());
		
		if (userDto.getRoleName().equals("admin")) {
			user.setRoleName("ADMIN");
		}
		if (userDto.getRoleName().equals("vendor")) {
			user.setRoleName("VENDOR");
		}
		if (userDto.getRoleName().equals("client")) {
			user.setRoleName("CLIENT");
		}
		System.out.println(user);
		userRepository.save(user); 
		
	}



}
