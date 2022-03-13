<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 표현식</title>
</head>
<body>
<%
request.setAttribute("abc", 1500);
%>

<%=request.getAttribute("abc")+"<br>" %>

${requestScope.abc }



</body>
</html>