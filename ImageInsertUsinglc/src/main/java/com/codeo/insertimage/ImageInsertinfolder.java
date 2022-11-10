package com.codeo.insertimage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadServlet")
@MultipartConfig
public class ImageInsertinfolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	 
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println("post method working properly");
       PrintWriter pw=null;
       pw=response.getWriter();
       String bannertagline=request.getParameter("firstName");
       String buttonstyle=request.getParameter("lastName");
       String status=request.getParameter("status");
       Part file=request.getPart("photo");
       String imageFileName=file.getSubmittedFileName();
       System.out.println(imageFileName);
       
      
       String uploadPath="G:/Java Work/ImageInsertUsinglc/src/main/webapp/Images/"+imageFileName;
       System.out.println("Upload Path: "+uploadPath);
       
       //upload our selected image in Images folder
       try {
       FileOutputStream fos=new FileOutputStream(uploadPath);
       InputStream is=file.getInputStream();
       
       byte[] data=new byte[is.available()];
       is.read(data);
       fos.write(data);
       fos.close();
       
       }
       catch(Exception e) {
    	   e.printStackTrace();
       }
       //Next Target to store image name and other parameters in D/B
       //Register Jdbc Driver
       try {
		Class.forName("com.mysql.jdbc.Driver");
		//Establish the connection
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/image_tutorials","root","");
		PreparedStatement ps=null;
		String query="insert into image1( imageFileName, imageTagLine, imageButton, status) values(?,?,?,?)";
		ps=con.prepareStatement(query);
		if(ps!=null) {
		ps.setString(1,imageFileName );
		System.out.println(imageFileName);
		
		ps.setString(2, bannertagline);
		ps.setString(3, buttonstyle);
		ps.setString(4, status);
		}
		int row=0;
		row=ps.executeUpdate();
		if(row==0) {
			System.out.println("Issue in Data Insertion");
		}
		else {
			System.out.println("Data Inserted Properly");
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       catch(SQLException e) {
    	   e.printStackTrace();
       }
       finally {
    	   response.sendRedirect("RetrieveImage.jsp");
       }
       
     
	}

}
