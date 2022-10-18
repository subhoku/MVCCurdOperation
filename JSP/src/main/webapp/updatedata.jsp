<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<%!

String emp_id=null;
String emp_name=null; 
String emp_lastname=null;
String emp_cityname=null; 
String emp_emailid=null;
String emp_mobileno=null; 
int emp_age=0;

%>
<%
emp_id=request.getParameter("empid");
emp_name=request.getParameter("name");
emp_lastname=request.getParameter("lastname");
emp_cityname=request.getParameter("cityname");
emp_emailid=request.getParameter("emailid");
emp_mobileno=request.getParameter("mobileno");
emp_age=Integer.parseInt(request.getParameter("age"));

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	//establish the connection
	
	Connection connection=null;
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		PreparedStatement psmt=null;
		String update_query="update employee_details set  emp_name=?, emp_lastname=? , emp_cityname=?, emp_emailid=?, emp_mobileno=?, emp_age=? where emp_id="+emp_id;
		if(connection!=null) {
		psmt=connection.prepareStatement(update_query);
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
			out.println("Data Inserted Sucessfully");
		}
		else {
			System.out.println("Issue in data insertion");
			out.println("Issue in data insertion");
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