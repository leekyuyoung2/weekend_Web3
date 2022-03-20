<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="member" class="bean.Member" scope="request"/>
<jsp:setProperty property="id" name="member" value="admin"/>  <!-- setItd() -->
<jsp:setProperty property="password" name="member" value="admin123"/>
<jsp:setProperty property="name" name="member" value="홍길동"/>

아이디: <jsp:getProperty property="id" name="member"/> <br>
패스워드: <jsp:getProperty property="password" name="member"/><br>
이름: <jsp:getProperty property="name" name="member"/><br>
</body>
</html>