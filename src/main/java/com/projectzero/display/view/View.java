package com.projectzero.display.view;

import java.util.ArrayList;
import java.util.Iterator;

import com.projectzero.dao.DAOInterface;
import com.projectzero.display.MenuOption;

public abstract class View {

	
	private DAOInterface dao;
	
	private ArrayList<MenuOption> menuOptions;
	
	public View(DAOInterface dao) {
		this.dao = dao;
		this.menuOptions = new ArrayList<MenuOption>();
	}
	
	public DAOInterface getDao() {
		return this.dao;
	}
	
	public abstract void show();
	
	public void printMenu() {
		
		for(MenuOption mo: menuOptions) {
			System.out.print(menuOptions.indexOf(mo)+". "+mo.toString());
		}
		
	}
	
	public void addMenuOption(MenuOption mo) {
		menuOptions.add(mo);
	}
	
}
