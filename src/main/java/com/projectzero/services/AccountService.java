package com.projectzero.services;

import java.util.List;

import com.projectzero.dao.AccountDAO;
import com.projectzero.dao.AccountDAOImpl;
import com.projectzero.exception.NegativeFundsException;
import com.projectzero.model.Account;
import com.projectzero.model.User;

public class AccountService {
	
	
	AccountDAO repo = null;

	public AccountService() {
		super();
		this.repo = new AccountDAOImpl();
	}

	public AccountService(AccountDAO repository) {
		super();
		this.repo = repository;
	}

	public List<Account> findAllPendingAccounts(){
		return this.repo.findAllPendingAccounts();
	}
	
	public boolean approveAccountStatus(int account_id){
		
		if(this.repo.approveAccountStatus(account_id));
		{
			System.out.println("Account "+ account_id +" was approved!");
		}
		return true;
	}
	
	/**
	 * Handles transfers between the View and the DAO
	 * @param source
	 * @param target
	 * @param amount
	 * @return boolean
	 */
	public boolean transfer(int source, int target, double amount) {
		if(amount <= 0) {
			 throw new NegativeFundsException("You have entered a negative ammount!");
		}
		return this.repo.transfer(source, target, amount);
	}
	
	public List<Account> findAll() {
		return this.repo.findAll();
	}

	
	public Account applyForNewAccount(User user) {
		Account acc = this.repo.insert();
		this.repo.insertIntoJoinTable(acc, user);
		return acc;
		
	}
	public void insert(Account e) {
		this.repo.insert();
	}
	
	public void accountDeposit() {
		
	}
	
}
