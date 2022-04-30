<%@page import="dto.FeedDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.FeedDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
<%
	FeedDAO dao = new FeedDAO();
	List<FeedDTO> lists =  dao.getAllFeed();
	for(FeedDTO dto : lists){
		out.print(dto.toString()+"<br>");
	}

%>

</body>
</html>