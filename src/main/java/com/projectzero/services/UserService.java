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
	
		public User loginUser() {
			
			
			
			//Get user from the database and check passwords
			System.out.println("Enter your Username: ");
			String username = Main.sc.nextLine();
			System.out.println("Enter your Password: ");
			String password = Main.sc.nextLine();
			
			User user_tmp = repo.find(username);
			
			return user_tmp;
			
			
		}
		
	
}
