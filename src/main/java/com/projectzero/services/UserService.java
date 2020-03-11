package com.projectzero.services;

import java.util.List;

import com.projectzero.Main;
import com.projectzero.dao.UserDAO;
import com.projectzero.dao.UserDAOImpl;
import com.projectzero.model.Account;
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
			
			user_tmp.setAccounts(repo.findUsersAccounts(user_tmp.getId()));
			
			System.out.println("Login Successful");	
			this.userInstance = user_tmp;	
			
			//Set the users accounts list

		}
		
		public boolean applyForNewAccount(User user) {
			this.repo.applyForNewAccount(user.getId());
			return true;
			
		}
		
		public boolean applyForNewJointAccount(User user, String username) {
			
			User user2 = findByUserName(username);
			
			this.repo.applyForNewJointAccount(user.getId(), user2.getId());
			
			return true;
		
		}
		
		
		
		public void updateUserAccountsList(String username) {
		
			User user_tmp = repo.find(username);
			user_tmp.setAccounts(repo.findUsersAccounts(user_tmp.getId()));
			this.userInstance = user_tmp;	

		}
		
		public User getUserInstance() {
			return this.userInstance; 
		}


		public User findByUserName(String username) {
			User user_tmp = repo.find(username);
			user_tmp.setAccounts(repo.findUsersAccounts(user_tmp.getId()));
			return user_tmp;
		}
		
		public List<Account> findUsersAccounts(int userid){
			return this.repo.findUsersAccounts(userid);
		}
	
}
