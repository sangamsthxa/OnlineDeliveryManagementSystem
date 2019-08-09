package com.example.onlinedelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.onlinedelivery.repositories.BlogRepository;
import com.example.onlinedelivery.repositories.ClientPostRepository;
import com.example.onlinedelivery.repositories.UserRepository;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClientPostRepository clientPostRepository;

	@Autowired
	private BlogRepository blogRepository;

	@RequestMapping({ "/", "/home" })
	public String getHomePage(Model model) {
		return "index";
	}

	@RequestMapping({ "/aboutUs" })
	public String getAboutUs(Model model) {
		return "aboutUs";
	}

	@RequestMapping({ "/services" })
	public String getServices(Model model) {
		return "services";
	}

	@RequestMapping({ "/dashboard" })
	public String getAdminDashboard(Model model) {
		model.addAttribute("user", userRepository.count());
		model.addAttribute("tservices", clientPostRepository.count());
		model.addAttribute("blog", blogRepository.count());
		return "admin/dashboard";
	}

	@RequestMapping({ "/admin/map" })
	public String getMapService(Model model) {
		return "admin/locationservice/map";
	}

	@RequestMapping({ "/service_post" })
	public String postService(Model model) {
		return "user/map";
	}

	@RequestMapping({ "/service_list" })
	public String getService(Model model) {
		return "user/formdata";
	}

	@RequestMapping({ "/admin/addUser" })
	public String AddUserPage() {
		return "admin/pages/addUser";
	}

	@RequestMapping({ "/viewUser" })
	public String ViewListUserPage() {
		return "admin/pages/viewUser";
	}

	@RequestMapping("/admin/addBlog")
	public String addBlog() {
		return "admin/pages/addBlog";
	}

	@RequestMapping("/admin/viewBlog")
	public String viewBlog() {
		return "admin/pages/viewBlog";
	}

	@RequestMapping("/admin/viewAboutUs")
	public String viewAboutUs() {
		return "admin/pages/viewAboutUs";
	}

	@RequestMapping("/admin/addAboutUs")
	public String addAboutUs() {
		return "admin/pages/addAboutUs";
	}

}
