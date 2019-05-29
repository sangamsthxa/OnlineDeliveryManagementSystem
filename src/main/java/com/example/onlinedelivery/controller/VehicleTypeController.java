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
import com.example.onlinedelivery.model.VehicleType;
import com.example.onlinedelivery.services.GenericService;

@RequestMapping("/api/vehicleType")
@RestController
public class VehicleTypeController {

	@Autowired
	private GenericService<VehicleType> vehicleTypeService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> insertIntoDatabase(@Valid @RequestBody VehicleType vehicleType) {

			System.out.println(vehicleType);
		ResponseMessage response = new ResponseMessage();
		vehicleTypeService.saveInfo(vehicleType);
		response.setErrors(null);
		response.setMessage("Success");
		response.setStatus(true);
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ResponseMessage> updateVehicleType(@Valid @RequestBody VehicleType vehicleType) {
		ResponseMessage response = new ResponseMessage();
		vehicleTypeService.updateInfo(vehicleType);
			response.setErrors(null);
			response.setMessage("Success");
			response.setStatus(true);
			response.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ResponseMessage> getAllVehicleType() {
		ResponseMessage response = new ResponseMessage();
//    	List<Vendor>vendor= new ArrayList<>();
//    	
//vendor.add(vendorService.getallInfo());
		List<VehicleType> vehicleTypes = vehicleTypeService.getallInfo();
		response.setMessage("ok");
		response.setBody(vehicleTypes);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ResponseMessage> getVehicleTypeById(@PathVariable("id") int id) {
		ResponseMessage response = new ResponseMessage();
		Optional<VehicleType> vehicleType = vehicleTypeService.getInfoById(id);
		
		response.setMessage("ok");
		response.setBody(vehicleType);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<ResponseMessage> deleteVehicle(@PathVariable("id") int id) {
		ResponseMessage response = new ResponseMessage();
	
		
		vehicleTypeService.deleteById(id);
		response.setMessage("successfully deleted");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
