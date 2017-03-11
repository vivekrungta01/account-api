package com.javahiring.account.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="account")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="balance")
	private Double balance;
	@Column(name="user_id")
	private Integer userId;
	
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", userId=" + userId + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Account(Integer userId) {
		balance=0.0;
		this.userId=userId;
	}
	public Account() {
	}
	
}
