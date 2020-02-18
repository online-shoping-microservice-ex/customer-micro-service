package com.online.microservice.customerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.microservice.customerservice.entity.Customer;
import com.online.microservice.customerservice.exception.CustomerNotfoundException;
import com.online.microservice.customerservice.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer findByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId).orElseThrow(() -> {
			throw new CustomerNotfoundException(String.format("Custome not found with id : %1$s", customerId));
		});
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

}
