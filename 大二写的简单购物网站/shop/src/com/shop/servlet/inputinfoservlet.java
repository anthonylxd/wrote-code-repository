package com.shop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shop.model.product;
import com.shop.userservice.productservice;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
@WebServlet("/inputinfoservlet")
public class inputinfoservlet extends HttpServlet {

    public inputinfoservlet() {
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	String proname=request.getParameter("productname");
	int pronum=Integer.parseInt(request.getParameter("productnum"));
	double profare=Double.parseDouble(request.getParameter("productfare"));
	product pro=new product();
	pro.setProductname(proname);
	pro.setProductnum(pronum);
	pro.setProductfare(profare);
	if(new productservice().addProduct(pro))
		response.sendRedirect("sucess.jsp");
	else
		response.sendRedirect("inputinfo.jsp");
	}

}
