
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload using Maven</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<div class="container col-lg-6">
		<h1 class="text-center">File Upload to Folder Example - and image name stored in db/ table </h1>
		<div class="card">
			<div class="card-body">
				<form method="post" class="form-group" action="uploadServlet"
					enctype="multipart/form-data">
					<div class="form-group">
						<label for="first name">Banner TagLine: </label> <input type="text"
							class="form-control"  name="firstName" size="50" />
					</div>
					<div class="form-group">
						<label for="last name">Button Syntax </label> <input type="text"
							class="form-control" name="lastName" size="50" />
					</div>
					

					<div class="form-group">
						<label for="Profile Photo">Profile Photo:</label> <input
							type="file" name="photo" size="50" />
					</div>
					<div class="form-group">
						<label for="last name">Status</label> 
						<input type="radio"
							class="form-control" name="status" value="active"  />Active
						<input type="radio"
							class="form-control" name="status"  value="inactive" />InActive<br>	
							
					</div>
					<input type="submit" value="Save" class="btn btn-success">
				</form>
			</div>
		</div>
	</div>
</body>
</html>
