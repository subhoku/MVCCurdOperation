package com.codeo.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.codeo.sms.dbUtil.ConnectionUtil;
import com.codeo.sms.entity.SuperAdmin;
//Persistent logic
public class SuperAdminDao {
   private final String insert_query="insert into superadmin_registration(name, email, password) values(?,?,?)";
	
	public void insertSuperAdmin(SuperAdmin superadmin) throws SQLException {
		Connection connection=ConnectionUtil.getConnection();
		PreparedStatement psmt=null;
		psmt=connection.prepareStatement(insert_query);
		if(psmt!=null) {
			psmt.setString(1, superadmin.getName());
			psmt.setString(2, superadmin.getEmail());
			psmt.setString(3, superadmin.getPassword());
		}
		int result=0;
		if(psmt!=null) {
			result=psmt.executeUpdate();
		}
		if(result!=0) {
			System.out.println("Data Inserted successfully");
		}
		else {
			System.out.println("Issue in data insertion");
		}
		
	}
}
