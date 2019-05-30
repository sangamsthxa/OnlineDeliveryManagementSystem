package com.example.onlinedelivery.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinedelivery.exception.ResponseMessage;
import com.example.onlinedelivery.model.VehicleType;
import com.example.onlinedelivery.repositories.VehicleTypeRepository;
import com.example.onlinedelivery.services.GenericService;

@RequestMapping("/api/vehicleType")
@RestController
public class VehicleTypeController {

	@Autowired
	private GenericService<VehicleType> vehicleTypeService;

	@Autowired
	private VehicleTypeRepository vehicleTypeRepo;

	@PostMapping("/save")
	public ResponseEntity<ResponseMessage> saveVehicleType(@Valid @RequestBody VehicleType vt, Errors error) {
		ResponseMessage response = new ResponseMessage();

		vt.setCreatedAt(new Date());
		vt.setUpdatedAt(new Date());
		vehicleTypeService.saveInfo(vt);
		response.setErrors(null);
		response.setMessage("Success");
		response.setStatus(true);
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<ResponseMessage> updateVehicleType(@Valid @RequestBody VehicleType vt, Errors error) {

		ResponseMessage response = new ResponseMessage();

		vt.setCreatedAt(new Date());
		vt.setUpdatedAt(new Date());
		vehicleTypeService.updateInfo(vt);
		response.setErrors(null);
		response.setMessage("Success");
		response.setStatus(true);
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteById(@PathVariable("id") int id) {
		ResponseMessage response = new ResponseMessage();

		boolean status = vehicleTypeRepo.existsById(id);
		if (!status) {
			Map<String, String> err = new HashMap<>();
			err.put("Error", "ID not Exist");
			response.setErrors(err);
			response.setMessage("Unsuccess");
			response.setStatus(false);
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		} else {
			try {
				vehicleTypeRepo.deleteById(id);
				response.setErrors(null);
				response.setMessage("Success");
				response.setStatus(true);
				response.setStatusCode(HttpStatus.OK.value());
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (Exception e) {
				Map<String, String> err = new HashMap<>();
				err.put("Error", e.getMessage());
				response.setErrors(err);
				response.setMessage("NotSuccess");
				response.setStatus(false);
				response.setStatusCode(HttpStatus.BAD_REQUEST.value());
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
		}
	}

	@GetMapping("/list")
	public List<VehicleType> getAllVehicleTypeInfo() {
		List<VehicleType> vt = vehicleTypeRepo.findAll();
		if (vt.isEmpty()) {
			throw new RuntimeException("VehicleType List not Exist");
		}
		return vt;
	}
}
