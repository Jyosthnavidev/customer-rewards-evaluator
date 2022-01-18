package com.Jyosthnavi.rewardsevaluator.DTO;

import java.time.Month;
import java.util.Map;

import com.Jyosthnavi.rewardsevaluator.entity.Customer;

public class CustomerDTO {
	
	private Integer customerId;
	private String name;
	private Map<Month, Long> monthlyRewards;
	private Long rewardPoints;
	private Double totalPurchases;
	
	
	public CustomerDTO(final Customer customer) {
		this.customerId=customer.getCustomerId();
		this.name = customer.getName();
		this.totalPurchases = customer.getTotalPurchases();
		this.rewardPoints = customer.getRewardPoints();
		this.monthlyRewards = customer.getMonthlyRewards();
	}
	
	
	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Map<Month, Long> getMonthlyRewards() {
		return monthlyRewards;
	}


	public void setMonthlyRewards(Map<Month, Long> monthlyRewards) {
		this.monthlyRewards = monthlyRewards;
	}


	public Long getRewardPoints() {
		return rewardPoints;
	}


	public void setRewardPoints(Long rewardPoints) {
		this.rewardPoints = rewardPoints;
	}


	public Double getTotalPurchases() {
		return totalPurchases;
	}


	public void setTotalPurchases(Double totalPurchases) {
		this.totalPurchases = totalPurchases;
	}	

}
