    <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
    <html>  
      <head>  
        <title>测试</title>  
      </head>  
        
      <body>
      <script type="text/javascript">
      <% 
      String basePath = request.getContextPath();
      response.setHeader("refresh","30;url="+basePath+"/login/login.jsp");
      //getServletConfig().getServletContext().getRequestDispatcher("/login/login.jsp").forward(request, response);%>
      </script> 
      	欢迎您:
        ${userInfo.name}!<br/>
             第${userInfo.id }位用户  
        <br/>
        <h1 align="center">注册成功</h1>
        <h2 align="center"><a href="<%=request.getContextPath() %>/login/login.jsp">马上登陆</a></h2>
      </body>  
    </html>  