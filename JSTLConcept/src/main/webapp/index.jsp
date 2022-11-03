<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
    <!-- Create  Attribute having request scope -->
    <c:set var="msg" value="welcome" scope="request"/>
    <!-- Display attribute value -->
    value :: <c:out  value="${msg}" />  <br>
    value ::  ${requestScope.msg }  <br>
    value ::  ${msg}  <br>
<!--  remove Attribute from request scope -->
    <c:remove var="msg"  scope="request"/> <br>
    value :: <c:out  value="${msg}" />  <br>
    
    