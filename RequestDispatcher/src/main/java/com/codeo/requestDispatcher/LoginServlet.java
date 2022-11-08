package com.codeo.requestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String username=null;
       String password=null;
       RequestDispatcher rd=null;
       PrintWriter pw=null;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		pw=response.getWriter();
		username=request.getParameter("username");
		password=request.getParameter("password");
		
		if(username.equals("admin") && password.equals("admin")) {
			rd=request.getRequestDispatcher("nextServlet");
			rd.forward(request, response);
		}
		else {
			rd=request.getRequestDispatcher("/ErrorPage.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
