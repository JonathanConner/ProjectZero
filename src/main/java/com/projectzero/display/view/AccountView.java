/**
 * 
 */
package com.projectzero.display.view;

import java.util.ArrayList;

import com.projectzero.dao.DAOInterface;

/**
 * @author Jon
 *
 */
public class AccountView extends View {

	private String content;
	
	public AccountView(DAOInterface dao) {
		super(dao);
		//Setup view and add menu options
		//		this.addMenuOption("");
	}
	
	@Override
	public void show() {
		//Print formatted content
		System.out.print(content);
		this.printMenu();
	}

}
