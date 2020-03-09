package com.projectzero.dao;

import com.projectzero.model.Account;

public interface AccountDAO {

	public boolean transfer(Account source, Account target, double ammount);
	
}
