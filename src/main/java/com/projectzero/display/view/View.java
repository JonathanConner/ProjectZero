package com.projectzero.display.view;

import com.projectzero.dao.DAOInterface;

public abstract class View {

	
	private DAOInterface dao;
	
	public abstract void show();
	
}
