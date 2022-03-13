<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Count</title>
</head>
<body>
	<%!int count = 0;	%>
	<h1>
		Page count is :
		<%=++count%>
	</h1>
</body>
</html>

<!--
jsp - .java 형태의 servlet 코드로 변환된다.
이때 실행되는 java code는 _jspService() 메소드 안에서 실행된다.
즉...  페이지를 부르면(실행하면) _jspService() 메소드를 실행하는 것과 동일

 -->