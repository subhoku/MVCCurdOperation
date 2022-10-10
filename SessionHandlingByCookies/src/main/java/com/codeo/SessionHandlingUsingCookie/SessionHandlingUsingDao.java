package com.codeo.SessionHandlingUsingCookie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class SessionHandlingUsingDao {
//Persistent Logic
	public static DataSource ds=null;
	public void submitData(String subject1, String subject2, String subject3, String name, String email, String mobile,
		String education,String age,String dob) {
		System.out.println(subject1+" "+subject2+" "+subject3+" "+education+" "+age+" "+dob);
		 String configure_file_path="./src/main/resources/db.properties";
		 HikariConfig hcfg=new HikariConfig(configure_file_path);
		    HikariDataSource hdata=new HikariDataSource(hcfg);
		    Connection con=null;
		    PreparedStatement psmt=null;
		    String query="insert into student_details( name, email, mobileno, education, subject1, subject2, subject3, dateOfBirth, age) values(?,?,?,?,?,?,?,?,?,?)";
			try {
		    con=hdata.getConnection();
	    	psmt=con.prepareStatement(query);
	    	
	    	int result=0;
	    	if(psmt!=null) {
	    		psmt.setString(1, name);
	    		psmt.setString(2, email);
	    		psmt.setString(3, mobile);
	    		psmt.setString(4, education);
	    		psmt.setString(5, subject1);
	    		psmt.setString(6, subject2);
	    		psmt.setString(7, subject3);
	    		psmt.setString(8, dob);
	    		psmt.setString(9, String.valueOf(age));
	    		
	    	}
	    	if(psmt!=null) {
	    		result=psmt.executeUpdate();
	    	}
	    	if(result!=0) {
	    		System.out.println("Data inserted successfully");
	    	}
	    	else {
	    		System.out.println("Issue in data Insertion");
	    	}
			}
			catch(SQLException e) {
		    	e.printStackTrace();
		    }
		    catch(Exception e) {
		    	e.printStackTrace();
		    }
		hdata.close();
	}

}
