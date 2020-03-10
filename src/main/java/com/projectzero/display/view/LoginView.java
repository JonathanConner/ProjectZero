/**
 * 
 */
package com.projectzero.display.view;

import org.apache.log4j.Logger;

import com.projectzero.Main;
import com.projectzero.services.AccountService;
import com.projectzero.services.UserService;

/**
 * @author Jon
 *
 */
public class LoginView {
	
	
	
	/**
	 * 
	 * @param us
	 */
	public LoginView(UserService us) {
		Logger logger = Logger.getLogger(LoginView.class); 
		
		//Get user from the database and check passwords
		System.out.println("Enter your Username: ");
		String username = Main.sc.nextLine();
		System.out.println("Enter your Password: ");
		String password = Main.sc.nextLine();
		
		
		us.loginUser(username, password); //call to the UserService for Login
		
		
		if(us.getUserInstance()!=null) {
			if(us.getUserInstance().getType().equals("admin")) {
				logger.info("Opening admin view...");
				new AdminView(us, new AccountService()); //Create an Admin View
			} 
			if(us.getUserInstance().getType().equals("employee")){
				logger.info("Opening employee view...");
				new EmployeeView(us, new AccountService());// Create a Employee View
			} 
			if(us.getUserInstance().getType().equals("test")){
//				{
				logger.info("Opening standard account view...");
				new AccountView(us, new AccountService());// Create a Standard Account View
			}
		} else {
			logger.error("Login failed! Try again.");
			return;
		}
		
		return;
		
	}
	
	
}
