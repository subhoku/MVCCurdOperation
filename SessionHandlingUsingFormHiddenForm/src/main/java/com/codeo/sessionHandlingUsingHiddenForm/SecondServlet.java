package com.codeo.sessionHandlingUsingHiddenForm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/submitFirstServlet")
public class SecondServlet extends HttpServlet {
	
	String name=null;
	String email=null;
	String mobile=null;
	String education=null;
	String subject1=null;
	String subject2=null;
	String subject3=null;
	PrintWriter pw=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		name=request.getParameter("fname");
		email=request.getParameter("femail");
		mobile=request.getParameter("fmobileno");
		education=request.getParameter("feducation");
		subject1=request.getParameter("subject1");
		subject2=request.getParameter("subject2");
		subject3=request.getParameter("subject3");
		pw=response.getWriter();
		pw.println("<h1>"+name+" "+email+" "+mobile+" "+education+" "+subject1+" "+subject2+" "+subject3+"</h1>");
	}

}
