package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.Response;

import com.service.usernuminfoService;
import com.service.weiboService;

/**
 * Servlet implementation class newWeibo
 */
@WebServlet("/newWeibo")
public class newWeibo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newWeibo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//发表新微博
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		//暂时的
		int userId = 1;
		//int userId = (int) request.getSession().getAttribute("userId");
		String weiboContent = request.getParameter("weiboContent");
		String weiboImg = request.getParameter("weiboImg");
		weiboService weiboService = new weiboService();
		weiboService.insert(userId,weiboContent,weiboImg);
		int add = 1;
		new usernuminfoService().weiboNum(userId, add);
		PrintWriter out = response.getWriter();
		out.print("12515");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//转发
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		int weiboId = Integer.parseInt(request.getParameter("weiboId"));
		//暂时的
		int userId = 1;
		weiboService weiboService = new weiboService();
		weiboService.forward(weiboId, userId);
		int add = 1;
		new usernuminfoService().weiboNum(userId, add);
		PrintWriter out = response.getWriter();
		out.print("forward ok");
		out.flush();
		out.close();
	}

}
