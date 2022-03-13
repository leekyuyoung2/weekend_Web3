<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러</title>
</head>
<body>
<p><h1>알수 없는 에러가 발생했습니다.</h1></p>
<p><h3>
계속될 경우 관리자에게 문의하세요<br>
<%=exception.getMessage() %>
</h3></p>
<%
// exception 이란느 에러관리 내장객체는 페이지의 isErrorpage 속성이 true 가 되어야만 생긴다(사용할수 있다)
	//exception.printStackTrace(new PrintWriter(out));
	//out.print(exception.getMessage());
%>


</body>
</html>