package com.example.onlinedelivery.controller;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.onlinedelivery.exception.ResponseMessage;
import com.example.onlinedelivery.model.Blog;
import com.example.onlinedelivery.repositories.BlogRepository;

@Controller
public class BlogController {
	
	
	@Autowired
	private BlogRepository blogRepo;
	
	@PostMapping("/admin/save/blog")
	public String saveBlog(@Valid  Blog blog, Errors error, Principal p) {
		ResponseMessage response = new ResponseMessage();

		System.out.println(blog);
		blog.setCreatedAt(new Date());
		blog.setUpdatedAt(new Date());
		blog.setCreatedBy(p.getName());
		blog.setUpdateBy(p.getName());
		
		blogRepo.save(blog);
		response.setErrors(null);
		response.setMessage("Success");
		response.setStatus(true);
		response.setStatusCode(HttpStatus.OK.value());
		return "admin/pages/addBlog";

	}

	@PutMapping("/admin/update/blog")
	public String updateBlog(@Valid  Blog blog, Errors error,Principal p) {

		ResponseMessage response = new ResponseMessage();

		blog.setCreatedAt(new Date());
		blog.setUpdatedAt(new Date());
		blog.setCreatedBy(p.getName());
		blog.setUpdateBy(p.getName());
		blogRepo.save(blog);
		response.setErrors(null);
		response.setMessage("Success");
		response.setStatus(true);
		response.setStatusCode(HttpStatus.OK.value());
		return "admin/pages/addBlog";
	}

	@DeleteMapping("/admin/delete/blog/{id}")
	public String deleteById(@PathVariable("id") int id) {
		ResponseMessage response = new ResponseMessage();

		boolean status = blogRepo.existsById(id);
		if (!status) {
			Map<String, String> err = new HashMap<>();
			err.put("Error", "ID not Exist");
			response.setErrors(err);
			response.setMessage("Unsuccess");
			response.setStatus(false);
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			return "admin/pages/addBlog";
		} else {
			try {
				blogRepo.deleteById(id);
				response.setErrors(null);
				response.setMessage("Success");
				response.setStatus(true);
				response.setStatusCode(HttpStatus.OK.value());
				return "admin/pages/addBlog";
			} catch (Exception e) {
				Map<String, String> err = new HashMap<>();
				err.put("Error", e.getMessage());
				response.setErrors(err);
				response.setMessage("NotSuccess");
				response.setStatus(false);
				response.setStatusCode(HttpStatus.BAD_REQUEST.value());
				return "admin/pages/addBlog";
			}
		}
	}

	@GetMapping("/list/blog")
	@ResponseBody
	public List<Blog> getAllBlogInfo() {
		List<Blog> blog = blogRepo.findAll();
		if (blog.isEmpty()) {
			throw new RuntimeException("blog List not Exist");
		}
		return blog;
	}
	
	
	@GetMapping("/get/blog/{id}")
	@ResponseBody
	public Optional<Blog> getBlogInfo(@PathVariable("id") int id){
		return blogRepo.findById(id);
		
	}

}
