package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinedelivery.model.VehicleType;
import com.example.onlinedelivery.repositories.VehicleTypeRepository;

@Service
@Transactional
public class VehicleTypeServiceImpl implements GenericService<VehicleType>{

	@Autowired
	private VehicleTypeRepository vehicleTypeRepo;
	
	@Override
	public VehicleType saveInfo(VehicleType t) {
		return vehicleTypeRepo.save(t);
	}

	@Override
	public VehicleType updateInfo(VehicleType t) {
		return vehicleTypeRepo.save(t);
	}

	@Override
	public boolean deleteById(int id) {
		vehicleTypeRepo.deleteById(id);
		return true;
	}

	@Override
	public List<VehicleType> getallInfo() {
		return vehicleTypeRepo.findAll();
	}

	@Override
	public Optional<VehicleType> getInfoById(int id) {
		return vehicleTypeRepo.findById(id);
	}
	

}
