package com.projectzero.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import com.projectzero.model.Account;
import com.projectzero.model.User;
import com.projectzero.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	private Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Override
	public boolean insert(User user) {
		try (Connection conn = com.projectzero.util.ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO users (email, username, password, first_name, last_name, ssn, dob, address, phone, user_type) VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getFirstName());
			stmt.setString(5, user.getLastName());
			stmt.setString(6, user.getSsn());
			stmt.setString(7, user.getDob());
			stmt.setString(8, user.getAddress());
			stmt.setString(9, user.getPhone());
			stmt.setString(10, user.getType());

			return stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Utility method for generating a random account number
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public int generateAccountNumber(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;

	}

	@Override
	public boolean applyForNewAccount(int id) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{ call insert_new_account(?,?) }";

			CallableStatement st = conn.prepareCall(sql);
			st.setInt(1, this.generateAccountNumber(100000000, 999999999));
			st.setInt(2, id);

			return !st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean applyForNewJointAccount(int userid1, int userid2) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{ call insert_new_joint_account(?,?, ?) }";

			CallableStatement st = conn.prepareCall(sql);
			st.setInt(1, this.generateAccountNumber(100000000, 999999999));
			st.setInt(2, userid1);
			st.setInt(3, userid2);

			return !st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public List<Account> findUsersAccounts(int userId) {

		List<Account> list = new ArrayList<>();
		try (Connection conn = com.projectzero.util.ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users_accounts_view WHERE user_id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, userId);

			// Get the result set and put the results into a user object
			// then return the object
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Account a = new Account(rs.getInt("id"), rs.getInt("balance"));
				a.setAccountNumber(rs.getInt("account_number"));
				int stat_code = rs.getInt("approved");
//			
				if (stat_code == 1)
					a.setStatus("approved");
				else
					a.setStatus("unapproved");

				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public User find(String username) {

		User user = new User();
		try (Connection conn = com.projectzero.util.ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users WHERE username = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, username);

			// Get the result set and put the results into a user object
			// then return the object
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setFirstName(rs.getString(5));
				user.setLastName(rs.getString(6));
				user.setSsn(rs.getString(7));
				user.setDob(rs.getString(8));
				user.setAddress(rs.getString(9));
				user.setPhone(rs.getString(10));
				user.setType(rs.getString(11));
			}

			// Logger Info message here.

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	@Override
	public List<User> findAll() {

		List<User> allUsers = new ArrayList<User>();
		try (Connection conn = com.projectzero.util.ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// May need to sensor this if time permits
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setFirstName(rs.getString(5));
				user.setLastName(rs.getString(6));
				user.setSsn(rs.getString(7));
				user.setDob(rs.getString(8));
				user.setAddress(rs.getString(9));
				user.setPhone(rs.getString(10));
				user.setType(rs.getString(11));
				allUsers.add(user);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return allUsers;
	}

}
