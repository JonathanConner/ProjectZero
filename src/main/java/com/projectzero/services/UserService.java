package com.projectzero.services;

import java.util.List;

import com.projectzero.Main;
import com.projectzero.dao.UserDAO;
import com.projectzero.dao.UserDAOImpl;
import com.projectzero.model.User;

public class UserService {

		UserDAO repo = null;

		private User userInstance = null;
		
		
		public UserService() {
			super();
			this.repo = new UserDAOImpl();
		}

		public List<User> findAll(){
			return repo.findAll();
		}
		
		
		public boolean registerUser(User user) {
			return repo.insert(user); //User has been added to the database and can now be used.
		}
	
		/**
		 * This finds the user in the database according to the user name 
		 * and checks that the entered password matches the one in the DB.
		 * 
		 * If checks pass set the current user instance variable if not it remains NULL
		 * 
		 * @param username
		 * @param password
		 */
		public void loginUser(String username, String password) {
			
			
			User user_tmp = repo.find(username);
		
			if(password == user_tmp.getPassword())
			{
				this.userInstance = user_tmp;	
			} 
			
			
			
		}
		
		public User getUserInstance() {
			return this.userInstance; 
		}
	
}
