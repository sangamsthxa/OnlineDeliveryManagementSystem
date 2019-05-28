package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinedelivery.model.Client;
import com.example.onlinedelivery.repositories.ClientRepository;

@Service
@Transactional
public class ClientServiceImpl implements GenericService<Client> {

	@Autowired
	private ClientRepository clientRepo;

	@Override
	public Client saveInfo(Client t) {
		return clientRepo.save(t);
	}

	@Override
	public Client updateInfo(Client t) {
		return clientRepo.save(t);
	}

	@Override
	public boolean deleteById(int id) {
		clientRepo.deleteById(id);
		return true;
	}

	@Override
	public List<Client> getallInfo() {
		return clientRepo.findAll();
	}

	@Override
	public Optional<Client> getInfoById(int id) {
		return clientRepo.findById(id);
	}

}
