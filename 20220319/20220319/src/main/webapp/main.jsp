<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>서블릿에서 넘어왔어요.</h1>
<%
	boolean isSuccess =  (boolean)request.getAttribute("isSuccess");
	if(isSuccess){
		out.print("환영합니다.");
	}else{
		out.print("로그인에 실패했습니다.");
	}
%>
</body>
</html>