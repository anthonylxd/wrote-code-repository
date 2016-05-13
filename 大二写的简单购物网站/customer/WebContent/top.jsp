<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<marquee><h2>welcome to soccer world</h2></marquee><br/>
<%!int number=1; %>
<%!public int count(){
	return number++;
}
%><a href="disbuycarservlet" target="main_left">购物车</a>
<%="您今天是第"+count()+"次浏览！" %>
</body>
</html>