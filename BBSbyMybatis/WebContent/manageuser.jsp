<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.service.usercurd"%>
<%@ page import="com.entity.User"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
</head>
<body>
<h1>用户管理</h1>
<%
List users=new usercurd().displayuser();
Iterator iter = users.iterator();
%>
<table>
<tr><td>用户</td><td>删除用户</td></tr>
<%
	while(iter.hasNext())
	{
	int i = 0;
	User use= (User)iter.next();

%>
<tr>
<td><%=use.getUsername()%></td>
<td><a href="deleteuserservlet?username=<%=use.getUsername()%>">删除</a></td>
</tr>
<%i++;
}%>
</table>

</body>
</html>