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
import com.example.onlinedelivery.services.GenericService;

@RequestMapping("/api/client")
@RestController
public class ClientController {
	@Autowired
	private GenericService<Client> clientService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> insertIntoDatabase(@Valid @RequestBody Client client) {

			System.out.println(client);
		ResponseMessage response = new ResponseMessage();
		clientService.saveInfo(client);
		response.setErrors(null);
		response.setMessage("Success");
		response.setStatus(true);
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ResponseMessage> updateClient(@Valid @RequestBody Client client) {
		ResponseMessage response = new ResponseMessage();
		clientService.updateInfo(client);
			response.setErrors(null);
			response.setMessage("Success");
			response.setStatus(true);
			response.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ResponseMessage> getAllClient() {
		ResponseMessage response = new ResponseMessage();
//    	List<Vendor>vendor= new ArrayList<>();
//    	
//vendor.add(vendorService.getallInfo());
		List<Client> client = clientService.getallInfo();
		response.setMessage("ok");
		response.setBody(client);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ResponseMessage> getClientById(@PathVariable("id") int id) {
		ResponseMessage response = new ResponseMessage();
		Optional<Client> client = clientService.getInfoById(id);
		
		response.setMessage("ok");
		response.setBody(client);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<ResponseMessage> deleteClient(@PathVariable("id") int id) {
		ResponseMessage response = new ResponseMessage();
	
		
		clientService.deleteById(id);
		response.setMessage("successfully deleted");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
