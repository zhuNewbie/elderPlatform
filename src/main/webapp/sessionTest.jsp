<%@ page language="java" import="java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>爱儿德首页</title>
</head>
<body>
你好again：
<c:out value="${userInfo.name }" />
<a href="./sessionTest.jsp">继续</a>
</body>
</html>