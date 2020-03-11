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
			//Initialize the program with a view
			new InitView();
		}
	}


	public static void exit() {
		running = false;
	}
}
