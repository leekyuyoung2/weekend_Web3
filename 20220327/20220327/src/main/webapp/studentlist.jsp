<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
	<th>아이디</th>
	<th>이름</th>
	<th>대학</th>
	<th>생일</th>
	<th>이메일</th>
</tr>
<c:forEach var="s" items="${students}">
	<tr>
	<td>${s.id }</td> 
	<td>${s.USERNAME }</td>
	<td>${s.UNIV }</td>
	<td>${s.BIRTH }</td>
	<td>${s.EMAIL }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>