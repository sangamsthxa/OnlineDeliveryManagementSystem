package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

public interface VehicleTypeService {
	
	public VehicleTypeService saveVehicleType(VehicleTypeService vehicleType);
	
	public VehicleTypeService updateVehicleType(VehicleTypeService vehicleType);
	
	public boolean deleteVehicleType(VehicleTypeService id);
	
	public List<VehicleTypeService> getAllVehicleInfo();
	
	public Optional<VehicleTypeService> getAllVehicleById(int id);
	
	

}
