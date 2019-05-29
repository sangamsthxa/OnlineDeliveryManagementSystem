package com.example.onlinedelivery.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinedelivery.exception.ResponseMessage;
import com.example.onlinedelivery.model.KYCForm;
import com.example.onlinedelivery.model.VehicleType;
import com.example.onlinedelivery.services.GenericService;

@RequestMapping("/api/kycForm")
@RestController
public class KYCFormController {
	
	@Autowired
	private GenericService<KYCForm> kycFormService;
	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> insertIntoDatabase(@Valid @RequestBody KYCForm kycForm) {

			System.out.println(kycForm);
		ResponseMessage response = new ResponseMessage();
		kycFormService.saveInfo(kycForm);
		response.setErrors(null);
		response.setMessage("Success");
		response.setStatus(true);
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ResponseMessage> updateKYCForm(@Valid @RequestBody KYCForm kycForm) {
		ResponseMessage response = new ResponseMessage();
		kycFormService.updateInfo(kycForm);
			response.setErrors(null);
			response.setMessage("Success");
			response.setStatus(true);
			response.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ResponseMessage> getAllKYCForm() {
		ResponseMessage response = new ResponseMessage();
//    	List<Vendor>vendor= new ArrayList<>();
//    	
//vendor.add(vendorService.getallInfo());
		List<KYCForm> kycForms = kycFormService.getallInfo();
		response.setMessage("ok");
		response.setBody(kycForms);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ResponseMessage> getKYCFormById(@PathVariable("id") int id) {
		ResponseMessage response = new ResponseMessage();
		Optional<KYCForm> kycForm = kycFormService.getInfoById(id);
		
		response.setMessage("ok");
		response.setBody(kycForm);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<ResponseMessage> deleteKYCForm(@PathVariable("id") int id) {
		ResponseMessage response = new ResponseMessage();
	
		
		kycFormService.deleteById(id);
		response.setMessage("successfully deleted");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

}
