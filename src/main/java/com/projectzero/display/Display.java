package com.projectzero.display;

import java.util.ArrayList;

import com.projectzero.display.view.View;


public class Display {

	
	private static Display instance = null;

	private ArrayList<MenuOption> menuOptions;

	
	private Display() {
		super();
	}
	
	public static Display getInstance(){
		if(instance!=null)
			return instance;
		
		instance = new Display();
		return instance;
	}
	
	
	public void print(View view) {
		
		//This should assemble the view in System.out with the output and MenuOptions
		view.show();
	}
	
	
	public ArrayList<MenuOption> getMenuOptions(){
		return this.menuOptions;		
	}
	
}
