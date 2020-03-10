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

	public AccountView(UserService us) {
		this.us = us;

		User user = us.getUserInstance();

		System.out.println("Hello, " + user.getFirstName() + " " + user.getLastName());

		printAccountInfo(user);

		try {
			this.handleUserInput();
		} catch (InvalidCommandException ice) {

		}

	}

	private void printAccountInfo(User user) {
		System.out.println("\tUsername :\t" + user.getUsername());
		System.out.println("\tFull name:\t" + user.getFirstName() + " " + user.getLastName());
		System.out.println("\tEmail    :\t" + user.getEmail());
		System.out.println("\tDOB      :\t" + user.getDob());
		System.out.println("\tAddress  :\t" + user.getAddress());
		System.out.println("\tPhone    :\t" + user.getPhone());
		System.out.println("\tAccount(s):\t");
//		user.getAccounts().forEach((acc) -> System.out.println(acc));
	}
	public void printMenu() {

		System.out.println("Please enter a command.....");
		System.out.println();
		System.out.println("You have the following option(s)");
		System.out.println();
		System.out.println("\t[menu] - to show this menu");
		System.out.println("\t[show info] - to show user information");
		System.out.println("\t[withdraw] - to withdraw funds from an account");
		System.out.println("\t[deposit] - to deposit funds into an account");
		System.out.println("\t[transfer] - to transfer funds");
		System.out.println("\t[exit] - to return to login");
		
	}
	private void handleUserInput() throws InvalidCommandException {
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
				this.accountTransfer();
				break;
			case "exit":
				return;
			default: throw new InvalidCommandException();
			}

		}

	}

	/**
	 * This is a method to withdraw or simply subtract an amount from the account
	 */
	private void accountWithdraw() {

		
	}

	/**
	 * Transfer money between two accounts
	 */
	private void accountTransfer() {
		// TODO Auto-generated method stub

	}

	private void accountApplication() {

		System.out.println("Would you like to apply for an account? (Y/N)");
		// Handle logic for adding a new unverified account
		
	}

}
