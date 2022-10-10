package com.codeo.sms.controller;

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
		
	   SuperAdmin superAdmin=new SuperAdmin(name,emailid,password);
	   saDao=new SuperAdminDao();
	   try {
		saDao.insertSuperAdmin(superAdmin);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
