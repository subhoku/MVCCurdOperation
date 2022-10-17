
<%@page import="java.sql.*,java.util.*"%>

<%
String id=request.getParameter("id");

try{
//Register the driver
Class.forName("com.mysql.cj.jdbc.Driver");
//Establish the connection
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
Statement st=con.createStatement();
String query="delete from employee_details where emp_id="+id;
int i=st.executeUpdate(query);

st.close();
con.close();
}
catch(Exception e1 ){
	e1.printStackTrace();
}
finally{
	response.sendRedirect("RetrieveData.jsp");
}

%>