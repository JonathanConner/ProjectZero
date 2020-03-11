/**
 * 
 */
package com.projectzero.display.view;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.projectzero.Main;
import com.projectzero.dao.AccountDAOImpl;
import com.projectzero.exception.InvalidCommandException;
import com.projectzero.model.Account;
import com.projectzero.model.User;
import com.projectzero.services.AccountService;
import com.projectzero.services.UserService;

/**
 * 
 * 
 * This is a view for Standard Users It helps control their access separately
 * from any Admin functionality
 * 
 * @author Jon
 *
 */
public class AccountView extends View {

	private static Logger logger = Logger.getLogger(AccountView.class);

	private UserService us;
	private AccountService as;

	public AccountView(UserService us, AccountService as) {
		this.us = us;
		this.as = as;

		User user = this.us.getUserInstance();

		System.out.println();
		System.out.println("Hello, " + user.getFirstName() + " " + user.getLastName());

		printAccountInfo(user);

		try {
			this.handleUserInput();
		} catch (InvalidCommandException ice) {

		}

	}

	public void printAccountInfo(User user) {
		System.out.println();
		System.out.println("\tUsername :\t" + user.getUsername());
		System.out.println("\tFull name:\t" + user.getFirstName() + " " + user.getLastName());
		System.out.println("\tEmail    :\t" + user.getEmail());
		System.out.println("\tDOB      :\t" + user.getDob());
		System.out.println("\tAddress  :\t" + user.getAddress());
		System.out.println("\tPhone    :\t" + user.getPhone());
		System.out.println("Account(s):");

		printAccounts(user);

	}

	/**
	 * Print out the current state of accounts for the user.
	 * @param user
	 */
	public void printAccounts(User user) {
		
		user.setAccounts(this.us.findUsersAccounts(user.getId())); //set user accounts to new object
		
		user.getAccounts().forEach((acc) -> System.out.println(acc)); //iterate over the new object
		
		System.out.println();
	}

	public void handleUserInput() throws InvalidCommandException {
		printMenu();
		while (Main.sc.hasNext()) {
			String input = Main.sc.nextLine();

			switch (input) {
			case "menu":
				this.printMenu();
				break;
			case "show info":
				this.printAccountInfo(this.us.getUserInstance());
				break;
			case "apply":
				this.accountApplication();
				break;
			case "joint apply":
				this.jointAccountApplication();
				break;
			case "transfer":
				this.accountTransfer();
				break;
			case "withdraw":
				this.accountWithdraw();
				break;
			case "deposit":
				this.accountDeposit();
				break;
			case "exit":
				return;
			default:
				throw new InvalidCommandException("ICE: You have enetered an invalid command, please try again.");
			}

		}

	}

	public void accountDeposit() {

		printAccounts(this.us.getUserInstance());

		try {
			// Process user input for passing to service layer
			System.out.println("Enter an account number");
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

		printAccounts(this.us.getUserInstance());

		try {
			// Process user input for passing to service layer
			System.out.println("Enter an account number");
			int accNum = Integer.parseInt(Main.sc.nextLine());
			System.out.println("Enter an ammount to withdraw");
			double amount = Double.parseDouble(Main.sc.nextLine());

			AccountDAOImpl adi = new AccountDAOImpl();

			adi.processWithdrawal(accNum, amount);
			logger.info("Account Number " + accNum +" withdrawal "+amount+" complete!");
			
		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException: incorrect value supplied. Try again");
		}

	}

	/**
	 * Transfer money between two accounts TODO: update account info afterwards
	 */
	private void accountTransfer() {

		printAccounts(this.us.getUserInstance());

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

	private void accountApplication() {

		System.out.println("Would you like to apply for an account? (Y/N)");
		if (Main.sc.nextLine().equals("Y")) {

			if (this.us.applyForNewAccount(this.us.getUserInstance()))
				logger.info("Account created. Status is pending.");
		}

		// insert account id and user id into jt

	}

	private void jointAccountApplication() {

		System.out.println("Would you like to apply for an account? (Y/N)");
		if (Main.sc.nextLine().equals("Y")) {
			System.out.println("Enter a another username (not yourself) to apply with:");
			String username = Main.sc.nextLine();
			if (this.us.applyForNewJointAccount(this.us.getUserInstance(), username))
				logger.info("Joint account created! Status is pending.");
		}
	}

	@Override
	public void printMenu() {
		System.out.println();
		System.out.println("Please enter a command.....");
		System.out.println("You have the following option(s)");
		System.out.println();
		
		System.out.println("\t[menu] - to show this menu");
		System.out.println("\t[apply] - to apply for a joint account");
		System.out.println("\t[joint apply] - to apply for a joint account");
		System.out.println("\t[show info] - to show user information");
		System.out.println("\t[withdraw] - to withdraw funds from an account");
		System.out.println("\t[deposit] - to deposit funds into an account");
		System.out.println("\t[transfer] - to transfer funds");
		System.out.println("\t[exit] - to return to login");
		System.out.println();
		System.out.println();

	}

}
