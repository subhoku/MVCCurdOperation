<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table Data </title>
</head>
<body>
<%
String id = request.getParameter("emp_id");
String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "employee_details";
String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement st = null;
ResultSet resultSet = null;
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
<th>Delete</th>
	</tr>
<%
String query="select * from employee_details";
			
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			
			st=connection.createStatement();
resultSet=st.executeQuery(query);

 
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