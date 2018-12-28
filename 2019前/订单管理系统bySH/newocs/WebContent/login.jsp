<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<style type="text/css">
	.wrapper{
		text-align:center;
		margin: 0 auto;
		width:270px;
	}
</style>
</head>
<body>
<div class="wrapper">
<c:form action="userAction" namespace="/">
<c:textfield label="用户名" name="username"></c:textfield>
<c:password label="密码" name="password"></c:password>
<c:submit value="登录"></c:submit>
</c:form>
</div>
</body>
</html>