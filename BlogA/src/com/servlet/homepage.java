package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import com.entity.relation;
import com.entity.user;
import com.entity.usernuminfo;
import com.entity.userseting;
import com.entity.weibo;
import com.service.relationService;
import com.service.userService;
import com.service.usernuminfoService;
import com.service.usersetingService;
import com.service.weiboService;

import sun.net.www.content.text.plain;

/**
 * Servlet implementation class homepage
 */
@WebServlet("/homepage")
public class homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homepage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		//默认1
		int page = Integer.parseInt(request.getParameter("page"));
		Map<String, Object> returns = new HashMap();
//	int userId = 1;
		//int userId = Integer.parseInt(request.getParameter("userId"));
		//if(page == 0){
			userService userService = new userService();
			//user user = userService.userSelectById(userId);
			String username = request.getParameter("name");
			user user = userService.userSelectByUsername(username);
			int userId = user.getUserId();
			returns.put("user", user);
		//}
		usersetingService usersetingService = new usersetingService();
		userseting userseting  = usersetingService.select(userId);
		if(request.getSession().getAttribute("userId") != null) {					
		if(userId == (int)request.getSession().getAttribute("userId")) {
			userseting.setInfo("1");
		}
		}else{
			userseting.setInfo("0");
		}
		weiboService weiboService = new weiboService();
		List<weibo> weibos = weiboService.selectByuserId(userId,page,2);
		usernuminfoService usernuminfoService = new usernuminfoService();
		usernuminfo usernuminfo = usernuminfoService.select(userId);
		relationService relationService = new relationService();
		relationService.isRelation(userId,userId);
		returns.put("weibos", weibos);
		returns.put("userseting", userseting);
		returns.put("usernuminfo", usernuminfo);
		String data = JSON.toJSONString(returns);
		PrintWriter out = response.getWriter();
//		System.out.println(data);
		out.println(data);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
