<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home.jsp' starting page</title>
    
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
    This is my home page. <br>
    	<form method="post" action="./show"> 
			Product Table: 
			<input type="SUBMIT" name="submit" value="GO"> 
		</form>
			To Login:
		<form method="get" action="./login.jsp">  
			<button type="SUBMIT" name="submit">go </button>
		</form>
			To Register:
		<form method="post" action="./Register.jsp">  
			<input type="SUBMIT" name="submit" value="GO"> 
		</form>
  </body>
</html>
