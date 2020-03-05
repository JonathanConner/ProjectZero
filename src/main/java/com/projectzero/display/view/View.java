package com.projectzero.display.view;

import java.util.ArrayList;
import java.util.Iterator;

import com.projectzero.dao.DAOInterface;
import com.projectzero.display.view.menu.MenuOption;

public abstract class View {

	public String content = "";
		
	private ArrayList<MenuOption> menuOptions;
	
	public View() {
		this.menuOptions = new ArrayList<MenuOption>();
	}
	
	public void printMenu() {
		
		for(MenuOption mo: menuOptions) {
			System.out.print(menuOptions.indexOf(mo)+". "+mo.toString());
		}
		
	}
	
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
