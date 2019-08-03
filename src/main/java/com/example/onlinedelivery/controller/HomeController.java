package com.example.onlinedelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping({ "/", "/home" })
	public String getHomePage(Model model) {
		model.addAttribute("index", "item");
		return "index";
	}

	@RequestMapping({ "/client" })
	public String getClientHomePage(Model model) {
		model.addAttribute("index", "item");
		model.addAttribute("clienthomepage", "nav-item active");
		return "client/clienthomepage";
	}
	@RequestMapping({ "/aboutUs" })
	public String getAboutUs(Model model) {
		model.addAttribute("index", "item");
		model.addAttribute("clienthomepage", "nav-item active");
		model.addAttribute("aboutUs","nav-item");
		return "user/aboutUs";
	}
	
	@RequestMapping({ "/services" })
	public String getServices(Model model) {
		model.addAttribute("index", "item");
		model.addAttribute("clienthomepage", "nav-item active");
		model.addAttribute("aboutUs","nav-item");
		model.addAttribute("services","nav-item");
		
		return "user/services";
	}
	@RequestMapping({ "/admin/dashboard" })
	public String getAdminDashboard(Model model) {
		model.addAttribute("index", "item");
	    model.addAttribute("clienthomepage", "nav-item active");
		model.addAttribute("aboutUs","nav-item");
		model.addAttribute("services","nav-item");
		model.addAttribute("dashboard", "nav-item active");
		
		return "admin/dashboard";
	}
	
	@RequestMapping({ "/client/dashboard" })
	public String getClientDashboard(Model model) {
		model.addAttribute("index", "item");
	    model.addAttribute("clienthomepage", "nav-item active");
		model.addAttribute("aboutUs","nav-item");
		model.addAttribute("services","nav-item");
		model.addAttribute("dashboard", "nav-item active");
		model.addAttribute("clientDashboard", "nav-item");
		return "client/clientDashboard";
	}
	
	@RequestMapping({ "/admin/map" })
	public String getMapService(Model model) {
		model.addAttribute("index", "item");
	    model.addAttribute("clienthomepage", "nav-item active");
		model.addAttribute("aboutUs","nav-item");
		model.addAttribute("services","nav-item");
		model.addAttribute("map", "nav-item");
		
		return "admin/locationservice/map";
	}
	@RequestMapping({ "/service_post" })
	public String postService(Model model) {
		model.addAttribute("index", "item");
	    model.addAttribute("clienthomepage", "nav-item active");
		model.addAttribute("aboutUs","nav-item");
		model.addAttribute("services","nav-item");
		model.addAttribute("map", "nav-item");
		model.addAttribute("service","nav-item");
		
		return "user/map";
	}
	
	
}
