<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*" %>
<%@page import="com.shop.model.product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
List pros=(List)session.getAttribute("pros");
Iterator iter=pros.iterator();
%>
<table>
<tr><td>商品名称</td><td>数量</td><td>价格</td></tr>
	<%
			int i = 0;
			while (iter.hasNext()) {
				product product=(product) iter.next();
    %>
		<tr>
		<td><%=product.getProductname() %></td>
		<td><%=product.getProductnum() %></td>
		<td><%=product.getProductfare() %></td>
		<td><a href="deleteservlet?productname=<%=product.getProductname()%>">删除</a></td>
		</tr><% i++;
}
%>
</table>
</body>
</html>