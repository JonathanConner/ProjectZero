/**
 * 
 */
package com.projectzero.display.view;

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
		//Get user from the database and check passwords
		System.out.println("Enter your Username: ");
		String username = Main.sc.nextLine();
		System.out.println("Enter your Password: ");
		String password = Main.sc.nextLine();
		
		
		us.loginUser(username, password); //call to the UserService for Login
		
		
		if(us.getUserInstance()!=null) {
			if(us.getUserInstance().getType().equals("admin")) {
				new AdminView(us, new AccountService()); //Create an Admin View
			} else {
				new AccountView(us, new AccountService());// Create a Standard Account View
			}
		} else {
			System.out.println("Login failed! Try again.");
			return;
		}
		
		return;
		
	}
	
	
}
