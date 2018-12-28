<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>新增商品</h1>
<s:form action="product_save" method="post" namespace="/" theme="simple">
	名称<s:textfield name="pname"/>
	价格<s:textfield name="price"/>
	<input type="submit" value="提交"/>
</s:form>
</body>
</html>