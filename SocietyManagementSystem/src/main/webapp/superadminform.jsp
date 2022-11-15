
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>


</head>
<body style="text-align:center;">
<h1>SuperAdmin Registration Form</h1>
<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${newUser != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${newUser == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

<form method="post" action="adminFormSubmit">
<input type="text" name="name" placeholder="Enter your name"/><br><br>
<input type="email" name="emailid"  placeholder="Enter your emailId"/><br><br>
<input type="password" name="password"  placeholder="Enter your password"/><br><br>
<input type="submit" value="submit"/>
</form>
</div>
</div></div>
</body>


</html>