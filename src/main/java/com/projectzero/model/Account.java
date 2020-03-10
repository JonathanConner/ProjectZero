package com.projectzero.model;

import java.util.List;

public class Account {

	private int id;
	
	private int account_number;
	
	private double balance;
	
	private String status;
	
	
	public Account() {}
	
	
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	public int getId() {return this.id;}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.getStatus();
	}

	public double getBalance() {
		return this.balance;
	}
	public void setBalance(double bal) {
		this.balance = bal;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", account_number="+account_number +", balance=" + balance + ", status=" + status + "]";
	}
	
	public void setAccountNumber(int accNum) {
		this.account_number = accNum;
	}
	
}
