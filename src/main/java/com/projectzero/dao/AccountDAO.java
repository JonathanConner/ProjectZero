package com.projectzero.dao;

import java.util.List;

import com.projectzero.model.Account;

public interface AccountDAO {

	public boolean transfer(Account source, Account target, double ammount);
	
	public List<Account> findAll();
	public List<Account> findAllPendingAccounts();

	public boolean approveAccountStatus(int account_id);
	
}
