package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

import com.example.onlinedelivery.model.Client;

public interface ClientService {
	
	public ClientService saveClientService(Client clientservice);
	
	public ClientService updateClientService(Client clientservice);
	
	public boolean deleteClientService(int id);
	
	public List<ClientService> getAllClientServiceInfo();
	
	public Optional<ClientService> getAllClientServiceById(int id);
	
	

}
