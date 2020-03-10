package com.projectzero.dao;

import java.util.List;

import com.projectzero.model.Account;
import com.projectzero.model.User;

public interface AccountDAO {

	public boolean transfer(Account source, Account target, double ammount);
	
	public List<Account> findAll();
	public List<Account> findAllPendingAccounts();

	public boolean approveAccountStatus(int account_id);
	
	public Account insert();
	
	public int insertIntoJoinTable(Account acc, User user);
	
	
	public Account findByAccountNumber(int accNum);

	
}
