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
@WebServlet("/personpage")
public class personpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public personpage() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		//默认1
		int page = Integer.parseInt(request.getParameter("page"));
		Map<String, Object> returns = new HashMap();
		
		int userId = 1;
			//int userId = (int) request.getSession().getAttribute("userId");
			userService userService = new userService();
			user user = userService.userSelectById(userId);
			returns.put("user", user);
		usersetingService usersetingService = new usersetingService();
		userseting userseting  = usersetingService.select(userId);
		relationService relationService = new relationService();
		List<Integer> follows = relationService.relationSelect(userId);
		weiboService weiboService = new weiboService();
		List<weibo> weibos = weiboService.selectByRelation(follows,page,4);
		usernuminfoService usernuminfoService = new usernuminfoService();
		usernuminfo usernuminfo = usernuminfoService.select(userId);
		returns.put("weibos", weibos);
		returns.put("userseting", userseting);
		returns.put("usernuminfo", usernuminfo);
		String data = JSON.toJSONString(returns);
		PrintWriter out = response.getWriter();
		out.println(data);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
