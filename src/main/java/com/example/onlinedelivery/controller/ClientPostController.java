package com.example.onlinedelivery.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.onlinedelivery.model.ClientPost;
import com.example.onlinedelivery.repositories.ClientPostRepository;
import com.example.onlinedelivery.services.ClientPostServiceImpl;

@Controller
public class ClientPostController {
	
	@Autowired
	private ClientPostServiceImpl clientPostService;
	
	@Autowired
	private ClientPostRepository clientPostRepository;
	
	
	@PostMapping("/save/clientpost")
	public ClientPost saveClientPost(@Valid @RequestBody ClientPost cp, Principal p) {
		cp.setCreatedBy(p.getName());
		cp.setUpdateBy(p.getName());
		cp.setCreatedAt(new Date());
		cp.setUpdatedAt(new Date());
		cp.setEnable(true);
		System.out.println(cp);
		return clientPostRepository.save(cp);
	}
	
	

	@GetMapping({ "/active/account", "/deactive/account" })
	public ClientPost activeAndDeactiveUserAccount(@RequestParam("status") boolean status,
			@RequestParam("id") int id) {

	  ClientPost cp= clientPostRepository.findById(id).get();
	  cp.setEnable(status);
	  return clientPostRepository.save(cp);
		
	}
	
	
	
	
	
	
	@GetMapping("/get/clientpost")
	@ResponseBody
	public List<ClientPost> getAllClientPost(){
		List<ClientPost> clist= clientPostService.getallInfo();
		if(clist.isEmpty()) {
			throw new RuntimeException("Client post Not Exists");
		}
		return clist;
	}
	
	
	@GetMapping("/get/clienpost/{id}")
	@ResponseBody
	public Optional<ClientPost> getClientPostById(@PathVariable("id") int id){
		return clientPostService.getInfoById(id);
		
	}

}
