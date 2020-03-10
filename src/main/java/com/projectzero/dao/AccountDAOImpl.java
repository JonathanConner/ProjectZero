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
import java.util.Random;

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

	public boolean accountDeposit(int accNum, double amount) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
//
			String sql = "UPDATE account SET balance = balance + ? WHERE account_number = ?";
//			
			
			PreparedStatement stmt1 = conn.prepareStatement(sql);

			stmt1.setDouble(1, amount);
			stmt1.setInt(2, accNum);
			
			stmt1.execute();
		} catch(SQLException sqle) {
			
		}	
		System.out.println("Account Number " + accNum +" deposit complete!");

		return true;
	}
	
	
	public int generateAccountNumber(int min, int max) {

			if (min >= max) {
				throw new IllegalArgumentException("max must be greater than min");
			}

			Random r = new Random();
			return r.nextInt((max - min) + 1) + min;

	}
	
	public Account insert(User user) {
		Account a = new Account();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
//
			int randomAccountNumber = generateAccountNumber(1000000, 9999999);
			String sql = "INSERT INTO account (balance, approved, account_number) VALUES (?,?,?)";
//			
			PreparedStatement stmt1 = conn.prepareStatement(sql);

			stmt1.setDouble(1, 0.00);
			stmt1.setInt(2, 0);
			stmt1.setInt(3, randomAccountNumber);
			
			stmt1.execute();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;

//
//		
	}

//	public int findBy(int accNum) {}
	
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
				int accountNumber = rs.getInt("account_number");
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
	
	public boolean processWithdrawal(int accountNumber, double amount) {
//
//
		
		
		try (Connection conn = com.projectzero.util.ConnectionUtil.getConnection()) {

			
			String sql = "UPDATE account SET balance = balance - ? WHERE account_number = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setDouble(1, amount);
			stmt.setInt(2, accountNumber);
			
			stmt.executeUpdate();
			
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		System.out.println("Account Number " + accountNumber +" withdrawal complete!");
		return true;
		
	}

	@Override
	public Account findByAccountNumber(int accNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account insert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertIntoJoinTable(Account acc, User user) {
		try (Connection conn = ConnectionUtil.getConnection()) {


		String sql3 = "INSERT INTO users_account_jt (account_id, user_id) VALUES (?,?)";

		PreparedStatement stmt3 = conn.prepareStatement(sql3);

		stmt3.setInt(1, acc.getId());
		stmt3.setInt(2, user.getId());;
		
		stmt3.execute();
		
		}catch(SQLException sqle) {
			System.out.println("Failed to insert into JT");
		}
		
		return 0;
	}
	
//	public Account findByAccountNumber(int accountNumber) {
//	
//	}

}
