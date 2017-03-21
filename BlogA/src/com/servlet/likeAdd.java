package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.likeService;
import com.service.weiboService;

/**
 * Servlet implementation class likeAdd
 */
@WebServlet("/likeAdd")
public class likeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public likeAdd() {
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
		int userId = 1;
		//int userId = (int) request.getSession().getAttribute("userId");
		int weiboId = Integer.parseInt(request.getParameter("weiboId"));
		int add = Integer.parseInt(request.getParameter("add"));

		new weiboService().weiboLikeAdd(weiboId,add);
		new likeService().Insert(weiboId, userId);
		System.out.println(weiboId+"===="+add);
		PrintWriter out = response.getWriter();
		out.print("231");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
