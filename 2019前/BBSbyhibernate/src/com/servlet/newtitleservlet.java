package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.post;
import com.service.postcurd;

/**
 * Servlet implementation class newtitleservlet
 */
@WebServlet("/newtitleservlet")
public class newtitleservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newtitleservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");	
		String author = request.getParameter("author");
		String date = request.getParameter("date");
		int zan = Integer.parseInt(request.getParameter("zan"));
		post post = new post();
		post.setTitle(title);
		post.setAuthor(author);
		post.setDate(date);
		post.setZan(zan);
		try {
			if(new postcurd().addpost(post))
			{
				HttpSession session = request.getSession();
				session.setAttribute("post", post);
				response.sendRedirect("index2.jsp");
			}else {
				response.sendRedirect("fail.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
