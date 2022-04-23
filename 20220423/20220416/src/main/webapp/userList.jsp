<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.cj.jdbc.Driver"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저리스트</title>
</head>
<body>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn 
	=  DriverManager.getConnection("jdbc:mysql://localhost:3306/mysns?serverTimezone=UTC",
	"root","admin1234");
	String sql = "select * from user";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs =  pstmt.executeQuery();	
	out.print("가입자 리스트");
	while(rs.next()){
		String id = rs.getString("id");
		String name = rs.getString("name");
		String ts = rs.getTimestamp("ts").toString();
		out.print("<br><hr>");
		String str = String.format("%s %s %s", id, name, ts);
		out.print(str);
	}
	rs.close();pstmt.close();conn.close();
%>
</body>
</html>