package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

import com.example.onlinedelivery.model.Vendor;

public interface VendorService {
	
	public Vendor saveVendor(Vendor vendor);
	
	public Vendor updateVendor(Vendor vendor);
	 
	public boolean deleteVendor(int id);
	
	public List<Vendor> getAllVendorInfo();
	
	public Optional<Vendor> getAllVendorById(int id);
	

}
