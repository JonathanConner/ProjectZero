package com.projectzero.display.view;

import com.projectzero.Main;
import com.projectzero.exception.InvalidCommandException;
import com.projectzero.model.User;
import com.projectzero.services.AccountService;
import com.projectzero.services.UserService;

public class EmployeeView extends View {

	private UserService us;
	private AccountService as;

	public EmployeeView(UserService us, AccountService as) {
		this.us = us;
		this.as = as;

		System.out.println();
		System.out.println("EMPLOYEE ACCESS GRANTED");
		System.out.println();

		printMenu();

		try {
			this.handleUserInput();
		} catch (InvalidCommandException ice) {

		}
	}

	private void handleUserInput() throws InvalidCommandException {
		while (Main.sc.hasNext()) {
			String input = Main.sc.nextLine();

			switch (input) {
			case "menu":
				this.printMenu();
				break;
			case "view user":
				this.viewUser();
				break;
			case "view all":
				this.viewAllAccounts();
				break;
			case "review":
				this.reviewAccount();
				break;
			case "exit":
				return;
			default:
				throw new InvalidCommandException();
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
	 * Grab all accounts and iterate the results to screen
	 */
	private void viewAllAccounts() {

		this.as.findAll().forEach((acc) -> {
			System.out.println(acc);
		});

	}

	@Override
	public void printMenu() {
		System.out.println();
		System.out.println("Please enter a command.....");
		System.out.println("You have the following option(s)");
		System.out.println();
		System.out.println("\t[view user] - show specific user info");
		System.out.println("\t[view all] - view all accounts");
		System.out.println("\t[review] - to review a particular account application");
		System.out.println("\t[exit] - to return to login");
		System.out.println();
		System.out.println();
	}

	public void viewUser() {
		System.out.println("Enter a username to view:");
		String username = Main.sc.nextLine();
		User user = this.us.findByUserName(username);
		printAccountInfo(user);
	}

	public void printAccountInfo(User user) {
		System.out.println("\tUsername :\t" + user.getUsername());
		System.out.println("\tFull name:\t" + user.getFirstName() + " " + user.getLastName());
		System.out.println("\tEmail    :\t" + user.getEmail());
		System.out.println("\tDOB      :\t" + user.getDob());
		System.out.println("\tAddress  :\t" + user.getAddress());
		System.out.println("\tPhone    :\t" + user.getPhone());
		System.out.println("\tAccount(s):");

		printAccounts(user);

	}

	public void printAccounts(User user) {
		System.out.println();
		user.getAccounts().forEach((acc) -> System.out.println(acc));
		System.out.println();
	}

}
