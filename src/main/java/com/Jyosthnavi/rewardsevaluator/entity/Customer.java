package com.Jyosthnavi.rewardsevaluator.entity;

import java.time.Month;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Integer customerId;
	private String name;
	@OneToMany(mappedBy="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Transaction> transactions;
	@Transient
	private Long rewardPoints;
	@Transient
	private Double totalPurchases;
	
	@Transient
	private Map<String, Long> monthlyRewards;
	
	
	public Customer() {
	}
	
	public Customer(Integer customerId, String name) {
		this.customerId = customerId;
		this.name = name;
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
	
	public Set<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	public Long getRewardPoints() {
		if (transactions == null || transactions.isEmpty()) return 0l;
		
		return transactions.stream().map(x -> x.getPoints().intValue()).reduce(0, (a,b) -> a + b).longValue();
	}
	public Double getTotalPurchases() {
		if (transactions == null || transactions.isEmpty()) return 0d;
		
		return transactions.stream().map(x -> x.getTotal().doubleValue()).reduce(0d, (a,b) -> a + b).doubleValue();
	}
	
	public Map<Month, Long> getMonthlyRewards() {
		Map<Month, Long> monthlyRewards = transactions.stream().collect(Collectors.groupingBy(t->t.getSaveDate().getMonth(),Collectors.summingLong(t->t.getPoints())));
		return monthlyRewards;
		
	}
	
	
}
