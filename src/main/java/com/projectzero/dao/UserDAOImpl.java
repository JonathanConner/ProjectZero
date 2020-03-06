package com.projectzero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.projectzero.model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean insert(User user) {
		try (Connection conn = com.projectzero.util.ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO users (email, username, password, FIRST_NAME, LAST_NAME, SSN, dob, address, phone, user_type) VALUES(?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getPassword());
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getSsn());
			stmt.setString(1, user.getDob());
			stmt.setString(2, user.getAddress());
			stmt.setString(3, user.getPhone());
			stmt.setString(3, user.getType());

			return stmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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
			
			user.setId(rs.getInt(0));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}

	
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
