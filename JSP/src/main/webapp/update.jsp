<%@page import="java.sql.*,java.util.*"%>
<%@page import="com.codeo.sms.dbUtil.ConnectionUtil"%>
<%
String id=request.getParameter("id");

try{
	Connection conn = ConnectionUtil.getConnection();
Statement st=conn.createStatement();
String select_query="select * from employee_details where emp_id="+id;
ResultSet resultSet=null;
resultSet=st.executeQuery(select_query);

while(resultSet.next()){
	%>	

<!-- emp_id, emp_name, emp_lastname, emp_cityname, emp_emailid, emp_mobileno, emp_age, entry_time -->
<body>
<h1>Update Form Details</h1>
<form method="post" action="updatedata.jsp">
<input type="hidden" name="empid" placeholder="Enter your name" value="<%=resultSet.getString("emp_id")%>"/><br><br>
<input type="text" name="name" placeholder="Enter your name" value="<%=resultSet.getString("emp_name")%>"/><br><br>
<input type="text" name="lastname" placeholder="Enter your lastname" value="<%=resultSet.getString("emp_lastname")%>"/><br><br>
<input type="email" name="emailid"  placeholder="Enter your emailId" value="<%=resultSet.getString("emp_emailid")%>"/><br><br>
<input type="text" name="mobileno"  placeholder="Enter your mobileno" value="<%=resultSet.getString("emp_mobileno")%>"/><br><br>
<input type="text" name="cityname" placeholder="Enter your cityname" value="<%=resultSet.getString("emp_cityname")%>"/><br><br>
<input type="text" name="age" placeholder="Enter your age" value="<%=resultSet.getString("emp_age")%>"/><br><br>
<input type="submit" value="Update"/>


</form>


<%
}
}
catch(Exception e1 ){
	e1.printStackTrace();
}
%>
</body>