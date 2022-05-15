/**
 * 자바스크립트 유틸리티 함수 
 */
 
 var AJAX = {
	call:function(url,param,func,isfd){
		var callobj ={			
			url:url,
			type:"post",
			data:param,
			dataType:"text",
			success:func,
			error:function(xhr, status, error){
				console.log(xhr);
				console.log(status);
				console.log(error);
				if(xhr.status == 0){
					alert("네트웍 접속이 원할하지 않습니다.");
				}else{
					console.log(xhr.responseText);
					alert("에러가 발생했습니다. 관리자에게 문의해 주세요");
				}
			},
		};
		if(isfd){
			callobj.processData = false;
			callobj.contentType = false;
		}		
		jQuery.ajax(callobj);
	},	
	test:function(){
		alert("테스트 함수 입니다.")
	}
};  // end of AJAX

// 호출 방법은 Page.init()
var Page = {
	init:function(cbfunc){
		AJAX.call("../jsp/session.jsp",null,function(data){
			var id = data.trim();
			if(id == 'null'){
				alert("로그인이 필요한 서비스 입니다.");
				window.location.href = "login.html";
			}else{
				if(cbfunc != null) cbfunc(id);
			}
		});
	}
}

