package cn.elderPlatform.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.elderPlatform.login.User;
import cn.elderPlatform.login.UserImp;
import cn.elderPlatform.login.dao.UserMapper;
import cn.zylhkj.init.SystemContext;

@Controller
@RequestMapping("/user")

public class UserController {
	 private static final Log log =LogFactory.getLog(UserController.class.getName());
	
	private UserImp userBiz;
	
	public boolean initUserController(){
		ApplicationContext ctx = SystemContext.getApplicationContext();
		this.userBiz = (UserImp) ctx.getBean("userDao");
		
		return true;
	}
	
	private boolean isUserExist(String userName){
		boolean result = false;
		User user = null;
		user = userBiz.getUserByName(userName);
		if (user != null){
			result = true;
		}
		return result;	
	}


	@RequestMapping("/register")
	public String register(HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws IOException {
		// int userId = Integer.parseInt(request.getParameter("id"));
		// User user = this.userService.getUserById(userId);
		//request.setCharacterEncoding("utf-8");
		if(userBiz == null){
			initUserController();
		}

		User user = new User();
		String registerName = request.getParameter("userName");
		if(isUserExist(registerName)){
			request.getSession().setAttribute("err", "user "+registerName+" already exisits");
			response.sendRedirect("../login/register.jsp");
			return null;
		}
		user.setName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		userBiz.insert(user);
		User newUser = userBiz.getUserByName(user.getName());
		model.addAttribute("userInfo", newUser);
		return "registerSuccess";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request,
			HttpServletResponse response, 
			Model model) throws
	UnsupportedEncodingException {
//
//		ApplicationContext ctx = SystemContext.getApplicationContext();
//		UserImp userBiz = (UserImp) ctx.getBean("userDao");
		log.debug("Hello, World!");
	    //request.setCharacterEncoding("utf-8");
		if(userBiz == null){
			initUserController();
		}
		User user = userBiz.getUserByName(request.getParameter("userName"));
		System.out.println(user);
		String basePath = request.getContextPath();

		if (user == null) {
			// response.getWriter().print("<body><p>用户名不存在</p></body></html>");
			request.getSession().setAttribute("info", "用户名不存在");
			return "loginFailed";
		} else {
			String pwd = request.getParameter("password");
			if(pwd.equals(user.getPassword())){
				//request.getSession().setAttribute("info", null);
				request.getSession().setAttribute("userInfo", user);
				return "loginSuccess";
			}
			else{
				request.getSession().setAttribute("info", "密码错误");
				return "loginFailed";	
			}
				
			
		}
	}
	
	@RequestMapping("/user")
	public String userInfo(HttpServletRequest request, HttpServletResponse response, Model model) {
//
//		ApplicationContext ctx = SystemContext.getApplicationContext();
//		UserImp userBiz = (UserImp) ctx.getBean("userDao");
		
		if(userBiz == null){
			initUserController();
		}
		User user = userBiz.getUserById(Integer.parseInt(request.getParameter("id")));
		System.out.println(user);
		String basePath = request.getContextPath();

		if (user == null) {
			// response.getWriter().print("<body><p>用户名不存在</p></body></html>");
			request.getSession().setAttribute("info", "用户名不存在");
			return "loginFailed";
		} else {
			//request.getSession().setAttribute("info", null);
			request.getSession().setAttribute("userInfo", user);
			return "user/userHome";
		}
	}

}
