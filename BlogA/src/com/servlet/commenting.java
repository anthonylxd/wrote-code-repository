package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.comment;
import com.service.commentService;
import com.service.weiboService;

/**
 * Servlet implementation class commenting
 */
@WebServlet("/commenting")
public class commenting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commenting() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = 1;
		//int userId = (int) request.getSession().getAttribute("userId");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		String weiboContent = request.getParameter("commentContent");
		int weiboId = Integer.parseInt(request.getParameter("weiboId"));
		comment comment = new comment();
		comment.setCommentContent(weiboContent);
		comment.setCommentUserId(userId);	
		comment.setCommentWeiboId(weiboId);
		commentService commentService = new commentService();
		commentService.insert(comment);
		new weiboService().weiboCommentAdd(weiboId,1);
		PrintWriter out = response.getWriter();
		out.print("hao");
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
