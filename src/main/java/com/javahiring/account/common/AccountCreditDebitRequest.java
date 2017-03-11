package com.javahiring.account.common;

public class AccountCreditDebitRequest {
	private Double amount;
	private Integer userId;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AccountCreditDebitRequest [amount=" + amount + ", userId=" + userId + "]";
	}
}
