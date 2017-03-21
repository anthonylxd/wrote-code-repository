package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.relation;
import com.entity.user;
import com.entity.userseting;
import com.service.relationService;
import com.service.userService;
import com.service.userinformationService;
import com.service.usernuminfoService;
import com.service.usersetingService;

/**
 * Servlet implementation class userRegister
 */
@WebServlet("/userRegister")
public class userRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public userRegister() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		userService userService = new userService();
		
		PrintWriter out = response.getWriter();
		if(password == null){
			//用户名唯一性检测
			if(!userService.check(username)){	
			out.println("用户名已被注册，请更换");	
			}
		}else{
		user user = new user();
		user.setUsername(username);
		user.setPassword(password);
		int userId = userService.register(user);
		userinformationService userinformationService = new userinformationService();
		userinformationService.insert(userId);
		usernuminfoService usernuminfoService = new usernuminfoService();
		usernuminfoService.insert(userId);
		usersetingService usersetingService = new usersetingService();
		userseting userseting = new userseting();
		userseting.setUserId(userId);
		userseting.setUsername(username);
		usersetingService.insert(userseting);
		relationService relationService = new relationService();
		relationService.Insert(userId,userId);
		out.println("注册成功");	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
