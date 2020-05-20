<%@ page language="java" pageEncoding="GB18030"%>
 
<html> 
	<head>
		<title>JSP for UserForm form</title>
	</head>
	<body>
		<form method="post" action="./login"> 
			username : <input type="text" name="username"/><br/>
			password : <input type="text" name="password"/><br/>
			<input type="SUBMIT" name="submit" value="Submit"> 
		</form>
		
		<form method="get" action="./forgetpassword.jsp">
			<input type="submit" name="forget" value="Forget Password">
		</form>
	</body>
</html>

