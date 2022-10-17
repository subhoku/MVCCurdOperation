<%@ page import = "java.io.*,java.util.*" %>
<html>
<body>
<h2>Hello World!</h2>
<!-- Scriplet tag -->
<% 
PrintWriter pw=null;
pw=response.getWriter();
System.out.println(pw);
pw.println("Hello World");
System.out.println("hello world"); 
Date date=new Date();
pw.println(date);
%>
</body>
</html>
