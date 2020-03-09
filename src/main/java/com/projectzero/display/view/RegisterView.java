package com.projectzero.display.view;

import com.projectzero.Main;
import com.projectzero.model.User;
import com.projectzero.services.UserService;

public class RegisterView {
	
	
	public RegisterView(UserService us) {
		
		
		User user = new User();//Create a user object
		
		user.setType("user");
		/*
			Ask for required information to create account and check the input lengths
		*/
		System.out.println("Enter your Email Address:");
		String email  = Main.sc.nextLine();
		if(!(email.length() <= 40)){
			System.out.println("Email address Invalid.\n Must be less than 40 characters!");
		}else{
			user.setEmail(email);
		}
		
		System.out.println("Enter your Username:");
		String username  = Main.sc.nextLine();
		if(!(username.length() <= 20)){
			System.out.println("Username must be less than 20 characters!");
		}else{
			user.setUsername(username);
		}
		
		System.out.println("Enter your Password:");
		String pw  = Main.sc.nextLine();	
		if(!(pw.length() >= 6) && !(pw.length()<=30)){
			System.out.println("Password must be between 6 and 30 characters in length!");
		} else {
			user.setPassword(pw);
		}
		
		System.out.println("Enter your First Name:");
		String fname  = Main.sc.nextLine();
		if(!(fname.length()<=30)){
			System.out.println("First Name must not be over 30 characters!");
		} else {
			user.setFirstName(fname);
		}
		
		System.out.println("Enter your Last Name:");
		String lname  = Main.sc.nextLine();
		
		if(!(lname.length()<=30)){
			System.out.println("Last Name must not be over 30 characters!");
		} else {
			user.setFirstName(lname);
		}
		
		System.out.println("Enter your Date Of Birth (mm-dd-yyyy):");
		String dob  = Main.sc.nextLine();
		
		if(!(dob.length()<=10)){
			System.out.println("DOB too long!");
		} else {
			user.setDob(dob);
		}
		
		System.out.println("Enter your Address:");
		String address  = Main.sc.nextLine();

		if(!(address.length()<=100)){
			System.out.println("Address too long!");
		} else {
			user.setAddress(address);
		}
		
		System.out.println("Enter your SSN:");
		String ssn  = Main.sc.nextLine();
		
		if(!(ssn.length()<=13)){
			System.out.println("SSN too long!");
		} else {
			user.setSsn(ssn);
		}
		
		System.out.println("Enter your Phone Number:");
		String phone  = Main.sc.nextLine();


		if(!(phone.length()<=15)){
			System.out.println("Phone too long!");
		} else {
			user.setPhone(phone);
		}
		
		
		//UserService call to register aka insert user in DB
		if(us.registerUser(user))
			System.out.println("User Successfully Registered");
	
		
		return;
		
	}
}
