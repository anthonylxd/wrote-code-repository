<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="cn.model.Student" %>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="cn.service.service"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="prod" class="cn.service.service"></jsp:useBean>
<% 
List pros=new service().queryAllpro(); ;
Iterator iter=pros.iterator();
%>
<table>
<tr><td>名称</td><td>密码</td><td>修改</td><td>删除</td></tr>
	<%
			int i = 0;
			while (iter.hasNext()) {
				Student pro =(Student) iter.next();
    %>
		<tr>
		<td><%=pro.getUsername() %></td>
		<td><%=pro.getPassword() %></td>
		<td><a href="modify">修改信息</a></td>
		<td><a href="delete?username=<%=pro.getUsername()%>">删除信息</a></td>
		</tr><% i++;
}
%>
</body>
</html>