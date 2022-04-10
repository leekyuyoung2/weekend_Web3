<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<%
Cookie[] cookies =  request.getCookies();
String cookieLoginID="";
for(Cookie c : cookies){
	if("cookieLoginId".equals(c.getName())){
		cookieLoginID = c.getValue();
	}
}
String tryLoginId = (String)request.getAttribute("id");
// 전에 로그인한 정보를 기록한 쿠키가 있고.. 로그인시도를 하지 않았다면
if(!cookieLoginID.isEmpty() && tryLoginId == null){
	request.setAttribute("id", cookieLoginID);
}
%>
<body>
	<c:if test="${sessionid == null}">
		<form action="login" method="post">
			<p>
				아이디:<input type="text" name='id' value="${id }">
			</p>
			<p>
				패스워드:<input type="text" name='password'>
			</p>
			<p>
				<input type="checkbox" name="idcheck" >아이디 저장
			</p>
			<p>
				<input type="submit" value="로그인">
			</p>
		</form>
	</c:if>
	<c:if test="${sessionid != null}">
		<form action="logout" method="post">
			<p>
				<input type="submit" value="로그아웃">
			</p>
		</form>
	</c:if>
	
	<div>
		<c:if test="${error != null}">
			<h2>${error }</h2>
		</c:if>
	</div>
</body>
</html>