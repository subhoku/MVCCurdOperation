package com.codeo.sessionHandlingUsingHiddenForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSubmission {
	
	private static BasicDataSource getDataSource() {
		 
	       
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test_db");
        ds.setUsername("root");
        ds.setPassword("");

        //5 connection mimimum 
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);

        
   
    return ds;
}
	public void dataSubmission(String name, String email, String mobile, String education, String subject1,
			String subject2, String subject3) throws SQLException {
		  DataSubmission dbcp=new DataSubmission();
	    	BasicDataSource dataSource  = dbcp.getDataSource(); 
	                Connection connection = dataSource.getConnection();
	                PreparedStatement psmt =null;
	                //create a query
	                String query="insert into student_session( name, email, mobileno, education, subject1, subject2, subject3) values(?,?,?,?,?,?,?)";
		            if(connection!=null) {
		            	psmt=connection.prepareStatement(query);
		            }
		            int result=0;
		            if(psmt!=null) {
		            	result=psmt.executeUpdate();
		            }
		            if(psmt!=null) {
		            	psmt.setString(1, name);
		            	psmt.setString(2, email);
		            	psmt.setString(3, mobile);
		            	psmt.setString(4, education);
		            	psmt.setString(5, subject1);
		            	psmt.setString(6, subject2);
		            	psmt.setString(7, subject3);
		            }
		            if(result!=0) {
		            	System.out.println("Data submitted sucessfully");
		            }
		            else {
		            	System.out.println("Issue in Data Insertion");
		            }
		
	}

}
