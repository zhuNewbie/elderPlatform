    <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
    <html>  
      <head>  
        <title>登陆成功</title>  
      </head>  
        
      <body> 
      <div id="site-nav-user"><a href="./user.do?id=${userInfo.id }">${userInfo.name }</a></div>
      欢迎您：
        ${userInfo.name}<br/>
      您是第
        ${userInfo.id }位用户  
      </body>  
    </html>  