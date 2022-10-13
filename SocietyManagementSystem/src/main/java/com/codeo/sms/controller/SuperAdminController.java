package com.codeo.sms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeo.sms.dao.SuperAdminDao;
import com.codeo.sms.entity.SuperAdmin;
import com.codeo.sms.helper.EmailFunctionalityForSuperAdmin;

@WebServlet("/adminFormSubmit")
public class SuperAdminController extends HttpServlet{
	SuperAdminDao saDao=null;

	private static final long serialVersionUID = 1L;
	private String host=null;
    private String port=null;
    private String user=null;
    private String pass=null;
    
    EmailFunctionalityForSuperAdmin efsuperadmin=null;
    
  
	
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
      
      
    }
    
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		String name=request.getParameter("name");
		String emailid=request.getParameter("emailid");
		String password=request.getParameter("password");
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Email Functionality:
		String message="Hey "+name+" you have registered successfully";
		String subject="Mailing you for successful registration Mr/Mrs. "+name;
		efsuperadmin=new EmailFunctionalityForSuperAdmin();
		try {
			efsuperadmin.sendEmail(host,port,user,password,emailid,message,subject);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Persistent Logic
	   SuperAdmin superAdmin=new SuperAdmin(name,emailid,password);
	   saDao=new SuperAdminDao();
	   boolean result=false;
	   result= saDao.insertSuperAdmin(superAdmin);
	   if(result==true) {
		   pw.println("<body><h1 style='color:green';>Data Inserted Successfully</h1></body>");
	   }
	   else {
		   pw.println("<body><h1 style='color:red';>Issue in data insertion</h1></body>");
	   }
		
	}

}
