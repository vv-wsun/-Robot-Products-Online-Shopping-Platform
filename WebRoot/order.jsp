<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="myRobot.vo.Product" %>
<%@ page import="myRobot.vo.Cart" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'order.jsp' starting page</title>
    
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
    This is my Order. <br>
     <%ArrayList<Cart> cartAL2= (ArrayList<Cart>)session.getAttribute("cartAL2");
 	 String username = (String)session.getAttribute("username"); 
 	 double sum = 0;
 	 int i = 1;%> 
 	 
    <%for(Cart tem: cartAL2){
    	Product pro = tem.getPro();
    	int ID = pro.getID();
    	String name = pro.getName();
    	double price = pro.getPrice();
    	
    	int cartID = tem.getCartID();
    	int amount = tem.getAmount();
    	sum = tem.getTotalPrice();
    	%> 	 	
	  		
	  		Product ID:<%=ID %><br>
	  		Product Name: <%=name %><br>
	  		Amount:<%=amount %><br>
	  		Unit Price: <%=price %><br>
	  		Total Price: <%=sum %>
	  <br>
	<%i++;}%>
	<br>
	<br>
  </body>
</html>
