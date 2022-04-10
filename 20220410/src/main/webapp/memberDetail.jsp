<%@ page language="java" contentType="text/html; charset=UTF-8"    
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보페이지</title>
</head>
<%
	// 필터로 대처함
	/* if(session.getAttribute("sessionid") == null){		
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	} */
%>
<body>	
	<c:if test="${not empty sessionid}">
		<h2>${sessionid }님 환영합니다.</h2>
		<form action="logout" method="post">
			<p>
				<input type="submit" value="로그아웃">
			</p>
		</form>
	</c:if>		
</body>
</html>