<%@page import="dao.FeedDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String maxNo = request.getParameter("maxNo");
	out.print( (new FeedDAO()).getGroup(maxNo));
%>