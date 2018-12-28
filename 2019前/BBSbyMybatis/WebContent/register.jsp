<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册新用户</title>
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
<form action="useraddservlet" method="post">
<table>
<tr>
<td colspan="2">注册新用户</td>
</tr>
<tr>
<td>注册用户名</td>
<td><input type="text" name="username"/></td>
</tr>
<tr>
<td>注册密码</td>
<td><input type="password" name="password"/></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="注册"/></td>
</tr>
<tr>
<td colspan="2"><a href="index2.jsp">返回主页</a></td>
</tr>
</table>
</form>
</body>
</html>