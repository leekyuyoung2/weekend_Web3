<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세정보</title>
</head>
<body>
	<h2>상품정보 조회</h2>
	<hr>
	<ul>
		<li>상품코드 : ${info.id }</li>
		<li>상품명 : ${info.name }</li>		
		<li>제조사 : ${info.maker }</li> 
		<li>가격 : ${info.price }	</li> 
		<li>등록일 :${info.date } </li>
		</ul>
</body>
</html>