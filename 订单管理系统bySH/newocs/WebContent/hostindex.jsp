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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<div id="wrap">
<h1>坚瑞订单管理系统</h1>
<div class="title">你好，
<%=session.getAttribute("username")%>&nbsp！
&nbsp&nbsp
<a href="newtitle2.jsp">新增订单</a>
<a href="index.jsp">退出</a>
<br/></div>
<%
List posts = new postcurd().display2((String)session.getAttribute("username"));
Iterator iter = posts.iterator();
%>
<div class="graph">
<table>
<tr><td>订单</td><td>经办人</td><td>时间</td><td>代理商</td><td>客户</td><td>金额</td>
<td>付款情况</td><td>发货情况</td><td>发货</td></tr>
<%
	while(iter.hasNext()){
	int i = 0;
	post pos = (post)iter.next();
	
%>
<tr>
<td><%=pos.getTitle()%></td>
<td><%=pos.getAuthor()%></td>
<td><%=pos.getDate() %></td>
<td><%=pos.getAgentname()%></td>
<td><%=pos.getCustomername()%></td>
<td><%=pos.getZan()%></td>
<td><%=pos.getPay() %></td>
<td><%=pos.getSend()%>
<td><a href="payzanaction?title=<%=pos.getTitle()%>">点击付款</a></td>
</tr>

<%i++;

	} %>
</table>
</div>
</div>
</body>
</html>