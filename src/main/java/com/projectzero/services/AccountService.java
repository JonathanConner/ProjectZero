package com.projectzero.services;

import java.util.List;

import com.projectzero.dao.AccountDAO;
import com.projectzero.dao.AccountDAOImpl;
import com.projectzero.model.Account;

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
	
	
	public List<Account> findAll() {
		return this.repo.findAll();
	}

//	public int insert(Account e) {
//		return this.rep(e);
//	}
}
