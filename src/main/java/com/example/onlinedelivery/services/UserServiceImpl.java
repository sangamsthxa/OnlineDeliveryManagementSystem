package com.example.onlinedelivery.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.onlinedelivery.model.Role;
import com.example.onlinedelivery.model.User;
import com.example.onlinedelivery.repositories.RoleRepository;
import com.example.onlinedelivery.repositories.UserRepository;
import com.example.onlinedelivery.util.UserDto;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		user.setPasswordConfirm(bCryptPasswordEncoder.encode(userDto.getPasswordConfirm()));
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setAddress(userDto.getAddress());
		user.setEmail(userDto.getEmail());
		user.setContactNo(userDto.getContactNo());
		user.setGender(userDto.getGender());
		if (userDto.getUserRole().equals("admin")) {
			Role roleAdmin = roleRepository.findByRoleName("ROLE_ADMIN");
			user.setRoles(new HashSet<>(Arrays.asList(roleAdmin)));
		}

		if (userDto.getUserRole().equals("vendor")) {
			Role roleVendor = roleRepository.findByRoleName("ROLE_VENDOR");
			user.setRoles(new HashSet<>(Arrays.asList(roleVendor)));
		}

		if (userDto.getUserRole().equals("client")) {
			Role roleClient = roleRepository.findByRoleName("ROLE_CLIENT");
			user.setRoles(new HashSet<>(Arrays.asList(roleClient)));
		}
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			user.setDob(format.parse(userDto.getDob()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}