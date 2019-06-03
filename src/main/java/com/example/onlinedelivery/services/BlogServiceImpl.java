package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.onlinedelivery.model.Blog;
import com.example.onlinedelivery.repositories.BlogRepository;

@Service
@Transactional
public class BlogServiceImpl implements GenericService<Blog>{

	private BlogRepository blogrepo;
	
	@Override
	public Blog saveInfo(Blog t) {
		// TODO Auto-generated method stub
		return blogrepo.save(t);
	}

	@Override
	public Blog updateInfo(Blog t) {
		// TODO Auto-generated method stub
		return blogrepo.save(t);
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		blogrepo.deleteById(id);
		return true;
	}

	@Override
	public List<Blog> getallInfo() {
		// TODO Auto-generated method stub
		return blogrepo.findAll();
	}

	@Override
	public Optional<Blog> getInfoById(int id) {
		// TODO Auto-generated method stub
		return blogrepo.findById(id);
	}

}
