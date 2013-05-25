package org.swadeshi.entities;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
public class Account extends AbstractEntity {

	private Double amount;
	
	private String userName;
	
	private Date date;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
