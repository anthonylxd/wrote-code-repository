<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<form method="post" action="buycarservlet">
<table bgcolor="green">
<tr><td align="center" colspan="2">购买商品订单信息</td>
</tr><tr>
<td>所购商品名称：</td><td><input type="text" name="productname" value=<%=request.getParameter("Productname")%>></td>
</tr>
<tr></tr>
<tr>
<td>所购商品数量：</td><td><input type="text" name="productfare"/></td>
</tr>
<tr>
<td>发货情况：</td><td><input type="text" name="fahuo" value="未发货"/></td>
</tr>
<tr>
<td align="center" colspan="2"><input type="submit" value="添加到购物车">
<input type="reset" value="重置">
</td>
</tr>
</table>
</form>
</center>
</body>
</html>