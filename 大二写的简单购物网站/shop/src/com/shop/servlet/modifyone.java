package com.shop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.product;
import com.shop.userservice.productservice;

/**
 * Servlet implementation class modifyone
 */
@WebServlet("/modifyone")
public class modifyone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyone() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String productname=request.getParameter("productname");
		int productnum=Integer.parseInt(request.getParameter("productnum"));
		Double productfare=Double.parseDouble(request.getParameter("productfare"));
        product pro=new product();
		pro.setProductname(productname);
		pro.setProductnum(productnum);
		pro.setProductfare(productfare);
		if(new productservice().update(pro))
			response.sendRedirect("sucess.jsp");
		else
			response.sendRedirect("modifyinfo.jsp");
	}

	}

