package com.codeo.SessionHandlingUsingCookie;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/submitSecondServlet")
public class SessionHandlingThirdServlet extends HttpServlet {
	String name=null;
	String email=null;
	String mobile=null;
	String education=null;
	PrintWriter pw=null;
	String subject1=null; String subject2=null;String subject3=null;
	String dob=null; String age=null;
	
	public void doPost(HttpServletRequest request,  HttpServletResponse response) {
		String dob=request.getParameter("date");
		String age=request.getParameter("age");
		Cookie ckf[]=request.getCookies();
		if(ckf!=null) {
			 name=ckf[1].getValue();
			 email=ckf[2].getValue();
			 mobile=ckf[3].getValue();
		   education=ckf[4].getValue();
			subject1=ckf[5].getValue();
			 subject2=ckf[6].getValue();
		   subject3=ckf[7].getValue();
			 }
		SessionHandlingUsingDao sdao=new SessionHandlingUsingDao();
		sdao.submitData(subject1,subject2,subject3,name,email,mobile,education,age,dob);
	}
}
