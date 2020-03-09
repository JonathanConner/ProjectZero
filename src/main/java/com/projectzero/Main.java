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
		

		while (running) {

			new InitView();
			
			/*
			 * while (!(sc.nextLine().isEmpty())) { // This will process menu options
			 * submitted through scanner. try { int in = Integer.parseInt(sc.nextLine());
			 * switch (in) { case 1: setView(new AccountView()); break; case 0: exit();
			 * break; default: throw new InvalidCommandException(); } } catch
			 * (InvalidCommandException ice) { System.out.println(ice.getMessage()); // TODO
			 * Replace with Logger in Log4j } break;
			 */
			
		}
	}


	public static void exit() {
		running = false;
	}
}
