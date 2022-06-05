<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 제목</title>

<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
 /* pageing 관련 */
.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
}
</style>

</head>


<body>
<form>
	<input type="text" placeholder="검색어를 입력하세요" name="keyword" value="${keyword }">
	<input type="submit" value="검색">	
</form>
	<p>
		<a href="/book/create">생성</a>	  
	</p>
	<table>
	  <tr>
	    <th>제목</th>
	    <th>카테고리</th>
	    <th>가격</th>
	    <th></th>
	  </tr>
	<c:forEach items="${dataList }" var="book">	
		<tr>
	    <td>${book.title}</td>
	    <td>${book.category}</td>
	    <td><fmt:formatNumber type="number" 
	    	maxFractionDigits="3" value="${book.price}"/>원
	    </td>
	    <td>
	    	<a href="/book/update?bookId=${book.book_id}">수정</a>	    	
	    	<a href="/book/delete?book_id=${book.book_id}">삭제</a> 
	    </td>	     
	  </tr>
	</c:forEach>    
	</table>
	<div class="pagination">
	  <a href="#">&laquo;</a>
	  <a href="#">1</a>
	  <!-- <a class="active" href="#">2</a> -->
	  <a href="/book/list?page=10">2</a>
	  <a href="/book/list?page=20">3</a>
	  <a href="/book/list?page=30">4</a>
	  <a href="/book/list?page=40">5</a>
	  <a href="/book/list?page=50">6</a>
	  <a href="">&raquo;</a>
	</div>
</body>
</html>