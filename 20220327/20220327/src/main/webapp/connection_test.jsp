<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
	// JDBC 드라이버 로드
	Class.forName("org.h2.Driver");
	// DB 에 접속
	String url = "jdbc:h2:~/test";
	String user = "sa";
	String password = "admin1234";
	Connection conn =  DriverManager.getConnection(url, user, password);
	if(conn != null){
		out.print("접속에 성공했습니다.");
		conn.close();
	}
	else
		out.print("접속에 실패했습니다.");
	
	
%>

</body>
</html>