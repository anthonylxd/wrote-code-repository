<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.service.postcurd"%>
<%@page import="com.model.post"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 以下方式只是刷新不跳转到其他页面 -->
<meta http-equiv="refresh" content="60">
<title>主页</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<div id="wrap">
<h1>恶魔法则BBS</h1>
<div class="title">
<a href="login.jsp">发帖</a>
<a href="login.jsp">用户登录</a>
<a href="register.jsp">用户注册</a>
<a href="hostlogin.jsp">版主登录</a>
<!--  <a href="displayservlet?osid=index1">刷新</a>-->
<br/></div>
<%List posts = new postcurd().display();
Iterator iter = posts.iterator();
%>
<div class="graph">
<table>
<tr><td>title</td><td>author</td><td>date</td><td>zan</td></tr>
<%
	while(iter.hasNext()){
	int i = 0;
	post pos = (post)iter.next();
	
%>
<tr>
<td><%=pos.getTitle() %></td>
<td><%=pos.getAuthor()%></td>
<td><%=pos.getDate() %></td>
<td><%=pos.getZan()%></td>
</tr>

<%i++;

	} %>
</body>
</html>