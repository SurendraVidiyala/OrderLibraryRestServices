package com.customer.rest.client.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.rest.client.model.Customer;
import com.customer.rest.client.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {
	
	@Autowired
	CustomerService customerService;
	
	static final Logger logger = Logger.getLogger(CustomerRestController.class);
	
	@RequestMapping(value= "/create", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{customerId}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCustomer(@PathVariable long customerId) {
		Customer customer = customerService.getCustomer(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/list", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCustomers() {
		List<Customer> customerList = customerService.listCustomers();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCustomer( 
    										@RequestBody Customer customer) {
    	Customer updatedCustomer = customerService.updateCustomer(customer);
    	return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable long customerId) {
    	Customer customer = customerService.getCustomer(customerId);
    	customerService.deleteCustomer(customer);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
}
