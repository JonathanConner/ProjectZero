/**
 * 
 */
package com.projectzero.display.view;

import java.util.ArrayList;

import com.projectzero.Main;
import com.projectzero.exception.InvalidCommandException;
import com.projectzero.services.UserService;


/**
 * @author Jon 
 *
 */
public class AccountView extends View {

	
	public AccountView(UserService us) {
		
		try {
			this.handleUserInput();
		} catch(InvalidCommandException ice) {
			
		};	
		
	}

		
	private void handleUserInput() throws InvalidCommandException {
		
		while(Main.sc.hasNext()) {
			String input = Main.sc.nextLine();
			
			switch(input) {
				
			}
			
		}
		
	}
	
	
	
	
	
	
	

}
