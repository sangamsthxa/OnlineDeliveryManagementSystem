package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinedelivery.model.Vendor;
import com.example.onlinedelivery.repositories.VendorRepository;

@Service
@Transactional
public class VendorServiceImpl implements GenericService<Vendor> {

	@Autowired
	private VendorRepository vendorRepo;

	@Override
	public Vendor saveInfo(Vendor t) {
		return vendorRepo.save(t);
	}

	@Override
	public Vendor updateInfo(Vendor t) {
		return vendorRepo.save(t);

	}

	@Override
	public boolean deleteById(int id) {
		vendorRepo.deleteById(id);
		return true;
	}

	@Override
	public List<Vendor> getallInfo() {
		return vendorRepo.findAll();
	}

	@Override
	public Optional<Vendor> getInfoById(int id) {
		return vendorRepo.findById(id);
	}

}
