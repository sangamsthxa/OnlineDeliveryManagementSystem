package com.example.onlinedelivery.controller;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinedelivery.exception.ResponseMessage;
import com.example.onlinedelivery.model.AboutUs;
import com.example.onlinedelivery.repositories.AboutUsRepository;

@RequestMapping("/admin")
@RestController
public class AboutUsController {


	@Autowired
	private AboutUsRepository aboutUsRepo;

	@PostMapping("/save/about")
	public String saveAboutUs(@Valid AboutUs ab, Principal p) {
		ab.setCreatedAt(new Date());
		ab.setUpdatedAt(new Date());
		ab.setCreatedBy(p.getName());
		ab.setUpdateBy(p.getName());
		aboutUsRepo.save(ab);
		return "admin/pages/addAboutus";

	}

	@PutMapping("/update/about")
	public String updateAboutUs(@Valid AboutUs ab) {
		aboutUsRepo.save(ab);
		return "admin/pages/addAboutUs";

	}

	@DeleteMapping("/delete/about/{id}")
	public ResponseEntity<ResponseMessage> deleteById(@PathVariable("id") int id) {
		ResponseMessage response = new ResponseMessage();

		boolean status = aboutUsRepo.existsById(id);
		if (!status) {
			Map<String, String> err = new HashMap<>();
			err.put("Error", "ID not Exist");
			response.setErrors(err);
			response.setMessage("Unsuccess");
			response.setStatus(false);
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		} else {
			try {
				aboutUsRepo.deleteById(id);
				response.setErrors(null);
				response.setMessage("Success");
				response.setStatus(true);
				response.setStatusCode(HttpStatus.OK.value());
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (Exception e) {
				Map<String, String> err = new HashMap<>();
				err.put("Error", e.getMessage());
				response.setErrors(err);
				response.setMessage("NotSuccess");
				response.setStatus(false);
				response.setStatusCode(HttpStatus.BAD_REQUEST.value());
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
		}
	}

	@GetMapping("/list/about")
	@ResponseBody
	public List<AboutUs> getAllAboutUsInfo() {
		List<AboutUs> aboutUs = aboutUsRepo.findAll();
		if (aboutUs.isEmpty()) {
			throw new RuntimeException("Aboutus List not Exist");
		}
		return aboutUs;
	}

}
