package com.customerapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.customerapi.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Integer>{
	
	
}
