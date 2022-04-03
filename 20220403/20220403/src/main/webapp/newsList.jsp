<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
	crossorigin="anonymous"></script>
<title>뉴스관리 앱</title>
</head>
<body>
	<div class = "container w-75 mt-5 mx-auto">
		<h2>뉴스 목록</h2>
		<hr>
		<ul class = "list-gropu">
			<c:forEach items="${newslist}" var="news" varStatus="status">
				<li class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
					<a class="text-decoration-none" href = "news?action=getNews&aid=${news.aid}">[${status.count}] ${news.title}, ${news.date}</a>
					<a href = "news?action=deleteNews&aid=${news.aid}"><span >삭제</span></a>
				</li>
			</c:forEach>
		</ul>
	</div>
</ul>
<hr>
<c:if test="${error != null }">
	<div class="alert alert-danger alert-dismissible fade show mt-3">
		에러발생 :${error}	
		<button type="button" class='btn-close' data-bs-dismiss='alert'></button>	 
	</div>
</c:if>

<button class="btn btn-outline-info mb-3" type="button" data-bs-toggle='collapse' data-bs-target="#addFrom"
 aira-expended='false' aria-controls="addFrom">뉴스등록</button>
<div class="collapse" id ="addFrom">
	<div class="card card-body">
		<form action="news?action=addNews" method="post">
			<label class="form-label">제목</label>
			<input class="form-control" type="text" name="title"><br>
			<label class="form-label">이미지</label>
			<input class="form-control" type="file" name="file"><br>
			<label class="form-label">기사내용</label>
			<textarea class="form-control" rows="5" cols="50" name='content'></textarea><br>
			<button class = 'btn btn-success mt-3' type="submit">저장</button>
		</form>
	</div>
</div>

</body>
</html>