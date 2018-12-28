package com.shop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shop.model.buycar;
import com.shop.userservice.buycarservice;

/**
 * Servlet implementation class buycarservlet
 */
@WebServlet("/buycarservlet")
public class buycarservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buycarservlet() {
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
		request.setCharacterEncoding("UTF-8");
		String proname=request.getParameter("productname");
		double profare=Double.parseDouble(request.getParameter("productfare"));
		String profa=request.getParameter("fahuo");
		buycar pro=new buycar();
		pro.setProductname(proname);
		pro.setProductfare(profare);
		pro.setFahuo(profa);
		if(new buycarservice().addcarProduct(pro))
			response.sendRedirect("sucess.jsp");
		else
			response.sendRedirect("addbuycar.jsp");
		
	}

}
