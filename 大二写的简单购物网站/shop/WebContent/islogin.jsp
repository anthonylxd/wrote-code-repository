<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.shop.model.shopuser" %>

<%
shopuser user=(shopuser)session.getAttribute("user");
if(user==null)
{
%>
<jsp:forward page="index.jsp"></jsp:forward>
<%} %>
