<%@ page language="java" import= "java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>爱儿德注册页</title>
</head>
<body>
	<form name="registerForm" action="./register.do" method="post">
		<table>
			<tr><td>用户名：</td><td><input type="text" name="userName"></td></tr>
			<tr><td><input type="submit" value="注册"/></td>
			<td><button type="button"onclick="javascript :history.back(-1);">返回</button></td></tr> 
		</table>
	</form>
</body>
</html>