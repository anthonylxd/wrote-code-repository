package com.shop.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.shop.userservice.shopuserservice;
import com.shop.model.shopuser;
public class loginservlet extends HttpServlet {
    public loginservlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String username=request.getParameter("username");
		String password=request.getParameter("password");

		shopuser user=new shopuser();
		user.setShopusername(username);
		user.setPassword(password);
		try{
			if(new shopuserservice().vailUser(user)){
				HttpSession session=request.getSession();
				session.setAttribute("user",user);
				response.sendRedirect("main.jsp");
				}else
					response.sendRedirect("login.jsp");
			}catch(IOException e){
			}}
private String Integer(String parameter) {
		return null;
	}

}
