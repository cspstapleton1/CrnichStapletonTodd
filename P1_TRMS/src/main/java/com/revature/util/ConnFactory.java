package com.revature.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	private static ConnFactory cf = new ConnFactory();
	
	private ConnFactory() {
		
	}//End of private constructor
	
	public static synchronized ConnFactory getInstance() {
		if(cf==null) {
			cf = new ConnFactory();
		}
		return cf;
	}//End of method getInstance
	
	public Connection getConnection() {
		// Declarations for connection variables
				Connection conn = null;
				Properties prop = new Properties();
				File connFile = new File("src/main/resources/database.properties");

				// Try to connect to the server. If fail, check for what broke
				try {
					prop.load(new FileReader(connFile));
					// Using Properties file
					conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
							prop.getProperty("password"));
				} catch (SQLException e) {
					System.out.println("Failed to create connection");
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}//End of try/catch
				
				return conn;
	}//End of method getConnection
}//End of Class ConnFactory
