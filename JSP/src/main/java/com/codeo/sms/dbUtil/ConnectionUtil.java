package com.codeo.sms.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static final String DriverclassName="com.mysql.cj.jdbc.Driver";
	private static final String jdbcUrl="jdbc:mysql://localhost:3306/test";
	private static final String userName="root";
	private static final String password="";
	
	public static Connection getConnection() {
		
		Connection conn=null;
		try {
			//register jdbc Driver
			Class.forName(DriverclassName);
			//establish the connection between db and software
			conn=DriverManager.getConnection(jdbcUrl,userName,password);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
}
