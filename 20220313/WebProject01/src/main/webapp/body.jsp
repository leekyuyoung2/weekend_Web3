<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문서</title>
</head>
<body>

<%@ include file="header.jsp" %>

<h1>
현재시간:
<div id = 'currentDate'></div>
</h1>

<script type="text/javascript" src="js/myColck.js"></script>

<%@ include file="footer.jsp" %>
</body>
</html>