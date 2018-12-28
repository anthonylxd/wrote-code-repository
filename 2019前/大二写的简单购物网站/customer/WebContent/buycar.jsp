<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*"%>
<%@page import="java.util.*" %>
<%@page import="com.shop.model.buycar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<body>
<% 
List pros=(List)session.getAttribute("pros");
//out.print(stus.size());
Iterator iter=pros.iterator();
%>
<table>
<tr><td>商品名称</td><td>数量</td><td>发货情况</td></tr>
	<%
			int i = 0;
			while (iter.hasNext()) {
				buycar pro =(buycar) iter.next();
    %>
		<tr>
		<td><%=pro.getProductname() %></td>
		<td><%=pro.getProductfare() %></td>
		<td><%=pro.getFahuo() %></td>
		<td><a href="支付宝.jsp">付款</a></td>
		</tr><% i++;
}
%>
</body>
</html>