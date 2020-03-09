package com.projectzero.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.projectzero.model.Account;
import com.projectzero.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public boolean transfer(Account source, Account target, double ammount) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "{ call transfer_funds(?,?,?) }";
			
			return true;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	
	}

}
