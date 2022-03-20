<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="date" class="java.util.Date" scope="request">
		오늘의 날자 및 시각 : <%=date %>
	</jsp:useBean>
	
	<jsp:useBean id="member" class="bean.Member" />
	<%
		member.setName("홍길동");
		member.setId("admin");
		member.setPassword("admin1234");
	%>
	
<br>이름은 : <%=member.getName() %><br>	
아이디 : <%=member.getId() %><br>
패스워드 : <%=member.getPassword() %><br>


</body>
</html>