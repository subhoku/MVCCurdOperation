package com.codeo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//by using annotation you have configured the servlet
@WebServlet("/findTable")
public class TableRetrieve extends HttpServlet {
	//Controller logic
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
		PrintWriter pw=null;
		pw=res.getWriter();
		String table_name=req.getParameter("table");
		System.out.println(table_name);
		TableRetreiveDao trd=new TableRetreiveDao(table_name,pw);
		trd.retrieveData();
	
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
