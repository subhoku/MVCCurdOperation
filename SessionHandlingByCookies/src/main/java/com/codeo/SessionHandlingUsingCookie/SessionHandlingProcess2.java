package com.codeo.SessionHandlingUsingCookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/submitFirstServlet")
public class SessionHandlingProcess2 extends HttpServlet {
	String name=null;
	String email=null;
	String mobile=null;
	String education=null;
	PrintWriter pw=null;
	String subject1=null; String subject2=null;String subject3=null;
	
	public void doPost(HttpServletRequest request,  HttpServletResponse response) {
		//set content type
		
		try {
			pw=response.getWriter();
		 subject1=request.getParameter("subject1");
		 subject2=request.getParameter("subject2");
	     subject3=request.getParameter("subject3");
			System.out.println(subject1+" "+subject2+" "+subject3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//read/retrieve form 1 data from cookies
		//
		Cookie cks[]=request.getCookies();
		if(cks!=null) {
			 name=cks[1].getValue();
			 email=cks[2].getValue();
			 mobile=cks[3].getValue();
		   education=cks[4].getValue();
			 }
		
		Cookie ckf1=new Cookie("name2", name);
		Cookie ckf2=new Cookie("email2", email);
		Cookie ckf3=new Cookie("mobileno2", mobile);
		Cookie ckf4=new Cookie("education2", education);
		Cookie ckf5=new Cookie("subject21", subject1);
		Cookie ckf6=new Cookie("subject22", subject2);
		Cookie ckf7=new Cookie("subject23", subject3);
		//add cookie to response
				response.addCookie(ckf1);
				response.addCookie(ckf2);
				response.addCookie(ckf3);
				response.addCookie(ckf4);
				response.addCookie(ckf5);
				response.addCookie(ckf6);
				response.addCookie(ckf7);
				pw.println("<h1>Last Page of Registration form</h1><br><br>");
				pw.println("<body><form method='post' action='submitSecondServlet'>");
			
				pw.println("<label>Date of Birth</label>" + 
						"<input type='date' name='date'/><br>");
				pw.println("<label>Age</label>" + 
						"<input type='number' name='age'/>");
				
				pw.println("<input type='submit' value='submit'/> </form></body>");
	}
}
