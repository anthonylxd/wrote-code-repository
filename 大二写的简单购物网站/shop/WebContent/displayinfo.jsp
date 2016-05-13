<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*"%>
<%@page import="java.util.*" %>
<%@page import="com.shop.model.product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看商品</title>
</head><jsp:include page="islogin.jsp"></jsp:include>
<body><jsp:useBean id="prod" class="com.shop.userservice.productservice"></jsp:useBean>
<% 
List pros=(List)session.getAttribute("pros");
//out.print(stus.size());
Iterator iter=pros.iterator();
%>
<table>
<tr><td>商品名称</td><td>数量</td><td>价格</td></tr>
	<%
			int i = 0;
			while (iter.hasNext()) {
				product pro =(product) iter.next();
    %>
		<tr>
		<td><%=pro.getProductname() %></td>
		<td><%=pro.getProductnum() %></td>
		<td><%=pro.getProductfare() %></td>
		</tr><% i++;
}
%>
</table>
</body>
</html>