package com.projectzero.display;

public class MenuOption  {

	private String command;
	private String name;
	
	public MenuOption(String name, String comm) {
		this.command = comm;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return  name;
	}
	
	
	
}
