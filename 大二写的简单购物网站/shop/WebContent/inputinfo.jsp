<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输入商品信息</title>
</head><jsp:include page="islogin.jsp"></jsp:include>
<body><center>
<form method="post" action="inputinfoservlet">
<table bgcolor="green">
<tr><td align="center" colspan="2">输入商品信息</td>
</tr><tr>
<td>商品名称：</td><td><input type="text" name="productname"/></td>
</tr>
<tr>
<td>商品数量：</td><td><input type="text" name="productnum"/></td>
</tr>
<tr>
<td>商品价格：</td><td><input type="text" name="productfare"/></td>
</tr>
<tr>
<td align="center" colspan="2"><input type="submit" value="提交">
<input type="reset" value="重置">
</td>
</tr>
</table>
</form>
</center>
</body>
</html>