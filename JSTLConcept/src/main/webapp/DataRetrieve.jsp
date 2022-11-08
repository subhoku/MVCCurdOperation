<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"   prefix="sql"%>

 <!-- establish the connection-->
  <sql:setDataSource  driver="com.mysql.jdbc.Driver"
                                        url="jdbc:mysql://localhost:3306/test_db"
                                        user="root"
                                        password=""
                                   var="ds"/>
 <!-- Execute the Query -->
 <sql:query var="rs" dataSource="${ds}"  sql="SELECT * FROM employee_details"/>    
 
 <!-- Process the ResultSet object -->                        
 <c:forEach  var="row"  items="${rs.rows}">
      ${row.emp_name } &nbsp; &nbsp; &nbsp; ${row.emp_lastname}  <br>
 </c:forEach>            

    

    
