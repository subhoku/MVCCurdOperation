package com.codeo.sms.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.codeo.sms.dbUtil.ConnectionUtil;
import com.codeo.sms.entity.SuperAdmin;
//Persistent logic
public class SuperAdminDao {
	ConnectionUtil connUtil=null;
	SuperAdmin superadmin=null;
	
   private final String insert_query="insert into superadmin_registration(name, email, password) values(?,?,?)";
   
   //entity object reference
	public boolean insertSuperAdmin(SuperAdmin superadmin){
		this.superadmin=superadmin;
		boolean result1=false;
		try {
		Connection connection=null;
		connUtil=new ConnectionUtil();
			connection=connUtil.getConnection();
		PreparedStatement psmt=null;
		if(connection!=null) {
		psmt=connection.prepareStatement(insert_query);
		}
		if(psmt!=null) {
			psmt.setString(1, superadmin.getName());
			psmt.setString(2, superadmin.getEmail());
			psmt.setString(3, superadmin.getPassword());
		}
		int result=0;
		if(psmt!=null) {
			result=psmt.executeUpdate();
			result1=true;
		}
		
		if(result!=0) {
			System.out.println("Data Inserted successfully");
			//pw.println("<body><h1 style='color:green';>Data Inserted Successfully</h1></body>");
		}
		else {
			System.out.println("Issue in data insertion");
			//pw.println("<body><h1 style='color:red';>Issue in data insertion</h1></body>");
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result1;
	}

	public boolean loginServlet(String username, String password) {
		boolean login=false;
		if(username.equals(superadmin.getEmail()) && password.equals(superadmin.getPassword())){
			System.out.println("user Login succesfully"+username);
			login=true;
		}
		else {
			System.out.println("Issue in login");
		}
		return login;
	}
	
}
