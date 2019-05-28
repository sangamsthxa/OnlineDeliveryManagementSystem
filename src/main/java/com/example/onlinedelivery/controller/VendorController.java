package com.example.onlinedelivery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinedelivery.model.ResponseObject;
import com.example.onlinedelivery.model.Vendor;
import com.example.onlinedelivery.services.GenericService;


@RequestMapping("/api/vendor")
@RestController
public class VendorController {
	@Autowired
	private GenericService<Vendor> vendorService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseObject<?> insertIntoDatabase(@RequestBody Vendor vendor) {
		ResponseObject responseObject = new ResponseObject();
		int id = vendorService.saveInfo(vendor).getId();

		if (id > 0) {
			responseObject.setStatusCode(201);
			responseObject.setMessage("cretead with id " + id);
			return responseObject;
		} else {
			responseObject.setError("error while processing");
			return responseObject;
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseObject<Vendor> updateVendor(@RequestBody Vendor vendor) {
		ResponseObject responseObject = new ResponseObject();
		int id = vendor.getId();
		if (id > 0) {
			vendorService.updateInfo(vendor);
			responseObject.setStatusCode(201);
			responseObject.setMessage("updated" + id);
			return responseObject;
		} else {
			responseObject.setError("error while processing");
			return responseObject;
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseObject<Vendor> getAllVendor() {
		ResponseObject responseObject = new ResponseObject();
//    	List<Vendor>vendor= new ArrayList<>();
//    	
//vendor.add(vendorService.getallInfo());
		List<Vendor> vendor = vendorService.getallInfo();
		if (vendor == null) {
			responseObject.setError("error getting the resource");
			return responseObject;
		}
		responseObject.setMessage("ok");
		responseObject.setBody(vendor);
		return responseObject;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/id")
	public ResponseObject<Vendor> getVendorById(@PathVariable("id") int id) {
		ResponseObject responseObject = new ResponseObject();
		Optional<Vendor> vendor = vendorService.getInfoById(id);
		if (vendor == null) {
			responseObject.setError("error getting the resource");
			return responseObject;
		}
		responseObject.setMessage("ok");
		responseObject.setBody(vendor);
		return responseObject;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/id")
	public ResponseObject<?> deleteVendor(@PathVariable("id") int id) {
		ResponseObject responseObject = new ResponseObject();
		Optional<Vendor> vendor = null;
		vendor = vendorService.getInfoById(id);
		if (vendor == null) {
			responseObject.setError("failed to delete");
			return responseObject;
		}
		vendorService.deleteById(id);
		responseObject.setMessage("successfully deleted");
		return responseObject;
	}

}
