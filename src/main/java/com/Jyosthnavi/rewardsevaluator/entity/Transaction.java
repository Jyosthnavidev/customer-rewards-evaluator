package com.Jyosthnavi.rewardsevaluator.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction extends Reward {
	@Id
	@GeneratedValue
	private Long id;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="customer_id") 
	private Customer customer;
	private Double total;
	private String description;
	private LocalDateTime saveDate;

	public Transaction() {
		super();
	}

	public Transaction(Long id, Customer customer, Double total, String description, LocalDateTime date) {
		super();
		this.id = id;
		this.customer = customer;
		this.total = total;
		this.description = description;
		this.saveDate = date;
	}

	public LocalDateTime getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(LocalDateTime saveDate) {
		this.saveDate = saveDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Long getPoints() {
		this.points = 0l;

		if (this.total > 50 && this.total <= 100) {
			this.points += (this.total.intValue() - 50) * 1;

		}

		if (this.total > 100) {
			this.points += 50; // 1 point for every dollar spent over $50
			this.points += (this.total.intValue() - 100) * 2; // 2 points for every dollar spent over $100
		}

		return this.points;
	}

}
