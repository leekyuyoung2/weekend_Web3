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
	String id =  request.getParameter("id");
	String password =  request.getParameter("password");
	if(id.equals("admin") && password.endsWith("admin1234")){
		session.setAttribute("id", id);
		session.setAttribute("password", password);
		out.print("세션 설정이 성공했습니다.<br>");
		out.print(id + " 님 환영합니다.");
	}else{
		out.print("세션 설정에 실패했습니다.");
	}
%>
</body>
</html>