package com.codeo.servlet;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//MVC Pattern(Model, View, Controller)
public class TableRetreiveDao {
	PrintWriter pw=null;
	
 String table_name=null;
	public TableRetreiveDao(String table_name, PrintWriter pw) {
		this.table_name=table_name;
		this.pw=pw;
	}
	
	public void retrieveData() {
	 
		try {
			System.out.println(table_name);
			//register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish the connection
			Connection con=null;
			ResultSet rs=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","");
		    Statement st=null;
		    String query="Select * from "+table_name+"";
		    System.out.println(query);
		    if(con!=null) {
		    	st=con.createStatement();
		    }
		    if(st!=null) {
		    	
		    	rs=st.executeQuery(query);
		    }
		    if(rs!=null) {
		    	while(rs.next()) {
		    		pw.println("<h2 style='color:red'>"+rs.getInt(1)+"</h2>");
		    		pw.println("<h1>"+rs.getString(2)+"</h1>");
		    		pw.println("<h1>"+rs.getString(3)+"</h1>");
		    		pw.println("<h1>"+rs.getString(4)+"</h1>");
		    	}
		    }
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			
		}
	}

}
