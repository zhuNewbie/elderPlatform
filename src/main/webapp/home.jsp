<%@ page language="java" import="java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>爱儿德首页</title>
</head>
<body>
你好：
<c:out value="${userInfo.name }" />
<a href="./sessionTest.jsp">继续</a>

<!-- test json communiate -->

<form name="f" action="./device/sendBeltMsg.do" method="post">
  <table>
  <tr><td>sid:</td><td><input type="text" name="sid"></td></tr>
  <tr><td>message:</td><td><input type="text" name="message"></td></tr>
  <tr><td>date:</td><td><input type="date" name="createtime"></td></tr>
  <tr><td colspan=2><input type="submit" value="send"></td></tr>
  </table>
</form>

<div id="postOut" style="margin:0px auto; text-align:center" >
	<p>绑定设备接口测试</p>
	<form name="test" action="./device/boundDevice.do" method="post">
	<table>
	<tr><td>deviceId</td><td><input type="text" name="device_id"></td></tr>
	<tr><td>account</td><td><input type="text" name="admin_account"></td></tr>
	<tr><td colspan=2><input type="submit" value="bound"></td></tr>
	</table>
	</form>
</div>
</body>
</html>