<%@ page language="java" import= "java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>爱儿德注册页</title>
<script type="text/javascript">
	function init(err){
		if(err){
			alert(err);
		}
			
	}

</script>
</head>

<body onLoad="init('${sessionScope.err}')">

	<form name="registerForm" action="../user/register.do" method="post">
		<table>
			<tr><td>用户名：</td><td><input type="text" name="userName"></td></tr>
			<tr><td>密码：</td><td><input type="password" name="password"></td></tr>
			<tr><td><input type="submit" value="注册"/></td>
			<td><button type="button"onclick="javascript :history.back(-1);">返回</button></td></tr> 
		</table>
	</form>
</body>
</html>