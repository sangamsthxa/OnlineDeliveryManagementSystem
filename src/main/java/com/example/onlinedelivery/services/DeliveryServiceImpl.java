package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinedelivery.model.DeliveryService;
import com.example.onlinedelivery.repositories.DeliveryServiceRepository;

@Service
@Transactional
public class DeliveryServiceImpl implements GenericService<DeliveryService> {

	@Autowired
	private DeliveryServiceRepository deliveryServiceRepo;
	
	@Override
	public DeliveryService saveInfo(DeliveryService t) {
		return deliveryServiceRepo.save(t);
	}

	@Override
	public DeliveryService updateInfo(DeliveryService t) {
		return deliveryServiceRepo.save(t);
	}

	@Override
	public boolean deleteById(int id) {
		deliveryServiceRepo.deleteById(id);
		return true;
	}

	@Override
	public List<DeliveryService> getallInfo() {
		return deliveryServiceRepo.findAll();
	}

	@Override
	public Optional<DeliveryService> getInfoById(int id) {
		return deliveryServiceRepo.findById(id);
	}
	


}
