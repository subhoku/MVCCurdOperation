package com.codeo.sms.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeo.sms.dbUtil.ConnectionUtil;
import com.codeo.sms.entity.SuperAdmin;
//Persistent logic
public class SuperAdminDao {
	ConnectionUtil connUtil=null;
	SuperAdmin superadmin=null;
	
   private final String insert_query="insert into superadmin_registration(name, email, password) values(?,?,?)";
   private final String select_login_query="select * from superadmin_registration where email=? and password=?";
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

	public SuperAdmin loginServlet(String username, String password) {
		SuperAdmin superadmin=null;
		
		PreparedStatement psmt=null;
		Connection connection=null;
		connUtil=new ConnectionUtil();
		connection=connUtil.getConnection();
		try {
			psmt=connection.prepareStatement(select_login_query);
			if(psmt!=null) {
				psmt.setString(1, username);
				psmt.setString(2, password);
			}
			/* id, name, email, password, entry_time */
			ResultSet rs=null;
			rs=psmt.executeQuery();
			if(rs.next()) {
				superadmin=new SuperAdmin();
				superadmin.setName(rs.getString(2));
				superadmin.setEmail(rs.getString(3));
				superadmin.setPassword(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return superadmin ;
	}
	
}
