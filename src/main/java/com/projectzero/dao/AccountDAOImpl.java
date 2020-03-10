package com.projectzero.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.projectzero.model.Account;
import com.projectzero.model.User;
import com.projectzero.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public boolean transfer(Account source, Account target, double ammount) {
//		try (Connection conn = ConnectionUtil.getConnection()) {
//
//			String sql = "{ call transfer_funds(?,?,?) }";
//
//			Statement st = conn.createStatement();
//			st.setInt(1, source.getOwner().getEmployeeId());
//			st.setInt(2, target.getOwner().getEmployeeId());
//			st.setDouble(3, amount);
//
//			return stmt.execute();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return false;

	}

	public int insert(Account a) {
//
//		try (Connection conn = ConnectionUtil.getConnection()) {
//
//			String sql = "{ call insert_into_accounts(?, ?) }";
//
//			CallableStatement stmt = conn.prepareCall(sql);
//			stmt.registerOutParameter(1, Types.INTEGER);
//
//			stmt.setInt(2, a.getOwners());
//
//			if (stmt.execute()) {
//				return (Integer) stmt.getObject(1);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
		
		return 0;
	}

	public List<Account> findAllPendingAccounts(){
		List<Account> list = new ArrayList<>();
//		List<User> owners = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM account WHERE approved = 0";
//
			Statement stmt = conn.createStatement();
//
			ResultSet rs = stmt.executeQuery(sql);
//
			while (rs.next()) {
				int id = rs.getInt("id");
				double balance = rs.getDouble("balance");
				int stat_code = rs.getInt("approved");
//				
				Account a = new Account(id, balance);

				if(stat_code == 1)
						a.setStatus("approved");
				else
						a.setStatus("unapproved");
				
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//
		return list;
	}
	
	@Override
	public List<Account> findAll() {
//		
		List<Account> list = new ArrayList<>();
//		List<User> owners = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM account";
//
			Statement stmt = conn.createStatement();
//
			ResultSet rs = stmt.executeQuery(sql);
//
			while (rs.next()) {
				int id = rs.getInt("id");
				double balance = rs.getDouble("balance");
				int stat_code = rs.getInt("approved");
//				
				Account a = new Account(id, balance);

				if(stat_code == 1)
						a.setStatus("approved");
				else
						a.setStatus("unapproved");
				
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//
		return list;
	}

	@Override
	public boolean approveAccountStatus(int account_id) {

		
		try (Connection conn = ConnectionUtil.getConnection()) {

		    String sql = "UPDATE account " +
		                  "SET approved = 1 WHERE id = ?";
			
		    PreparedStatement stmt = conn.prepareStatement(sql); // Create a prepared statement to update an accounts status
			
			stmt.setInt(1, account_id);
		    stmt.executeUpdate();
//
		    	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
