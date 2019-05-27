package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

import com.example.onlinedelivery.model.KYCForm;

public interface KYCFormService {
	
	public KYCForm saveKYCForm(KYCForm kycform);
	
	public KYCForm updateKYCForm(KYCForm kycform);
	
	public boolean deleteKYCForm(int id);
	
	public List<KYCForm> getAllKYCFormInfo();
	
	public Optional<KYCForm> getAllKYCFormById(int id);

}
