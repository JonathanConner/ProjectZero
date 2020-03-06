package com.projectzero;

import java.sql.Connection;
import java.util.Scanner;

import com.projectzero.display.view.AccountView;
import com.projectzero.display.view.InitView;
import com.projectzero.display.view.View;
import com.projectzero.exception.InvalidCommandException;

public class Main {

	public static Scanner sc = null;
	public static boolean running = true;

	public static void endProgram() {
		running = false;
	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);


		System.out.println("===============================");
		System.out.println("\n   Welcome to the Bank!\n");
		System.out.println("===============================");
		System.out.println("\n   Please Login or Register\n   to use this application");
		System.out.println("===============================");
		System.out.println("===============================");
		// Create application run loop so the application doesn't exit
		// Setup initial view

		try (Connection conn = com.projectzero.util.ConnectionUtil.getConnection()) {
			System.out.println("Connected");
		}catch(Exception e) {System.out.println("Connection Failed");}
		
		
		while (running) {

			// Update the view with menuoptions and then proces

			while (!(sc.nextLine().isEmpty())) {
				// This will process menu options submitted through scanner.
				try {
					int in = Integer.parseInt(sc.nextLine());
					switch (in) {
					case 1:
						setView(new AccountView());
						break;
					case 0:
						exit();
						break;
					default:
						throw new InvalidCommandException();
					}
				} catch (InvalidCommandException ice) {
					System.out.println(ice.getMessage()); // TODO Replace with Logger in Log4j
				}
				break;

			}
		}
	}

	private static View view;

	public static void setView(View v) {
		view = v;
	}

	public static void viewUpdate() {
		view.show();
	}

	public static void printHelp() {

		System.out.println("This is the help screen!");

	}

	public static void exit() {
		running = false;
	}
}
