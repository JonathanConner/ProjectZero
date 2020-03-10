package com.projectzero.display.view;

import com.projectzero.Main;
import com.projectzero.exception.InvalidCommandException;
import com.projectzero.services.AccountService;
import com.projectzero.services.UserService;

public class AdminView extends View {
	private UserService us;
	private AccountService as;

	public AdminView(UserService us, AccountService as) {
		this.us = us;
		this.as = as;

		System.out.println("\n\tBANK ADMIN ACCESS GRANTED!");

		try {
			this.handleUserInput();
		} catch (InvalidCommandException ice) {

		}
		;
	}

	public void printMenu() {
		System.out.println("Please enter a command.....");
		System.out.println();
		System.out.println("You have the following option(s)");
		System.out.println();
		System.out.println("\t[view all] - to view all accounts");
		System.out.println("\t[modify user] - to modify any user's information");
		System.out.println("\t[review] - to review a particular account application");
		System.out.println("\t[menu] - to print the menu");
		System.out.println("\t[exit] - to return to login");
	}

	private void handleUserInput() throws InvalidCommandException {

		printMenu();
		while (Main.sc.hasNext()) {
			String input = Main.sc.nextLine();

			switch (input) {
			case "view all":
				this.viewAllAccounts();
				break;
			case "review":
				this.reviewAccount();
				break;
			case "modify user":
				this.modifyUser();
				break;
			case "menu":
				printMenu();
				break;
			case "exit":
				return;
			}

		}

	}

	/**
	 * Handles logic for approving any accounts
	 */
	private void reviewAccount() {
		
		printPendingAccounts(); // go ahead and print the pending accounts for ease of use
		
		System.out.println("Please enter an account ID you wish to approve...");
		
		try {
			int parsedInt = Integer.parseInt(Main.sc.nextLine());
			this.as.approveAccountStatus(parsedInt);
		}catch(NumberFormatException nfe) {
			System.out.println("NumberFormatException: Invalid ID format entered!");
		}
	}

	/**
	 * Helper method to simply print pending accounts from service layer
	 */
	private void printPendingAccounts() {
		this.as.findAllPendingAccounts().forEach((pending) -> {
			System.out.println(pending);
		});
	}

	/**
	 * Helper method to loop over and print all users
	 */
	private void printUsers() {
		this.us.findAll().forEach((accs)->{
			System.out.println(accs);
		});
	}
	
	
	private void modifyUser() {
		printUsers();
		System.out.println();
		System.out.println("Please enter a user ID to modify.");
	}

	/**
	 * Grab all accounts and iterate the results to screen
	 */
	private void viewAllAccounts() {

		this.as.findAll().forEach((acc) -> {
			System.out.println(acc);
		});

	}

}
