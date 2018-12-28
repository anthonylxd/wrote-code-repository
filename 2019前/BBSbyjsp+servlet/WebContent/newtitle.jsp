<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.model.user" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发帖</title>
<style type="text/css">
body{
	background-color:#252F34;
}
td{	
	padding:12px 21px;
	color:#fff;
	background:rgba(0,0,0,0.08);
	text-align:center;
}
a{
	color: #fff;
	text-decoration:none;
}
</style>
</head>
<body>
<form action="newtitleservlet">
<table>
<tr>
<td>发帖</td>
<td><input type="text" name="title" style="height:51px;width:449px"/></td>
</tr>
<tr>
<td>发帖人</td>
<td>
<%=session.getAttribute("username")%><input type="radio" name="author" value=<%=session.getAttribute("username")%> checked="checked"/>
匿名<input type="radio" name="author" value="匿名"/>
</td>
</tr>
<tr>
<td>时间格式</td>
<td><input type="text" name="date"/>&nbsp格式：2017-05-12</td>
</tr>
<tr>
<td>赞</td>
<td><input type="radio" name="zan" value="0" checked="checked"/>0</td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="发帖"/></td>
</tr>
<tr>
<td colspan="2"><a href="index.jsp">返回主页</a></td>
</tr>
</table>
</form>
</body>
</html>