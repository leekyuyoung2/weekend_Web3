<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>필터를 통해 들어온 데이터</title>
</head>
<body>
<p>
<h1>
<c:if test="${error != null }">
${error }
</c:if>

<c:if test="${error == null }">
${name }
</c:if>

</h1>
</p>
</body>
</html>