package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.service.userinformationService;
import com.alibaba.fastjson.JSON;
import com.entity.userinformation;


@WebServlet("/userinformationing")
public class userinformationing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userinformationing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		HttpSession session = request.getSession();
		int userId = 1;
		//int userId = (int) session.getAttribute("userId");
		String order= request.getParameter("order");
		userinformationService userinformationService = new userinformationService();	
		if(order.equals("update")) {
			System.out.println("update开始");
			String email = request.getParameter("email");
			String sex = request.getParameter("sex");
			String phone;
			if(request.getParameter("phone") !="") {
			 phone =  request.getParameter("phone");
			}else{
			 phone = "-1";//phone代表为空
			}
			String birthday = request.getParameter("birthday");
			String residence = request.getParameter("residence");
			String profession = request.getParameter("profession");
			System.out.println(email+sex+birthday+residence+profession);
			userinformationService.userinfoUpdate( userId,email, phone, sex, birthday, residence, profession);
			response.sendRedirect("index.jsp");
		}else{
			userinformation userinformation = userinformationService.userinfoSelect(userId); 
			String data = JSON.toJSONString(userinformation);
			PrintWriter out = response.getWriter();
			out.println(data);
			out.flush();
			out.close();	
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
