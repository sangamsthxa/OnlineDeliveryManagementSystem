package com.example.onlinedelivery.controller;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.onlinedelivery.model.User;
import com.example.onlinedelivery.security.service.UserService;
import com.example.onlinedelivery.util.UserDto;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/access")
	public String accessDenied() {
		return "accessDeniedPage";
	}

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@CrossOrigin(origins = "http://localhost:8888")
	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") UserDto userForm, BindingResult bindingResult, Principal principal) {

		System.out.println(userForm);
		userForm.setCreatedBy(principal.getName());
		userForm.setCreatedAt(new Date());
		userForm.setUpdatedAt(new Date());
		userService.registerUser(userForm);

		return "login";

	}

	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String getLogoutPage() {
		return "login";
	}



}