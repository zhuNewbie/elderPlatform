package cn.elderPlatform.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import cn.zylhkj.init.SystemContext;

public class LoginCheckAjax  extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {response.getWriter().print("{'info':'恭喜此用户不存在'}");}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		
//		System.out.println("loginajax...");
//		String name= request.getParameter("userName");
//		System.out.println(request.getParameter("userName"));
//		ApplicationContext ctx = SystemContext.getApplicationContext();
//		UserImp userDao = (UserImp)ctx.getBean("userDao");
//		User user = userDao.getUserByName(name);
//		System.out.println(user);
//		
		response.setContentType("text/html; charset=UTF-8");
		
		
//		if (user== null)
//		{
			response.getWriter().print("{'info':'恭喜此用户不存在'}");
//		}
//		else
//			response.getWriter().print("{'info':'此用户已存在'}");
//				
		
	}

}
