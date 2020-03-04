package com.projectzero.display;

import java.util.ArrayList;

import com.projectzero.display.view.View;


public class Display {

	
	private static Display instance = null;
	public static View view;

	private Display() {
		super();
	}
	
	public static void update() {
		view.show();
	}
	
	public static void update(View newview) {
		view = newview;
		view.show();
	}
	
	public static Display getInstance(){
		if(instance!=null)
			return instance;
		
		instance = new Display();
		return instance;
	}

	
}
