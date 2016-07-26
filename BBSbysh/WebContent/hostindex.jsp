<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.service.postcurd"%>
<%@page import="java.util.*"%>
<%@page import="com.model.post"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员主页</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<div id="wrap">
<h1>恶魔法则BBS</h1>
<div class="title">
你好，管理员<%=session.getAttribute("username")%>
<a href="newtitle.jsp">发帖</a>
<a href="manageuser.jsp">管理用户</a>
<!--<a href="displayservlet?osid=hostindex">刷新</a>-->
<br/></div>
<%List posts = new postcurd().display();
Iterator iter = posts.iterator();
%>
<div class="graph">
<table>
<tr><td>title</td><td>author</td><td>date</td><td>zan</td><td>删除</td></tr>
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
<td><a href="deletepostaction?title=<%=pos.getTitle()%>">删除</a>
</tr>

<%i++;

	} %>
</table>
</div>
</div>
</body>
</html>