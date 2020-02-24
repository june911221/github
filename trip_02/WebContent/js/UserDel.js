function del(){
	if($("#password").val()==null||$("#password").val()==""){
		$("#password").focus();
		alert("비밀번호를 입력해주세요");
	}
	else{
		$.ajax({
			type : "post",
			url : "./UserDeleteDB.jsp",
			data : {				
				id : $('#userid').val(),
				password : $('#password').val()
				},
				success : function Success(resdata) {					
						if(resdata==3){
							var result =confirm("정말로 탈퇴 하시겠습니까?");
							if(result){
							$("#x").val(0);
							$("#userDel").attr("action","UserDeleteDB.jsp");
							$("#userDel").submit();
							}else{}
						}
						else{
							alert(resdata);
							$('#password').val("");
							$('#password').focus();
							alert("비밀번호가 다릅니다");
						}
					  },
					error : Error
					});
			}
}	

function Error(request,status,error) {
	alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
}
		