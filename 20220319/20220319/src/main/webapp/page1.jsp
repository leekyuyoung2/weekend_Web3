<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
페이지 넘김
	<%
		request.setAttribute("name", "홍길동");
		pageContext.forward("page2.jsp");
	%>
</body>
</html>