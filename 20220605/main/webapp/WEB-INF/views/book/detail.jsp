<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세정보</title>
</head>
<body>
<h1>상세</h1>
<p>제목 : ${data.title}</p>
<p>카테고리 : ${data.category}</p>
<p>가격 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${data.price}"/>원 </p>
<p>입력일 :<fmt:formatDate value="${data.insert_date}" pattern="yyyy.MM.dd HH:mm:ss"/>  </p>
</body>
</html>