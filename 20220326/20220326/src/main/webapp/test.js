/**
 * 
 */

document.addEventListener('DOMContentLoaded', function() {
	let buttons = document.querySelectorAll("#button")
	for (var i = 0; i < buttons.length; i++) {
		buttons[i].addEventListener('click', function() {
			console.log(this.innerHTML);			
			var time = this.innerHTML //  00:00
			var getTime = time.substring(0,2);
			var getMinuts = time.substring(3,time.length);
			
			// 현재시간 
			var currentDate = new Date();
			// 버튼기준 시간
			var year =  currentDate.getUTCFullYear();
			var month = currentDate.getMonth();
			var day = currentDate.getDate();
			var compareDate =  new Date(year,month,day,getTime,getMinuts)
			
			if(currentDate > compareDate){ // 지난 시간
				this.disabled =true; 
			}else{ 
				this.style.backgroundColor = 'blue';
			}
		});
	}
});
