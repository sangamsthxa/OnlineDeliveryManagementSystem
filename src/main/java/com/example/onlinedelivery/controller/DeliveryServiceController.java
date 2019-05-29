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
import com.example.onlinedelivery.model.Client;
import com.example.onlinedelivery.model.DeliveryService;
import com.example.onlinedelivery.services.GenericService;

@RequestMapping("/api/deliveryService")
@RestController
public class DeliveryServiceController {
	
	@Autowired
	private GenericService<DeliveryService> service;

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> insertIntoDatabase(@Valid @RequestBody DeliveryService deliveryService) {

			System.out.println(deliveryService);
		ResponseMessage response = new ResponseMessage();
		service.saveInfo(deliveryService);
		response.setErrors(null);
		response.setMessage("Success");
		response.setStatus(true);
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ResponseMessage> updateDeliveryService(@Valid @RequestBody DeliveryService deliveryService) {
		ResponseMessage response = new ResponseMessage();
		service.updateInfo(deliveryService);
			response.setErrors(null);
			response.setMessage("Success");
			response.setStatus(true);
			response.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ResponseMessage> getAllDeliveryService() {
		ResponseMessage response = new ResponseMessage();
//    	List<Vendor>vendor= new ArrayList<>();
//    	
//vendor.add(vendorService.getallInfo());
		List<DeliveryService> deliveryServices = service.getallInfo();
		response.setMessage("ok");
		response.setBody(deliveryServices);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ResponseMessage> getDeliveryById(@PathVariable("id") int id) {
		ResponseMessage response = new ResponseMessage();
		Optional<DeliveryService> deliveryService = service.getInfoById(id);
		
		response.setMessage("ok");
		response.setBody(deliveryService);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<ResponseMessage> deleteDeliveryService(@PathVariable("id") int id) {
		ResponseMessage response = new ResponseMessage();
	
		
		service.deleteById(id);
		response.setMessage("successfully deleted");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
