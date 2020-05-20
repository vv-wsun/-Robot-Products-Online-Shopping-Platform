<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'forgetpassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    Forget the Password? Don't Worry! <br>
    Fill in the e-mail address to identify your identity!<br><br>
    
  	<form method="get" action="./servlet/IdentifyEmailServlet">
  		Your Uername : <input type="text" name="username"/><br/>
   		E-mail Address:<input type="text" name="email"/>
		<input type="submit" name="forget" value="IDENTIFY">
	</form>
    
  </body>
</html>
