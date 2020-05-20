<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="myRobot.vo.Product" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'product.jsp' starting page</title>
    
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
    This is product page. <br>
    <%ArrayList<Product> proAL= (ArrayList<Product>)session.getAttribute("proAL"); %> 
    <%for(Product tem: proAL){
    	String name = tem.getName();
    	Integer ID = tem.getID();
    	%>
	  	<tr name="product">
	  		<td>Product ID:<%=ID %></td>
	  		<td>Product Name: <%=name %></td>
	  	</tr><br>
	  	<a href="detail.jsp?id=<%=ID%>">Turn to Product<%=name %> Page</a><br>
	<%} %>
  </body>
</html>
