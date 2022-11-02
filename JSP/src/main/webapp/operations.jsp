<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page errorPage="ErrorPage.jsp" %>
    <%!
    String firstnumber=null; 
    String secondnumber=null;
    %>
    <%
    firstnumber=request.getParameter("firstnumber");
    secondnumber=request.getParameter("secondnumber");
    
    int a=Integer.parseInt(firstnumber);
    int b=Integer.parseInt(secondnumber);
    int c=a/b;
    
    out.println("The Value of C: "+c);
    %>