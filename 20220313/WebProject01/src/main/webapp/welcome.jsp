<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"></meta>
<title>Welcome</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"> -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"></link>
</head>
<body>
<%!
	String greeting = "Welcome to Web Shopping Mall";
	String tagline = "Welcome to Web Market";
%>


<nav class="navbar navbar-expand navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="./welcome.jsp">Home</a>
		</div>
	</div>
</nav>

<%-- <div class="jumbotron">
	<div class="container">
		<h1 class="display-3">
			<%=greeting %>
		</h1>
	</div>
</div> --%>

<div class="container  bg-gradient bg-gradient">
	<div class="row justify-content-md-center">
	<div class="col-md-auto">
      <%=greeting %>
    </div>
	</div>
	
</div>

<div class="container">
	<div class="text-center">
		<h3><%=tagline %></h3>	
	</div>
</div>
	<footer class="container">
		<p>&copy; WebMarket</p>
	</footer>	
</body>
</html>