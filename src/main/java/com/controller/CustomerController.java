package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Customer;
import com.exception.CustomerNotFoundException;
import com.service.CustomerService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.insertCustomer(customer), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/getCustomerById/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) throws CustomerNotFoundException{
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomerById/{customerId}")
	public ResponseEntity<Customer> updateCustomerById(@PathVariable int customerId, Customer customer) throws CustomerNotFoundException{
		return new ResponseEntity<Customer>(customerService.updateCustomerById(customer, customerId), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomerById/{customerId}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable int customerId) throws CustomerNotFoundException{
		customerService.deleteCustomerById(customerId);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerListByName/{firstName}")
	public List<Customer> getCustomerListByName(@PathVariable String firstName){
		return customerService.getCustomerListByName(firstName);
	}
	
	@GetMapping("/getCustomerListByActivityName/{activityName}")
	public List<Customer> getCustomerListByActivityName(@PathVariable String activityName){
		return customerService.getCustomerListByName(activityName);
	}

}
