package com.example.onlinedelivery.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.onlinedelivery.Map.LongLat;
import com.example.onlinedelivery.repositories.LongLatRepository;

@Controller
public class LongLatController {
	
	
	@Autowired
	private LongLatRepository longLatRepository;
	
	
	@PostMapping("/save/longlat")
	public LongLat saveLongLat(LongLat ll) {
		return longLatRepository.save(ll);
	}
	
	@GetMapping("/get/longlat/{id}")
	public Optional<LongLat> showLongLat(@PathVariable("id") int id) {
		return longLatRepository.findById(id);
	}
}
