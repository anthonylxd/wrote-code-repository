package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import com.entity.comment;
import com.entity.comment2;
import com.service.comment2Service;
import com.service.userService;

/**
 * Servlet implementation class comment2Select
 */
@WebServlet("/comment2Select")
public class comment2Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comment2Select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		comment2Service comment2Service = new comment2Service();
		List<comment2> comment2s = comment2Service.selectById(commentId);
		userService userService = new userService();
		int commentsSize = comment2s.size();
		for(int i = 0; i<commentsSize;i++) {
			int userId = comment2s.get(i).getCommentUserId();
			String username = userService.usernameSelectById(userId);
			comment2s.get(i).setInfo(username);
		}
		PrintWriter out = response.getWriter();
		out.println(JSON.toJSON(comment2s));
		System.out.println("发起请求回应");
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
