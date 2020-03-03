package com.projectzero;

import java.util.Scanner;

import com.projectzero.display.view.AccountView;
import com.projectzero.display.view.View;

public class Main {

	public static Scanner sc = null;
	public static boolean running = true;
	public static View view;
	public static void viewUpdate() {
		view.show();
	}
	public static void endProgram() {running = false;}
	public static void main(String[] args) {
			
		sc = new Scanner(System.in);
		
		view = new InitView();

		//Create application run loop so the application doesn't exit
		//Setup initial view
		while(running) {
			//Update the view with menuoptions and then process
			viewUpdate();
			while(sc.hasNext()) {
				//This will process menu options submitted through scanner. 
				
			}
			
		}
		
		
		
	}

}
