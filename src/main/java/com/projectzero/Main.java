package com.projectzero;

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

		// view = new InitView();
		// Create application run loop so the application doesn't exit
		// Setup initial view

		while (running) {

			// Update the view with menuoptions and then process
			// viewUpdate();
			System.out.println("::::Update View Here:::::");
			
			while (!(sc.nextLine().isEmpty())) {
				// This will process menu options submitted through scanner.
				try {
					int in = Integer.parseInt(sc.nextLine());
					switch (in) {
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

	public static void printHelp() {

		System.out.println("This is the help screen!");

	}

	public static void exit() {
		running = false;
	}
}
