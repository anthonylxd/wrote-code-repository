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
<form action="newtitleaction">
<table>
<tr>
<td>新增订单</td>
<td><input type="text" name="title" style="height:51px;width:449px"/></td>
</tr>
<tr>
<td>经办人</td>
<td>
<%=session.getAttribute("username")%><input type="radio" name="author" value=<%=session.getAttribute("username")%> checked="checked"/>
</td>
</tr>
<tr>
<td>时间</td>
<td><input type="text" name="date"/>&nbsp格式：2017-05-12</td>
</tr>
<td>代理商名称</td>
<td><input type="text" name="agentname"/></td>
</tr>
<td>客户名称</td>
<td><input type="text" name="customername"/></td>
</tr>
<tr>
<td>金额</td>
<td><input type="text" name="zan"  checked="checked"/></td>
</tr>
<tr>
<td>付款情况</td>
<td><input type="radio" name="pay" value="未付款"  checked="checked"/>未付款</td>
</tr>
<tr>
<td>发货情况</td>
<td><input type="radio" name="send"  checked="checked" value="未发货"/>未发货</td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="确定"/></td>
</tr>
<tr>
<td colspan="2"><a href="index2.jsp">返回主页</a></td>
</tr>
</table>
</form>
</body>
</html>