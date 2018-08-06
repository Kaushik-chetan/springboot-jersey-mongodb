package com.customerapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customerapi.model.Customer;
import com.customerapi.model.Customers;
import com.customerapi.repository.CustomerRepository;

@Component
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customers getAllCustomers() {
		
		Customers customers = new Customers();
		
		List<Customer> customerList = customerRepository.findAll();
		
		customers.setCustomerList(customerList);
		
		return customers;
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		
		return customerRepository.findOne(customerId);
	}

	@Override
	public void addCustomer(Customer customer) {
		
		customerRepository.save(customer);
		
	}
	
	@Override
	public void updateCustomer(Customer customer)
	{
		
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		customerRepository.delete(customerId);
	}

}
