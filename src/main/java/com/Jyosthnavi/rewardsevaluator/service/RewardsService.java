package com.Jyosthnavi.rewardsevaluator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jyosthnavi.rewardsevaluator.DTO.CustomerDTO;
import com.Jyosthnavi.rewardsevaluator.entity.Customer;

@Service
public class RewardsService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public List<Customer> getCustomerAll() {
		return customerRepository.findAll();
	}
	
	public CustomerDTO getCustomerById(Integer customerId) {
		final Customer customer = customerRepository.findById(customerId).orElse(null);
		CustomerDTO customerDTO= new CustomerDTO(customer);
		return customerDTO;
	}

}
