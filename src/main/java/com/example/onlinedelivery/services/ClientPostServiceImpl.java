package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.onlinedelivery.model.ClientPost;
import com.example.onlinedelivery.repositories.ClientPostRepository;

@Service
@Transactional
public class ClientPostServiceImpl  implements GenericService<ClientPost> {
	
	@Autowired
	private ClientPostRepository clientPostRepository;

	@Override
	public ClientPost saveInfo(ClientPost t) {
		return clientPostRepository.save(t);
	}

	@Override
	public ClientPost updateInfo(ClientPost t) {
		return clientPostRepository.save(t);
	}

	@Override
	public boolean deleteById(int id) {
		clientPostRepository.deleteById(id);
		return true;
	}

	@Override
	public List<ClientPost> getallInfo() {
		return clientPostRepository.findAll();
	}

	@Override
	public Optional<ClientPost> getInfoById(int id) {
	return clientPostRepository.findById(id);
	}

}
