package com.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.userservice.productservice;

/**
 * Servlet implementation class displayallinfoservlet
 */
@WebServlet("/displayallinfoservlet")
public class displayallinfoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayallinfoservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String osid=request.getParameter("osid");
		List  pros=new productservice().queryAllpro();
		HttpSession session=request.getSession();
		session.setAttribute("pros", pros);
		if(osid.equals("display"))
		response.sendRedirect("displayinfo.jsp");
		else if(osid.equals("modify"))
		response.sendRedirect("modifyinfo.jsp");
		else
		response.sendRedirect("deleteinfo.jsp");

	}

}
