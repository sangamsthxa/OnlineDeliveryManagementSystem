package com.example.onlinedelivery.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinedelivery.model.Vendor;
import com.example.onlinedelivery.repositories.VendorRepository;
import com.example.onlinedelivery.services.VendorService;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public Vendor saveVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return vendorRepository.save(vendor);
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return vendorRepository.save(vendor);
	}

	@Override
	public boolean deleteVendor(int id) {
		// TODO Auto-generated method stub
	vendorRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Vendor> getAllVendorInfo() {
		// TODO Auto-generated method stub
		return vendorRepository.findAll();
	}

	@Override
	public Optional<Vendor> getAllVendorById(int id) {
		// TODO Auto-generated method stub
		return vendorRepository.findById(id);
	}

}
