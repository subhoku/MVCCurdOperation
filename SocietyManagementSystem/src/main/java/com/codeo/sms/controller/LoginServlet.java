package com.codeo.sms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeo.sms.dao.SuperAdminDaoImpl;
import com.codeo.sms.entity.SuperAdmin;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
String username=null;
String password=null;
SuperAdminDaoImpl sdao=null;	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		username=request.getParameter("username");
		password=request.getParameter("password");
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(username+" "+password);
		sdao=new SuperAdminDaoImpl();
	    SuperAdmin superadmin=null;
		superadmin=sdao.loginServlet(username,password);
		if(superadmin!=null) {
			pw.println("<body><h1>Welcome: "+superadmin.getName()+"</h1>");
			pw.println("<h1>Mr/Mrs: Your Email Id is: "+superadmin.getEmail()+"</h1></body>");
		}
		else {
			pw.println("<body><h1>Issue in Login please checkout</h1></body>");
		}
		
		
	}

}
