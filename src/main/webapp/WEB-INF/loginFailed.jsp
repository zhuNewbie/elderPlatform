
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>登陆失败</title>
	</head>

	<body>
	
		<%
		request.getRequestDispatcher("../login/login.jsp").forward(request, response);
		%>

	</body>
</html>
