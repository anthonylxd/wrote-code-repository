<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="islogin.jsp"></jsp:include>
<body>
<a href="inputinfo.jsp" target="main_right">录入商品信息 </a><br>
<a href="displayallinfoservlet?osid=display" target="main_right">查看商品信息</a><br>
<a href="displayallinfoservlet?osid=modify" target="main_right">修改商品信息</a><br>
<a href="displayallinfoservlet?osid=delete" target="main_right">删除商品信息</a><br>
<a href="exitservlet" target="_top">退出</a><br>
</body>
</html>