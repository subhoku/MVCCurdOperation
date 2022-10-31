<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.sql.*" %>
    <%@page import="com.codeo.sms.dbUtil.ConnectionUtil"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<%!

String emp_name=null; 
String emp_lastname=null;
String emp_cityname=null; 
String emp_emailid=null;
String emp_mobileno=null; 
int emp_age=0;

%>
<%
emp_name=request.getParameter("name");
emp_lastname=request.getParameter("lastname");
emp_cityname=request.getParameter("cityname");
emp_emailid=request.getParameter("emailid");
emp_mobileno=request.getParameter("mobileno");
emp_age=Integer.parseInt(request.getParameter("age"));

try{
	Connection connection = ConnectionUtil.getConnection();
		PreparedStatement psmt=null;
		String insert_query="insert into employee_details(emp_name, emp_lastname, emp_cityname, emp_emailid, emp_mobileno, emp_age) values (?,?,?,?,?,?)";
		if(connection!=null) {
		psmt=connection.prepareStatement(insert_query);
		}
		if(psmt!=null) {
			psmt.setString(1, emp_name);
			psmt.setString(2, emp_lastname);
			psmt.setString(3, emp_cityname);
			psmt.setString(4, emp_emailid);
			psmt.setString(5, emp_mobileno);
			psmt.setInt(6, emp_age);
			
		}
		int result=0;
		if(psmt!=null) {
			result=psmt.executeUpdate();
		
		}
		
		if(result!=0) {
			System.out.println("Data Inserted successfully");
			//pw.println("<body><h1 style='color:green';>Data Inserted Successfully</h1></body>");
		}
		else {
			System.out.println("Issue in data insertion");
			//pw.println("<body><h1 style='color:red';>Issue in data insertion</h1></body>");
		}
	
	
	
	
}
catch(SQLException e){
	e.printStackTrace();
}
finally{
	response.sendRedirect("RetrieveData.jsp");
}
%>
</body>
</html>