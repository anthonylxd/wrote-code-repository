package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.entity.user;
import com.entity.weibo;
import com.service.relationService;
import com.service.weiboService;

/**
 * Servlet implementation class weiboDisplay
 */
@WebServlet("/weiboDisplay")
public class weiboDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public weiboDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		HttpSession session = request.getSession();
		user user =  (user) session.getAttribute("user");	
		weiboService weiboService = new weiboService();
		List<weibo> weibos = weiboService.selectByuserId(1,0,2);//待决定
		String data = JSON.toJSONString(weibos);
		response.setHeader("Access-Control-Allow-Origin", "*");
		 PrintWriter out = response.getWriter();
		 out.println(data);
		
		System.out.println(data);
		System.out.println("end");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
