package com.projectzero.display.view;

import org.apache.log4j.Logger;

import com.projectzero.Main;
import com.projectzero.dao.AccountDAOImpl;
import com.projectzero.exception.InvalidCommandException;
import com.projectzero.services.AccountService;
import com.projectzero.services.UserService;

public class AdminView extends View {

	private static Logger logger = Logger.getLogger(AdminView.class);

	private UserService us;

	private AccountService as;

	public AdminView(UserService us, AccountService as) {
		this.us = us;
		this.as = as;

		System.out.println("\nBANK ADMIN ACCESS GRANTED!");

		this.handleUserInput();

	}

	/**
	 * Transfer money between two accounts TODO: update account info afterwards
	 */
	private void accountTransfer() {

		viewAllAccounts();

		int sourceAccount;
		int targetAccount;
		double amount;

		try {
			// Process user input for passing to service layer
			System.out.println("Enter an account ID to transfer FROM (source)");
			sourceAccount = Integer.parseInt(Main.sc.nextLine());
			System.out.println("Enter an account ID to transfer TO (destination)");
			targetAccount = Integer.parseInt(Main.sc.nextLine());
			System.out.println("Enter the ammount:");
			amount = Double.parseDouble(Main.sc.nextLine());

			this.as.transfer(sourceAccount, targetAccount, amount);

			logger.info("Account Transfer from Account " + sourceAccount + " to " + targetAccount + " was SUCCESSFUL!");

		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException: incorrect value supplied. Try again");
		}

	}


	private void handleUserInput() throws InvalidCommandException {

		printMenu();
		while (Main.sc.hasNext()) {
			String input = Main.sc.nextLine();

			switch (input) {
			case "view all accounts":
				this.viewAllAccounts();
				break;
			case "view all users":
				this.viewAllUsers();
				break;
			case "review":
				this.reviewAccount();
				break;
			case "deposit":
				this.accountDeposit();
				break;
			case "withdraw":
				this.accountWithdraw();
				break;
			case "transfer":
				this.accountTransfer();
				break;
			case "modify user":
				this.modifyUser();
				break;
			case "menu":
				printMenu();
				break;
			case "exit":
				return;

			default:
				throw new InvalidCommandException("ICE: You have enetered an invalid command, please try again.");

			}

		}

	}

	public void accountDeposit() {

		viewAllAccounts();

		try {
			// Process user input for passing to service layer
			System.out.println("Enter an account ID");
			int accNum = Integer.parseInt(Main.sc.nextLine());
			System.out.println("Enter an ammount to deposit");
			double amount = Double.parseDouble(Main.sc.nextLine());

			AccountDAOImpl adi = new AccountDAOImpl();

			adi.accountDeposit(accNum, amount);

		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException: incorrect value supplied. Try again");
		}

	}

	/**
	 * This is a method to withdraw or simply subtract an amount from the account
	 */
	private void accountWithdraw() {

		viewAllAccounts();

		try {
			// Process user input for passing to service layer
			System.out.println("Enter an account number");
			int accNum = Integer.parseInt(Main.sc.nextLine());
			System.out.println("Enter an ammount to withdraw");
			double amount = Double.parseDouble(Main.sc.nextLine());

			AccountDAOImpl adi = new AccountDAOImpl();

			adi.processWithdrawal(accNum, amount);

			logger.info("Account Withdrawal from Account " + accNum +" was SUCCESSFUL!");

			this.us.loginUser(this.us.getUserInstance().getUsername(), this.us.getUserInstance().getPassword()); // Re
																													// query
																													// and
																													// load
																													// a
																													// new
																													// updated
																													// user
																													// object
																													// with
																													// updated
																													// accounts

		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException: incorrect value supplied. Try again");
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
		} catch (NumberFormatException nfe) {
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
		this.us.findAll().forEach((accs) -> {
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

	/**
	 * Grab all users and iterate the results to screen
	 */
	private void viewAllUsers() {

		this.us.findAll().forEach((u) -> {
			System.out.println(u);
		});
	}
	
	
	
	
	public void printMenu() {
		System.out.println("Please enter a command.....");
		System.out.println();
		System.out.println("You have the following option(s)");
		System.out.println();
		System.out.println("\t[view all accounts] - to view all accounts");
		System.out.println("\t[view all users] - to view all users");
		System.out.println("\t[review] - to review a particular account application");
		System.out.println("\t[withdraw] - to withdraw funds from an account");
		System.out.println("\t[deposit] - to deposit funds into an account");
		System.out.println("\t[transfer] - to transfer funds");
		System.out.println("\t[menu] - to print the menu");
		System.out.println("\t[exit] - to return to login");
		System.out.println();
		System.out.println();
	}

}
