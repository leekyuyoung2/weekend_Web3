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
	/* boolean isSuccess =  (boolean)request.getAttribute("isSuccess");
	if(isSuccess){
		out.print("환영합니다.");
	}else{
		out.print("로그인에 실패했습니다.");
	} */	
	Cookie[] cookies =  request.getCookies();
	boolean isSuccess = false;
	for(Cookie c : cookies){
		if(c.getName().equals("id")){
			out.print(c.getValue() + "님 반갑습니다.<br>");
			out.print("로그인 성공<br>");
			isSuccess = true;
			break;
		}
	}
	if(!isSuccess){
		out.print("로그인에 실패했습니다.<br>");
	}
%>
	<p><a href="logout">로그아웃</a>

</body>
</html>