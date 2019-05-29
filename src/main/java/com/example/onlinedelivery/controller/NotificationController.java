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
import com.example.onlinedelivery.model.DeliveryService;
import com.example.onlinedelivery.model.Notification;
import com.example.onlinedelivery.services.GenericService;

@RequestMapping("/api/notification")
@RestController
public class NotificationController {

	@Autowired
	private GenericService<Notification> notificationService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> insertIntoDatabase(@Valid @RequestBody Notification notification) {

			System.out.println(notification);
		ResponseMessage response = new ResponseMessage();
		notificationService.saveInfo(notification);
		response.setErrors(null);
		response.setMessage("Success");
		response.setStatus(true);
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ResponseMessage> updateNotification(@Valid @RequestBody Notification notification) {
		ResponseMessage response = new ResponseMessage();
		notificationService.updateInfo(notification);
			response.setErrors(null);
			response.setMessage("Success");
			response.setStatus(true);
			response.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ResponseMessage> getAllNotification() {
		ResponseMessage response = new ResponseMessage();
//    	List<Vendor>vendor= new ArrayList<>();
//    	
//vendor.add(vendorService.getallInfo());
		List<Notification> notifications = notificationService.getallInfo();
		response.setMessage("ok");
		response.setBody(notifications);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ResponseMessage> getNotificationById(@PathVariable("id") int id) {
		ResponseMessage response = new ResponseMessage();
		Optional<Notification> notification = notificationService.getInfoById(id);
		
		response.setMessage("ok");
		response.setBody(notification);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<ResponseMessage> deleteNotification(@PathVariable("id") int id) {
		ResponseMessage response = new ResponseMessage();
	
		
		notificationService.deleteById(id);
		response.setMessage("successfully deleted");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
