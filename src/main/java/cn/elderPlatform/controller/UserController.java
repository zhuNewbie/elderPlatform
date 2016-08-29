package cn.elderPlatform.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.elderPlatform.login.User;
import cn.elderPlatform.login.UserImp;
import cn.elderPlatform.login.dao.UserDao;
import cn.zylhkj.init.SystemContext;

@Controller
@RequestMapping("/user")

public class UserController {


	@RequestMapping("/register")
	public String register(HttpServletRequest request, Model model) {
		// int userId = Integer.parseInt(request.getParameter("id"));
		// User user = this.userService.getUserById(userId);

		ApplicationContext ctx = SystemContext.getApplicationContext();
		UserImp userBiz = (UserImp) ctx.getBean("userDao");
		User user = new User();
		user.setName(request.getParameter("userName"));
		userBiz.insert(user);
		User newUser = userBiz.getUserByName(user.getName());
		model.addAttribute("user", newUser);
		return "registerSuccess";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {

		ApplicationContext ctx = SystemContext.getApplicationContext();
		UserImp userBiz = (UserImp) ctx.getBean("userDao");
		User user = userBiz.getUserByName(request.getParameter("userName"));
		System.out.println(user);
		String basePath = request.getContextPath();

		if (user == null) {
			// response.getWriter().print("<body><p>用户名不存在</p></body></html>");
			request.getSession().setAttribute("info", "用户名不存在");
			return "loginFailed";
		} else {
			//request.getSession().setAttribute("info", null);
			request.getSession().setAttribute("userInfo", user);
			return "loginSuccess";
		}
	}
	
	@RequestMapping("/user")
	public String userInfo(HttpServletRequest request, HttpServletResponse response, Model model) {

		ApplicationContext ctx = SystemContext.getApplicationContext();
		UserImp userBiz = (UserImp) ctx.getBean("userDao");
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
