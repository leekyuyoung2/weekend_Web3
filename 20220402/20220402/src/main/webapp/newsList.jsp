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
<h2>뉴스목록</h2>
<ul>
<c:forEach items="${newslist}" var="news" varStatus="status">
	<li>
	<a href = "news?action=getNews&aid=${news.adi}">[${status.count}] ${news.title}, ${news.date}</a>
	<a href = "news?action=deleteNews&aid=${news.adi}">삭제</a>
	</li>
</c:forEach>
<c:if test="${error != null }">
	<div>
		에러발생 :${error}		 
	</div>
</c:if>
</ul>
<button >뉴스등록</button>
<div>
<form action="news?action=addNews" method="post">
<label>제목</label>
<input type="text" name="title"><br>
<label>이미지</label>
<input type="file" name="file"><br>
<label>기사내용</label>
<textarea rows="5" cols="50" name='content'></textarea><br>
<button type="submit">저장</button>
</form>
</div>

</body>
</html>