/**
 * 
 */
package com.projectzero.display.view;

import java.sql.SQLException;
import java.util.ArrayList;

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
 * This is a view for Standard Users
 * It helps control their access separately from any Admin functionality
 * 
 * @author Jon
 *
 */
public class AccountView extends View {

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
		user.getAccounts().forEach((acc)->System.out.println(acc));
		System.out.println();
	}
	
	public void printMenu() {
		System.out.println();
		System.out.println("Please enter a command.....");
		System.out.println("You have the following option(s)");
		System.out.println();
		System.out.println("\t[menu] - to show this menu");
		System.out.println("\t[show info] - to show user information");
		System.out.println("\t[withdraw] - to withdraw funds from an account");
		System.out.println("\t[deposit] - to deposit funds into an account");
		System.out.println("\t[transfer] - to transfer funds");
		System.out.println("\t[exit] - to return to login");
		System.out.println();
		System.out.println();
		
	}
	
	public void handleUserInput() throws InvalidCommandException {
		printMenu();
		while (Main.sc.hasNext()) {
			String input = Main.sc.nextLine();

			switch (input) {
			case "menu" : 
				this.printMenu();
				break;
			case "show info":
				this.printAccountInfo(this.us.getUserInstance());
				break;
			case "apply":
				this.accountApplication();
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
			default: throw new InvalidCommandException();
			}

		}

	}

	public void accountDeposit() {

		
		printAccounts(this.us.getUserInstance());
		
		try {
			//Process user input for passing to service layer
			System.out.println("Enter an account number");
			int accNum = Integer.parseInt(Main.sc.nextLine());
			System.out.println("Enter an ammount to deposit");
			double amount = Double.parseDouble(Main.sc.nextLine());
			
			AccountDAOImpl adi = new AccountDAOImpl();

			adi.accountDeposit(accNum, amount);

		} catch(NumberFormatException nfe) {
			System.out.println("NumberFormatException: incorrect value supplied. Try again");
		}
			
		
	}

	/**
	 * This is a method to withdraw or simply subtract an amount from the account
	 */
	private void accountWithdraw() {
		
		printAccounts(this.us.getUserInstance());
		
		try {
			//Process user input for passing to service layer
			System.out.println("Enter an account number");
			int accNum = Integer.parseInt(Main.sc.nextLine());
			System.out.println("Enter an ammount to withdraw");
			double amount = Double.parseDouble(Main.sc.nextLine());
			
			AccountDAOImpl adi = new AccountDAOImpl();
			
			
			adi.processWithdrawal(accNum, amount);
			
			this.us.loginUser(this.us.getUserInstance().getUsername(), this.us.getUserInstance().getPassword()); // Re query and load a new updated user object with updated accounts
		} catch(NumberFormatException nfe) {
			System.out.println("NumberFormatException: incorrect value supplied. Try again");
		}
		
	}

	/**
	 * Transfer money between two accounts
	 */
	private void accountTransfer() {
		
		printAccounts(this.us.getUserInstance());
		
		
		try {
			//Process user input for passing to service layer
			System.out.println("Enter an account ID to transfer FROM (source)");
			int sourceAccount = Integer.parseInt(Main.sc.nextLine());
			System.out.println("Enter an account ID to transfer TO (destination)");
			int targetAccount = Integer.parseInt(Main.sc.nextLine());
			System.out.println("Enter the ammount:");
			double amount = Double.parseDouble(Main.sc.nextLine());
			
			this.as.transfer(sourceAccount, targetAccount, amount);
			
		} catch(NumberFormatException nfe) {
			System.out.println("NumberFormatException: incorrect value supplied. Try again");
		}
			
		
	}

	private void accountApplication() {

		System.out.println("Would you like to apply for an account? (Y/N)");
		Account acc;
		if(Main.sc.nextLine().equals("Y")) {
			 acc = this.as.applyForNewAccount(this.us.getUserInstance());
			 System.out.println("Account created. Status is pending.");
		}
		
		//insert account id and user id into jt
		
		
	}

}
