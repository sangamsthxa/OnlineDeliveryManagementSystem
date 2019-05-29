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

import com.example.onlinedelivery.model.Vendor;
import com.example.onlinedelivery.services.GenericService;


@RequestMapping("/api/vendor")
@RestController
public class VendorController {
	@Autowired
	private GenericService<Vendor> vendorService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> insertIntoDatabase(@Valid @RequestBody Vendor vendor) {

			System.out.println(vendor);
		ResponseMessage response = new ResponseMessage();
		vendorService.saveInfo(vendor);
		response.setErrors(null);
		response.setMessage("Success");
		response.setStatus(true);
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ResponseMessage> updateVendor(@Valid @RequestBody Vendor vendor) {
		ResponseMessage response = new ResponseMessage();
			vendorService.updateInfo(vendor);
			response.setErrors(null);
			response.setMessage("Success");
			response.setStatus(true);
			response.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ResponseMessage> getAllVendor() {
		ResponseMessage response = new ResponseMessage();
//    	List<Vendor>vendor= new ArrayList<>();
//    	
//vendor.add(vendorService.getallInfo());
		List<Vendor> vendor = vendorService.getallInfo();
		response.setMessage("ok");
		response.setBody(vendor);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ResponseMessage> getVendorById(@PathVariable("id") int id) {
		ResponseMessage response = new ResponseMessage();
		Optional<Vendor> vendor = vendorService.getInfoById(id);
		
		response.setMessage("ok");
		response.setBody(vendor);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<ResponseMessage> deleteVendor(@PathVariable("id") int id) {
		ResponseMessage response = new ResponseMessage();
	
		
		vendorService.deleteById(id);
		response.setMessage("successfully deleted");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
