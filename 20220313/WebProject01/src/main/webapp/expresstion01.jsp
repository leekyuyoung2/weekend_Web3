<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	setInterval(() => {		
		let gr = document.querySelector("#currentDate")
		let currentDate = new Date();
		let displayDate = currentDate.getFullYear() + "-";		
		if(currentDate.getMonth()+1<10)
			displayDate += "0" + (currentDate.getMonth()+1) + "-";
		else
			displayDate += currentDate.getMonth()+1 + "-";
		
		if(currentDate.getDate()<10)
			displayDate += "0"+currentDate.getDate() + " ";
		else
			displayDate += currentDate.getDate() + " ";
		
		displayDate += currentDate.getHours() + ":";
		displayDate += currentDate.getMinutes() + ":";
		displayDate += currentDate.getSeconds();
		gr.innerHTML = displayDate
	}, 1000);
</script>
</head>


<body>
	<h1>Today's date :</h1>
	<p id="currentDate"></p>	
</body>


</html>