package com.Jyosthnavi.rewardsevaluator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jyosthnavi.rewardsevaluator.DTO.CustomerDTO;
import com.Jyosthnavi.rewardsevaluator.entity.Customer;
import com.Jyosthnavi.rewardsevaluator.service.RewardsService;

@RestController
@RequestMapping("rewards")
public class RewardsController {

	
	@Autowired
	private RewardsService rewardsService;
	
	
	@GetMapping("/customers")
	public List<Customer> findCustomerAll() {
		return rewardsService.getCustomerAll();
	}
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer customerId) {
		CustomerDTO customerDTO = rewardsService.getCustomerById(customerId);
		if (customerDTO == null) return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);
	}
	
	
}
