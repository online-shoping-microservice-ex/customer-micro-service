package com.online.microservice.customerservice.service;

import java.util.List;

import com.online.microservice.customerservice.entity.Customer;

public interface CustomerService {

	List<Customer> findAllCustomers();
	Customer findByCustomerId(String customerId);
	void saveCustomer(Customer customer);
	void updateCustomer(Customer customer);
}
