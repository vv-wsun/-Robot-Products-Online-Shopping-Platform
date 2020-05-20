<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>JSP for UserForm form</title>
</head>
<body>
<form method="post" action="./register">
    username :<input type="text"name="username"/><br/>
    password :<input type="text"name="password"/><br/>
    emailaddress:<input type="text" name="emailaddress"/><br/>
      <input type="submit" name="submit" value="Submit">
</form>


</body>
</html>
