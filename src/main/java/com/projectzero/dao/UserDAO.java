package com.projectzero.dao;

import java.util.List;

import com.projectzero.model.Account;
import com.projectzero.model.User;

public interface UserDAO {


		public boolean insert(User obj);
		public User find(String username);
		public List<User> findAll();
		
		public List<Account> findUsersAccounts(int userId);

}
