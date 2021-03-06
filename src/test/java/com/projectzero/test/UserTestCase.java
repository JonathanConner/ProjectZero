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

import com.projectzero.model.User;
import com.projectzero.services.UserService;
import com.projectzero.util.ConnectionUtil;

/**
 * @author Jon
 *
 */
public class UserTestCase {

	private UserService us;
	
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

		ConnectionUtil.getConnection();
		us = new UserService();
		User user = new User();
		user.setEmail("test@testuser.com");
		user.setSsn("222-22-2222");
		user.setFirstName("Testy");
		user.setLastName("Testerton");
		user.setUsername("thisisatest");
		user.setPassword("testing");
		user.setDob("11-11-1990");
		user.setAddress("8110 Safari Dr Smyrna, TN");
		user.setPhone("6153333333");
		user.setType("test");
		assertTrue(us.registerUser(user));
		
		
	}

}
