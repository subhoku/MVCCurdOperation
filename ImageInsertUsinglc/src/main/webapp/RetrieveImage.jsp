<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center;">Retrieve Image</h1>

<form action="retrieveImage" method="post">
<center>
<label>Enter Image ID: </label>
<input type="number" name="imageId">
<input type="submit" value="submit">
</center>
</form>

<hr>
<!-- scriplet tag -->
<% 
String imageFileName=(String)request.getAttribute("imgFile");
String imageId=(String)request.getAttribute("id");
System.out.println(imageFileName);
%>
<div align="center">
<%
if(imageFileName!=" " && imageId!=" "){

%>

<img src="Images/<%=imageFileName %>" style="width:900px;height:400px ">

<%
}
%>

</div>



</body>
</html>