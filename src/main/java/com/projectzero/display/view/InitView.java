package com.projectzero.display.view;

import com.projectzero.Main;
import com.projectzero.exception.InvalidCommandException;
import com.projectzero.services.UserService;

public class InitView extends View {

	
	/**
	 * This is the initial view that is created in the application
	 * This handles two commands
	 * 	- login - which creates a LoginView to handle registration functionality
	 * 	- register - which creates RegisterView to handle registration functionality
	 */
	public InitView() {
		
		System.out.println("------------------------------------");
		System.out.println("\tWelcome to the Bank!\t");
		System.out.println("------------------------------------");
		printMenu();
		try {
			this.handleUserInput();
		} catch(InvalidCommandException ice) {
			
		};
	}

	public void printMenu() {
		System.out.println("Would you like to login or register?");
	}
	
	public void handleUserInput() throws InvalidCommandException{
		String input = Main.sc.nextLine();
		
		switch(input) {
			case "login": new LoginView(new UserService());
					break;
			case "register": new RegisterView(new UserService());
					break;
			default: throw new InvalidCommandException();
		}
		
	}
	
	
}
