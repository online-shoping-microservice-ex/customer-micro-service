package com.online.microservice.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.microservice.customerservice.entity.Customer;
import com.online.microservice.customerservice.exception.CustomerAlreadyExistedException;
import com.online.microservice.customerservice.service.CustomerService;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping
	public List<Customer> getCustomers() {
		return customerService.findAllCustomers();
	}

	@GetMapping(path = "/{customerId}")
	public Customer findCustomerById(@PathVariable String customerId) {
		return customerService.findByCustomerId(customerId);
	}

	@PostMapping
	public ResponseEntity<String> createCustomer(@RequestBody Customer user) throws CustomerAlreadyExistedException {

		Customer customer = new Customer();
		customer.setAddress(user.getAddress());
		customer.setPhone(user.getPhone());
		customer.setEmail(user.getEmail());
		customer.setFirstName(user.getFirstName());
		customer.setLastName(user.getLastName());
		customer.setMiddelName(user.getMiddelName());
		customer.setGender(user.getGender());
		
		customerService.saveCustomer(customer);
		return new ResponseEntity<String>("Customer created successfully", HttpStatus.OK);

	}

	@PutMapping(path = "/{customerId}")
	public ResponseEntity<String> updateCustomer(@PathVariable String customerId, @RequestBody Customer customer)
			throws CustomerAlreadyExistedException {
		customerService.updateCustomer(customer);
		return new ResponseEntity<String>("Customer updated successfully", HttpStatus.OK);
	}

	@ExceptionHandler(value = CustomerAlreadyExistedException.class)
	public ResponseEntity<String> customerAlreadyExistedException(CustomerAlreadyExistedException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
	}

}
