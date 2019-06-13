package com.example.onlinedelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.onlinedelivery.model.User;
import com.example.onlinedelivery.services.SecurityService;
import com.example.onlinedelivery.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "user/registration";
	}

//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "user/registration";
//    }

	@CrossOrigin(origins = "http://localhost:8888")
	@ResponseBody
	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {


		System.out.println(userForm);
		userService.save(userForm);
		
		securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "user/login";
	}

	@GetMapping({ "/welcome" })
	public String welcome(Model model) {
		return "welcome";
	}
}