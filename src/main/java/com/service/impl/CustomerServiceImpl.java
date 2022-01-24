package com.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Customer;
import com.exception.CustomerNotFoundException;
import com.repository.CustomerRepository;
import com.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepo;

	@Override
	public Customer insertCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomerById(Customer customer, int customerId) throws CustomerNotFoundException {
		
		Customer existingCustomer = customerRepo.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
		
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setUsername(customer.getUsername());
		existingCustomer.setPassword(customer.getPassword());
		existingCustomer.setMobileNumber(customer.getMobileNumber());
		existingCustomer.setEmail(customer.getEmail());
		
		customerRepo.save(existingCustomer);
		return existingCustomer;
	}

	@Override
	public String deleteCustomerById(int customerId) throws CustomerNotFoundException {
		customerRepo.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
		customerRepo.deleteById(customerId);
		return "Deleted";
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
		return customerRepo.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
	}

	@Override
	public List<Customer> getCustomerListByName(String firstName) {
		return customerRepo.findByFirstName(firstName);
	}



}
