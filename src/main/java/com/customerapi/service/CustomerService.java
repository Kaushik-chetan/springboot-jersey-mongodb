package com.customerapi.service;

import com.customerapi.model.Customer;
import com.customerapi.model.Customers;

public interface CustomerService {
	
	public Customers getAllCustomers();
	
	public Customer getCustomerById(Integer customerId);
	
	public void addCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Integer customerId);
	
}
