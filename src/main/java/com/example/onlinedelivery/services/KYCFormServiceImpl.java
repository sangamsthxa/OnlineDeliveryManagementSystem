package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinedelivery.model.KYCForm;
import com.example.onlinedelivery.repositories.KYCFormRepository;

@Service
@Transactional
public class KYCFormServiceImpl implements GenericService<KYCForm>{

	@Autowired
	private KYCFormRepository kycFormRepo;
	
	@Override
	public KYCForm saveInfo(KYCForm t) {
		return kycFormRepo.save(t);
	}

	@Override
	public KYCForm updateInfo(KYCForm t) {
		return kycFormRepo.save(t);

	}

	@Override
	public boolean deleteById(int id) {
		 kycFormRepo.deleteById(id);
		return true;
	}

	@Override
	public List<KYCForm> getallInfo() {
		return kycFormRepo.findAll();
	}

	@Override
	public Optional<KYCForm> getInfoById(int id) {
		return kycFormRepo.findById(id);
	}
	


}
