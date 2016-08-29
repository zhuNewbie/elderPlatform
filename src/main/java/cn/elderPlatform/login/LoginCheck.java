package cn.elderPlatform.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import cn.zylhkj.init.SystemContext;

@SuppressWarnings("serial")
public class LoginCheck extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//System.out.println("login...");
		String name= request.getParameter("userName");
		//System.out.println(request.getParameter("userName"));
		ApplicationContext ctx = SystemContext.getApplicationContext();
		UserImp userDao = (UserImp)ctx.getBean("userDao");
		User user = userDao.getUserByName(name);
		System.out.println(user);
		String basePath = request.getContextPath();
		
		response.setContentType("text/html; charset=UTF-8");
		
		
		if (user== null)
		{
			//response.getWriter().print("<body><p>用户名不存在</p></body></html>");
			request.getSession().setAttribute("info", "用户名不存在");
			response.sendRedirect(basePath+"/login/login.jsp");
		}
		else
		{	response.getWriter().print("<body><p>欢迎你："+user.getName()+"</p>"
				+ "<a href=\"./home.jsp\">首页</a></body></html>");
		request.getSession().setAttribute("info", null);
		request.getSession().setAttribute("userInfo", user);
		}
				
		
	}
}
