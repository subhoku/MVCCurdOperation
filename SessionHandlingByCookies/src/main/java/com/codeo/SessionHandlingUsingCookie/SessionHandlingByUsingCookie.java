package com.codeo.SessionHandlingUsingCookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/submitValue")
public class SessionHandlingByUsingCookie extends HttpServlet {
	String name=null;
	String email=null;
	String mobile=null;
	String education=null;
	PrintWriter pw=null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		name=request.getParameter("name");
		email=request.getParameter("email");
		mobile=request.getParameter("mobileno");
		education=request.getParameter("education");
		pw=response.getWriter();
		//create a cookie (persistence)
		Cookie ck1=new Cookie("name1", name);
		Cookie ck2=new Cookie("email1", email);
		Cookie ck3=new Cookie("mobileno1", mobile);
		Cookie ck4=new Cookie("education1", education);
		//add cookie to response
		response.addCookie(ck1);
		response.addCookie(ck2);
		response.addCookie(ck3);
		response.addCookie(ck4);
		//generate another form dynamically

		if(education.equals("12th")) {
			pw.println("<body><form method='post' action='submitFirstServlet'>");
			pw.println("<h1> 12Th Class Session</h1>");
			pw.println("<label>Physics</label>" + 
					"<input type='text' name='subject1'/>");
			pw.println("<label>Chemistry</label>" + 
					"<input type='text' name='subject2'/>");
			pw.println("<label>Maths</label>" + 
					"<input type='text' name='subject3'/>");
			pw.println("<input type='submit' value='submit'/> </form></body>");
			
		}
		else if(education.equals("Polytechnic")) {
			pw.println("<body><form method='post' action='submitFirstServlet'>");
			pw.println("<h1> Poly Class Session</h1>");
			pw.println("<label>C Language</label>" + 
					"<input type='text' name='subject1'/>");
			pw.println("<label>C++ Language</label>" + 
					"<input type='text' name='subject2'/>");
			pw.println( "<label>Java</label>" + 
					"<input type='text' name='subject3'/>");
			pw.println("<input type='submit' value='submit'/> </form></body>");
			
		}
		else {
			pw.println("Please Insert Proper input either Poly/12th");
		}
		pw.close();
	}
}
