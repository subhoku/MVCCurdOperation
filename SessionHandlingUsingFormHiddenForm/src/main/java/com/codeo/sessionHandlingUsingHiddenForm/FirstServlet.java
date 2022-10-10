package com.codeo.sessionHandlingUsingHiddenForm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/submitValue1")
public class FirstServlet extends HttpServlet {
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
		System.out.println(name);
		System.out.println(email);
		
		if(education.equals("12th")) {
			pw.println("<body><h1>Registration form for 12th Standard( Part II)");
			pw.println("<form method='post' action='submitFirstServlet'>");
			pw.println("<h1> 12Th Class Session</h1>");
			pw.println("<label>Physics</label>" + 
					"<input type='text' name='subject1'/>");
			pw.println("<label>Chemistry</label>" + 
					"<input type='text' name='subject2'/>");
			pw.println("<label>Maths</label>" + 
					"<input type='text' name='subject3'/>");
			pw.println(
					"<input type='hidden' name='fname' value='"+name+"'/>");
			pw.println(
					"<input type='hidden' name='femail' value='"+email+"'/>");
			pw.println(
					"<input type='hidden' name='fmobileno' value='"+mobile+"'/>");
			pw.println(
					"<input type='hidden' name='feducation' value='"+education+"'/><input type='submit' value='submit'/></form></body>");
			
		}
		else if(education.equals("Polytechnic")) {
			pw.println("<body><h1>Registration form for PolyTechnic( Part II)");
			pw.println("<form method='post' action='submitFirstServlet'>");
			pw.println("<h1> Poly Class Session</h1>");
			pw.println("<label>C++</label>" + 
					"<input type='text' name='subject1'/>");
			pw.println("<label>Java</label>" + 
					"<input type='text' name='subject2'/>");
			pw.println( "<label>C Sharp</label>" + 
					"<input type='text' name='subject3'/>");
			pw.println(
					"<input type='hidden' name='fname' value='"+name+"'/>");
			pw.println( 
					"<input type='hidden' name='femail' value='"+email+"'/>");
			pw.println(
					"<input type='hidden' name='fmobileno' value='"+mobile+"'/>");
			pw.println( 
					"<input type='hidden' name='feducation' value='"+education+"'/><input type='submit' value='submit'/></form></body>");	
		}
		else {
			pw.println("Please Insert Proper input either Poly/12th");
		}
		
	}
	

}
