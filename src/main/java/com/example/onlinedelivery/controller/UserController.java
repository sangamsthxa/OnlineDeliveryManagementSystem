package com.example.onlinedelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.onlinedelivery.model.User;
import com.example.onlinedelivery.services.UserService;
import com.example.onlinedelivery.util.UserDto;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

//	@Autowired
//	private SecurityService securityService;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "user/registration";
	}

	@CrossOrigin(origins = "http://localhost:8888")
	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") UserDto userForm, BindingResult bindingResult, Model model) {

		System.out.println(userForm);
		userService.save(userForm);

		return "user/login";

	}

	@GetMapping("/login")
	public String getLoginPage() {
		return "user/login";

	}
	
	
	
	
	
	
	
	
	
	

   
}