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
import com.service.commentService;
import com.service.userService;

/**
 * Servlet implementation class commentSelect
 */
@WebServlet("/commentSelect")
public class commentSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public commentSelect() {
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
		int weiboId = Integer.parseInt(request.getParameter("weiboId"));
		commentService commentService = new commentService();
		List<comment> comments = commentService.selectById(weiboId);
		userService userService = new userService();
		int commentsSize = comments.size();
		for(int i = 0; i<commentsSize;i++) {
			int userId = comments.get(i).getCommentUserId();
			String username = userService.usernameSelectById(userId);
			comments.get(i).setInfo(username);
		}
		PrintWriter out = response.getWriter();
		out.println(JSON.toJSON(comments));
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
