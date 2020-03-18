/**
 * 
 */
$(document).ready(function() {//게시글 상세보기를 했을때 세션ID값과 작성자ID가 동일하면 히든버튼 활성화 수정 삭제 가능하게 함 함께해요 신청은 블라인드 처리
	
	var today=new Date();//날짜를 가져온다
	var dd=today.getDate();//일
	var mm=today.getMonth()+1;//월
	var yyyy=today.getFullYear();//년
	if(dd<10){
		dd='0'+dd
	}
	if(mm<10){
		mm='0'+mm
	}
	var today=yyyy+"-"+mm+"-"+dd;//년-월-일 로 변수에담는다
	$("#today").val();// 변수로 담는다	

});