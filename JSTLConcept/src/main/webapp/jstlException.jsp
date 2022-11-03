<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    

 <!-- create  variable having scope -->
  <c:set var="msg"  value="welcome"  scope="session"/>
  
  <c:if test="${!empty  param.uname }">
        ${msg}   ${param.uname } <br>
        <c:out value="${msg }"/> 
         <c:out value="${param.uname }"/>
  </c:if>