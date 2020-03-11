/**
 * 
 */
package com.projectzero.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.projectzero.dao.AccountDAOImpl;
import com.projectzero.model.Account;
import com.projectzero.model.User;
import com.projectzero.services.AccountService;
import com.projectzero.services.UserService;
import com.projectzero.util.ConnectionUtil;

/**
 * @author Jon
 *
 */
public class UserTestCase {

	private UserService us;
	private AccountService as;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.us = new UserService();
		this.as = new AccountService(new AccountDAOImpl());
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUserRegister() 
	{

		User user = new User();
		user.setEmail("jonn");
		user.setSsn("");
		user.setFirstName("Cartoons");
		user.setLastName("Plural");
		user.setUsername("employee");
		user.setPassword("testing");
		user.setDob("11-11-1990");
		user.setAddress("8110 Safari Dr Smyrna, TN");
		user.setPhone("6153333333");
		user.setType("test");
		
		assertTrue(us.registerUser(user)); //
		
		
	}
	
	@Test
	public void testUserLogin() 
	{
		
		this.us.loginUser("thisisatest", "testing");
		
		//If all checks / queries pass this should ultimately be true
		assertTrue(this.us.getUserInstance() instanceof User);
		
	}
	
	@Test
	public void testUserApplyForAccount() {
		
		this.us.loginUser("thisisatest", "testing");
		
		assertTrue(this.us.applyForNewAccount(this.us.getUserInstance()));
		
	}
	
	
	@Test
	public void testUserApplyForJointAccount() {
		
		this.us.loginUser("thisisatest", "testing");
		
		assertTrue(this.us.applyForNewJointAccount(this.us.getUserInstance(), "jonconner"));
		
	}

}
