package com.codeo.sms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeo.sms.dao.SuperAdminDao;
import com.codeo.sms.entity.SuperAdmin;

@WebServlet("/adminFormSubmit")
public class SuperAdminController extends HttpServlet{
	SuperAdminDao saDao=null;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		String name=request.getParameter("name");
		String emailid=request.getParameter("emailid");
		String password=request.getParameter("password");
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   SuperAdmin superAdmin=new SuperAdmin(name,emailid,password);
	   saDao=new SuperAdminDao();
	   boolean result=false;
	   result= saDao.insertSuperAdmin(superAdmin);
	   if(result==true) {
		   pw.println("<body><h1 style='color:green';>Data Inserted Successfully</h1></body>");
	   }
	   else {
		   pw.println("<body><h1 style='color:red';>Issue in data insertion</h1></body>");
	   }
		
	}

}
