<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import = "java.sql.*" %>
       <%@page import="com.codeo.sms.dbUtil.ConnectionUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table Data </title>
</head>
<body>
 <%@include file="form.jsp" %>
<%
String id = request.getParameter("emp_id");

%>
<table border="13px" solid; cellspacing="10px"; cellpadding="30px";  >
	<!-- <tr> tag is used for rows -->
	<tr>
		<th>sr<br>no</th>
<th>Name</th>
<th>LastName</th>
<th>CityName</th>
<th>EmailId</th>
<th>Mobile no</th>
<th>Age</th>
<th>Update</th>
<th>Delete</th>
	</tr>
<%
String query="select * from employee_details";
			
			Connection conn = ConnectionUtil.getConnection();

			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();


 
try{
while(resultSet.next()){
	%>
	<tr>
<td><%=resultSet.getInt("emp_id") %></td>	
<td><%=resultSet.getString("emp_name") %></td>
<td><%=resultSet.getString("emp_lastname") %></td>
<td><%=resultSet.getString("emp_cityname") %></td>
<td><%=resultSet.getString("emp_emailid") %></td>
<td><%=resultSet.getString("emp_mobileno") %></td>
<td><%=resultSet.getInt("emp_age") %></td>
<td><a href="update.jsp?id=<%=resultSet.getString("emp_id") %>"><button style="background-color:orange; border-radius:40px;">Update</button></a></td>
<td><a href="delete.jsp?id=<%=resultSet.getString("emp_id") %>"><button style="background-color:orange; border-radius:40px;">Delete</button></a></td>

</tr>

<% 
}
}
catch(Exception e){
e.printStackTrace();
}

%>
</table>
</body>
</html>