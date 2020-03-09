/**
 * 
 */
package com.projectzero.display.view;

import java.util.ArrayList;

import com.projectzero.Main;
import com.projectzero.exception.InvalidCommandException;
import com.projectzero.model.User;
import com.projectzero.services.UserService;


/**
 * @author Jon 
 *
 */
public class AccountView extends View {

	private UserService us;
	public AccountView(UserService us) {
		this.us = us;

		User user = us.getUserInstance();
		
		System.out.println("Hello, "+user.getFirstName()+" "+
				user.getLastName());

		printAccountInfo(user);
		
		try {
			this.handleUserInput();
		} catch(InvalidCommandException ice) {
			
		};	
		
	}

	private void printAccountInfo(User user) {
		System.out.println("\tUsername :\t" + user.getUsername());
		System.out.println("\tFull name:\t" + user.getFirstName()+" " + user.getLastName());
		System.out.println("\tEmail    :\t" + user.getEmail());
		System.out.println("\tDOB      :\t" + user.getDob());
		System.out.println("\tAddress  :\t" + user.getAddress());
		System.out.println("\tPhone    :\t" + user.getPhone());
		System.out.println("\tAccount(s):\t"); 
		user.getAccounts().forEach((acc)->System.out.println(acc));
	}
	
	private void handleUserInput() throws InvalidCommandException {
		
		while(Main.sc.hasNext()) {
			String input = Main.sc.nextLine();
			
			switch(input) {
				
			}
			
		}
		
	}
	
	
	
	
	
	
	

}
