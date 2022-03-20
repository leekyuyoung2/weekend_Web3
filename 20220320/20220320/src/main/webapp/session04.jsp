<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>세션 삭제 
<%
	String id = (String)session.getAttribute("id");	
	String password = (String)session.getAttribute("password");
	
	session.removeAttribute("id");
	
	id = (String)session.getAttribute("id");
	out.print(String.format("<p>세션 삭제후 id의 값 : %s", id) );
%>
</body>
</html>