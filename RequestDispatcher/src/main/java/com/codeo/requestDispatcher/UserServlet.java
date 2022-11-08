package com.codeo.requestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nextServlet")
public class UserServlet extends HttpServlet {

	
	  String username=null;
      String password=null;
	 PrintWriter pw=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pw=response.getWriter();
		username=request.getParameter("username");
		pw.println("Welcome Mr/Miss "+username );
	}

}
