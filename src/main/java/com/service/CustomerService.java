package com.service;

import java.time.LocalDate;
import java.util.List;

import com.entity.Customer;
import com.exception.CustomerNotFoundException;

public interface CustomerService {
	
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomerById(Customer customer, int customerId) throws CustomerNotFoundException;
	public String deleteCustomerById(int customerId) throws CustomerNotFoundException;
	public List<Customer>getAllCustomers();
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException;
	
	//Custom
	public List<Customer> getCustomerListByName(String firstName);

}
