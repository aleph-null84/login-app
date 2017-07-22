<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
</head>
<body>
	<h1>Login Successful!</h1>
	
	<jsp:useBean id="user" class="com.yuriy.dto.User" scope="request">
		<jsp:setProperty property="userName" name="user" value="NewUser" />
	</jsp:useBean>
	
	<p>
	Hello <jsp:getProperty property="userName" name="user"/>
	</p>
</body>
</html>