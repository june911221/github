function SCRAP(num) {
		var result =confirm("스크랩 하시겠습니까?");
			
			if(result){
			$.ajax({
				type : "post",
				url : "./Scrap.do?table=thema",
				data : {
					number : num
				},
				dataType : "json",
				success : SuccessScrap,
				error : Error
			})
		}
		}
		
		function SuccessScrap(resdata) {
			if (resdata == 1) {
				$("#scrapnum").val("1");
				location.reload();
				alert("스크랩 되었습니다");
			}
		}
		function Error(request, status, error) {
			/*alert("code = " + request.status + " message = "
					+ request.responseText + " error = " + error); // 실패 시 처리
*/		}
		
		$(document).ready(function() {//페이지 로딩시 스크랩유무를 확인하는 함수 실행후 그값을 담아놓은 히든박스에 있는값을 비교하여 스크랩 유무에 따른 액션처리
		$("#scrapnum").val();
		if($("#scrapnum").val()==1){
			$("#scrap").attr("type","hidden");
			$("#scrapdel").attr("type","button");
		}
		else{
			$("#scrap").attr("type","button");
			$("#scrapdel").attr("type","hidden");
		}
		});
		
		function scrapdel(num) {
            var result =confirm("스크랩을 취소 하시겠습니까?");	
            if(result){
            $.ajax({
				type : "post",
				url : "./ScrapDel.do?table=tema&category="+$("#category").val(),
				data : {
					number : num
				},
				dataType : "json",
				success : SuccessScrapDel,
				error : Error
			})
            }
		}		
		
		function SuccessScrapDel(resdata) {
			if (resdata == 1) {
				$("#scrapnum").val("0");
				location.reload();
				alert("스크랩이 취소 되었습니다");
			} 
		}
