package com.example.onlinedelivery.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.onlinedelivery.model.User;
import com.example.onlinedelivery.repositories.UserRepository;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (userRepository.count() == 0) {
			User user = new User("admin", passwordEncoder.encode("admin01234"),
					"Niraj", "Khaiju","neffex@gmail.com","Bhaktapur",
					"2019-08-05", "9860606060","Male", "ADMIN");
			
			userRepository.save(user);
		}
	}

}
