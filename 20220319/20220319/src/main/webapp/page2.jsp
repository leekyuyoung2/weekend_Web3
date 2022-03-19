<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = request.getAttribute("name").toString();
%>
<h1>page1에서 넘어온 데이터</h1><br>
<%=name %>
</body>
</html>