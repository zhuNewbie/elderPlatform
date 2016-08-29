
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>登陆失败</title>
	</head>

	<body>
	
		<%
		response.sendRedirect("../login/login.jsp"); 
		request.getSession().setAttribute("info","请先登陆");
		%>

	</body>
</html>
