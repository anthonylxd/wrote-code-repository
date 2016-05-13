<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.shop.model.customer" %>

<%
customer user=(customer)session.getAttribute("user");
if(user==null)
{
%>
<jsp:forward page="index.jsp"></jsp:forward>
<%} %>
