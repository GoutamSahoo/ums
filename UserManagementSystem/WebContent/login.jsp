<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.btn
{
	background-color: green;
	color:orange;
}
.btn1
{
	color:red;
}
</style>
</head>
<body bgcolor="cyan" style="color:blue;">
${key}
<form action="login.do" method="post">
<pre>
Email:		<input type="text" name="email">
Password:	<input type="password" name="password">
<input type="submit" value="Login" class="btn">
</pre>
<a href="register.jsp" class="btn1">Register</a>&nbsp;&nbsp;
<a href="forget.jsp" class="btn1">Forget Password</a>
</form>
</body>
</html>