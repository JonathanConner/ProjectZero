package com.projectzero.test;

import static org.junit.Assert.*;

import java.util.List;

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

public class AccountTestCase {


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
	
//	
//	@Test
//	public void testFindAllPendingAccounts() {
//		List<Account> accs = this.as.findAllPendingAccounts();
//		assertTrue(accs.get(0).getStatus().equals("unapproved"));
//	}
	
	@Test
	public void findAllAccounts() {

		assertTrue(this.as.findAll() instanceof List);
	}
	
	@Test
	public void approveAccountStatus() {
		this.us.loginUser("thisisatest", "testing");

		this.as.approveAccountStatus(this.us.getUserInstance().getId());
	}
}
