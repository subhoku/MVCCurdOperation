<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"  %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>   
<html>  
<head>  
<title>Core Tag Example</title>  
</head>  
<body>  
<c:set var="Income" scope="session" value="${400*4}"/>  
<
<c:out value="${Income}"/>  
</body>  
</html>  