package com.projectzero.display.view;

import java.util.ArrayList;
import java.util.Iterator;

import com.projectzero.display.view.menu.MenuOption;

public abstract class View {

	public String content = "";
		
	private ArrayList<MenuOption> menuOptions;
	
	public View() {
		this.menuOptions = new ArrayList<MenuOption>();
	}
	
	public abstract void printMenu();
	public void addMenuOption(MenuOption mo) {
		menuOptions.add(mo);
	}

	
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void show() {
		System.out.print(this.content);
	};
	
}
