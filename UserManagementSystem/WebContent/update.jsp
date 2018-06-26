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
<body bgcolor="indigo" style="color:blue;">
${key}
<form action="update.do" method="post">
<pre>
Name:		<input type="text" name="name" value="${key1.name}">
Email:		<input type="text" name="email" value="${key1.email}" readonly="readonly">
Phone:		<input type="text" name="phone" value="${key1.phone}">
Age:		<input type="text" name="age" value="${key1.age}">
City:		<input type="text" name="city" value="${key1.city}">
Country:	<input type="text" name="country" value="${key1.country}">
Password:	<input type="password" name="password" value="${key1.password}" >
<input type="submit" value="Update" class="btn">
<a href="login.jsp" class="btn1">Login</a>
</pre>
</form>
</body>
</html>