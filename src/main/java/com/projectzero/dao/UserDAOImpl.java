package com.projectzero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.projectzero.model.User;

public class UserDAOImpl implements UserDAO {

	private Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	
	@Override
	public boolean insert(User user) {
		try (Connection conn = com.projectzero.util.ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO users (email, username, password, first_name, last_name, ssn, dob, address, phone, user_type) VALUES(?,?,?,?,?,?,?,?,?,?)";

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

			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public User find(String username) {

		User user = new User();
		try (Connection conn = com.projectzero.util.ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM users WHERE username = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			
			//Get the result set and put the results into a user object
			// then return the object
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
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
			
			
			
			//Logger Info message here.
			
		}catch (SQLException e) {
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
			//May need to sensor this if time permits
			while(rs.next()) {
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
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return allUsers;
	}

}
