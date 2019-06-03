package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinedelivery.model.AboutUs;
import com.example.onlinedelivery.repositories.AboutUsRepository;

@Service
@Transactional
public class AboutUsServiceImpl implements GenericService<AboutUs> {

	@Autowired
	private AboutUsRepository aboutUsRepo;
	@Override
	public AboutUs saveInfo(AboutUs t) {
		// TODO Auto-generated method stub
		return aboutUsRepo.save(t);
	}

	@Override
	public AboutUs updateInfo(AboutUs t) {
		// TODO Auto-generated method stub
		return aboutUsRepo.save(t);
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		aboutUsRepo.deleteById(id);
		return true;
	}

	@Override
	public List<AboutUs> getallInfo() {
		// TODO Auto-generated method stub
		return aboutUsRepo.findAll();
	}

	@Override
	public Optional<AboutUs> getInfoById(int id) {
		// TODO Auto-generated method stub
		return aboutUsRepo.findById(id);
	}

}
