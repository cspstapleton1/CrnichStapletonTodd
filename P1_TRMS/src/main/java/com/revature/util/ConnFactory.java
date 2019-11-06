package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnFactory {
	private static ConnFactory cf = new ConnFactory();
	
	private ConnFactory() {
		
	}
	
	public static synchronized ConnFactory getInstance() {
		if(cf==null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:postgresql://todd-pega1019.cwn0gwrwwhuo.us-east-2.rds.amazonaws.com/postgres";
		String user="jtodd3";
		String pw="William3545!";
		
		try {
			conn=DriverManager.getConnection(url,user,pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
