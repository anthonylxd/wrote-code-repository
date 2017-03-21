package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import com.entity.user;
import com.entity.usernuminfo;
import com.entity.userseting;
import com.service.usernuminfoService;
import com.service.usersetingService;

/**
 * Servlet implementation class userSeting
 */
@WebServlet("/userSeting")
public class userSeting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userSeting() {
        super();
        // TODO Auto-generated constructor stub
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
		int userId = Integer.parseInt(request.getParameter("userId"));
		String order = request.getParameter("order");
		System.out.println(order);
		System.out.println("132");
		usersetingService usersetingService = new usersetingService();
		userseting userseting  = usersetingService.select(userId);
		
		if(request.getSession().getAttribute("userId") != null) {					
		if(userId == (int)request.getSession().getAttribute("userId")) {
			userseting.setInfo("0");
		}
		}else{
			userseting.setInfo("1");
		}
		Map<String, Object> returns = new HashMap();
		if(order.equals("num")) {
			usernuminfoService usernuminfoService = new usernuminfoService();
			usernuminfo usernuminfo = usernuminfoService.select(userId);
			returns.put("usernuminfo",usernuminfo);
			System.out.println(order);
		}
		returns.put("userseting", userseting);
		String data = JSON.toJSONString(returns);
		System.out.println(data);
		PrintWriter out = response.getWriter();
		out.print(data);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
