/**
 * 
 */
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