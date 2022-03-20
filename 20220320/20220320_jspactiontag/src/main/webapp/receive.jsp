<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>jsp action tag인 param을 통해서 전달 받은 값
	<%=URLDecoder.decode(request.getParameter("name")) %> 
</body>
</html>