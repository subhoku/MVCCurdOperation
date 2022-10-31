
<%@page import="java.sql.*,java.util.*"%>
<%@page import="com.codeo.sms.dbUtil.ConnectionUtil"%>
<%
String id=request.getParameter("id");

try{
	Connection conn = ConnectionUtil.getConnection();
	Statement st=null;
	st=conn.createStatement();
String query="delete from employee_details where emp_id="+id;
int i=0;
i=st.executeUpdate(query);
if(i!=0){
	System.out.println("Record Deleted Successfully");
}
else{
	System.out.println("Issue in Record Deletion");
}
st.close();
conn.close();
}
catch(Exception e1 ){
	e1.printStackTrace();
}
finally{
	response.sendRedirect("RetrieveData.jsp");
}

%>