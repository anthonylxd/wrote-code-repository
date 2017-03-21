package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.relation;
import com.service.relationService;

/**
 * Servlet implementation class relationFollow
 */
@WebServlet("/relationFollow")
public class relationFollow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public relationFollow() {
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
		int userId = 1;
		//int userId = (int) request.getSession().getAttribute("userId");
		int followId =Integer.parseInt(request.getParameter("userId"));
		String followinfo = request.getParameter("followinfo").toString();
		relationService relationService = new relationService();
		if(followinfo.equals("0")) {
			relationService.Insert(followId,userId);
		}else{
			relationService.relationDelete(followId,userId);
		}
		PrintWriter out = response.getWriter();
		out.println(followinfo);
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
