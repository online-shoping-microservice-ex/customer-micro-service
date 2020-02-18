package com.online.microservice.customerservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
public class Customer {

	@Id	
	private String customerId;
	private String address;
	private String phone;
	private String email;
	private String firstName;
	private String middelName;
	private String lastName;
	private String gender;
	
}
