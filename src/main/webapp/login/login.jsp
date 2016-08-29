<%@ page language="java" import="java.util.*"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>爱儿德登陆页</title>
</head>

<body>

	<form name="loginForm" action="../user/login.do" method="post">
		<table>
			<tr><td>姓名:</td><td><input type= "text" name= "userName"/></td></tr>
			<tr><td colspan="3"><input type="submit" value="登陆"></td></tr>
		</table>
	</form>
	<br/>
	<div><%-- String errInfo = (String) request.getSession().getAttribute("info"); 
		if(errInfo!=null)
			out.print(errInfo);
		else
			out.print("");
	--%></div>
	
	<c:out value="${info }">
	</c:out>

	<br/>

<a href="./register.jsp">注册</a>
</body>
</html>