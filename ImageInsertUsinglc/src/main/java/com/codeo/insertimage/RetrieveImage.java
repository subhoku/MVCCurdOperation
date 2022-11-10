package com.codeo.insertimage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/retrieveImage")
public class RetrieveImage extends HttpServlet {
	PrintWriter pw=null;
	int imageid=0;
	String imageFileName=null;
	private final  String select_query="select * from image1";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		int id=0;
		try {
			
			pw=response.getWriter();
			imageid=Integer.parseInt(request.getParameter("imageId"));
			//Database Operation
			//Register JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish the connection
			Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/image_tutorials","root","");
			Statement st=null;
			st=con.createStatement();
			ResultSet rs=null;
			rs=st.executeQuery(select_query);
			
			while(rs.next()) {
				
				if(rs.getInt(1)==imageid) {
					
					id=rs.getInt(1);
					imageFileName=rs.getString(2);
				}
				
				
				
			}
			
		} 
		
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
		RequestDispatcher rd=null;
		request.setAttribute("id", String.valueOf(id));
		request.setAttribute("imgFile",imageFileName );
		rd=request.getRequestDispatcher("RetrieveImage.jsp");
		
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
