<%@page import="dto.FeedDTO"%>
<%@page import="dao.FeedDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 목록</title>
</head>
<body>
<%
	FeedDAO dao = new FeedDAO();
	for(FeedDTO dto : dao.getList()){
		out.print(dto);
		out.print("<br>");
	}
	
%>
</body>
</html>