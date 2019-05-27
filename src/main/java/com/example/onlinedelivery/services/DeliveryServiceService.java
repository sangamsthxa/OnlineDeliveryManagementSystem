package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

import com.example.onlinedelivery.model.DeliveryService;

public interface DeliveryServiceService {
	
	public DeliveryService saveDeliveryService(DeliveryService delivery);
	
	public DeliveryService updateDeliveryService(DeliveryService delivery);
	
	public boolean deleteDeliveryService(int id);
	
	public List<DeliveryService> getAllDeliveryServiceInfo();
	
	public Optional<DeliveryService> getAllDeliveryServiceById(int id);

}
