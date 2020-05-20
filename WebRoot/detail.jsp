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
    
    <title>My JSP 'cart.jsp' starting page</title>
    
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
 
  <%ArrayList<Product> proAL= (ArrayList<Product>)session.getAttribute("proAL"); 
  int id = Integer.parseInt(request.getParameter("id"));
  String username = (String)session.getAttribute("username");
  		String name = null;
    	int ID = 0;
    	int number = 0;
    	double price = 0;
    	String detail = null;%> 
    <%for(Product tem: proAL){
    	if(tem.getID()==id){
    	name = tem.getName();
    	ID = tem.getID();
    	number = tem.getNumber();
    	price = tem.getPrice();
    	detail = tem.getDetail();
    	}
      }
    	%>
	  	<tr name="product">
	  		<td>Product ID:<%=ID %></td>
	  		<td>Product Name: <%=name %></td>
	  	</tr><br>
	  	Username:<%=username %><br>
    
    The detailed information of Product<%=name %> <br>
        
    The chosen product:<%=name %><br>
    Product ID:<%=ID %> <br>
    Detailed Description :<%=detail %> <br>
	Remaining Quantity: <%=number %><br>
	Product Price: <%=price %><br>
	<%if(number>0){ %>
    <form method="post" action="./servlet/AddCartServlet?id=<%=ID%>&number=<%=number %>&username=<%=username%>">
   	Amount: <input type="text" name="amount"/>
    <input type="SUBMIT" name="add" value="ADD TO CART"/>
    </form>
	<%} else{ %>
		Inventory shortage!<br>
	<%} %>
  </body>
</html>
