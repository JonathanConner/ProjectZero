package com.projectzero.model;

import java.util.List;

public class Account {

	private int id;
	
	private int account_number;
	
	private double balance;
	
	private String status;
	
	private List<User> owners;
	
	public List<User> getOwners(){
		return this.owners;
	}
	
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.getStatus();
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", account number="+account_number+""+", balance=" + balance + ", status=" + status + "]";
	}
	
	
	
}
