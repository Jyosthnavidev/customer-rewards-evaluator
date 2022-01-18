package com.Jyosthnavi.rewardsevaluator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Jyosthnavi.rewardsevaluator.entity.Customer;
import com.Jyosthnavi.rewardsevaluator.service.RewardsService;

@RestController
public class RewardsController {

	
	@Autowired
	private RewardsService rewardsService;
	
	
//	@GetMapping("/{idUser}/rewards")
//	public List<MyTransaction> getAll(@PathVariable Integer idUser) {
//		return rewardsService.getAll();
//	}
	
	@GetMapping("/customers")
	public List<Customer> findCustomerAll() {
		return rewardsService.getCustomerAll();
	}
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer customerId) {
		Customer customer = rewardsService.getCustomerById(customerId);
		if (customer == null) return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	
}
