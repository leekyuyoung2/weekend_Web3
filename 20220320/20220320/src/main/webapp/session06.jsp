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
	// 초단위
	int minuts = session.getMaxInactiveInterval() / 60;	
%>
세션 유효시간 : <%=minuts %> <br>
세션 유효시간 변경<br>
<%
	session.setMaxInactiveInterval(60*60); // 1시간
	minuts = session.getMaxInactiveInterval() / 60;
%>
세션 유효시간 : <%=minuts %> <br>

</body>
</html>