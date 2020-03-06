package com.projectzero.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection conn = null;

	/**
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {

		try {
			
			try {
				conn = DriverManager.getConnection(
						"", 
						"admin",
						System.getenv("PW")
				);
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		

	}

}
