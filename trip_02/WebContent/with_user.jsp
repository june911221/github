<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>With_user</title>
</head>
<body>
<%
String num=request.getParameter("boardnum");//변수 num에 게시글 글번호를 담아둔다
String pag=request.getParameter("page");//변수 pag에 해당 게시글 페이지를 담아둔다
int limitpeople=Integer.parseInt(request.getParameter("limitpeople"));//해당 게시글의 모집제한 인원수를 변수에 담아둔다
int count=Integer.parseInt(request.getParameter("count"));//현재까지 신청한 신청인원수를 변수에 담아둔다
%>
<form action="WithMePeopleCount.do?boardnum=<%=num%>&page=<%=pag%>" name="countform" onsubmit="return sinchung(<%=limitpeople%>,<%=count%>)"  method="post" target="withmeform">
<select name="peoplecount">
<option value="0" selected>신청인원을 선택해주세요</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
</select>
<input type="text" id="tel" name="tel">
<input type="hidden" id="sessionID" name="sessionID" value="${ID}">
<input type="submit" value="신청">
</form>
<script>
function sinchung(limitpeople,count){ //함꼐해요 신청
	
	var f = document.countform; //form
	people =f.peoplecount.options[f.peoplecount.selectedIndex].value;//form 에 value값을 변수에 지정
	var peoplecount=parseInt(people);//변수 people에 담은 신청인원수는 String타입이므로 Int타입으로 형변화 시켜준다
	var countHap=peoplecount+count;//형변환한 신청인원수와 지금까지 신청인원을 더한다

	if(f.tel.value==""){//연락처 입력란이 공백이면 경고창 출력
		alert("연락처를 입력해주세요");
	    return false;
	}
	
	if(limitpeople<countHap){ //모집제한인원이 신청하려는인원수와 지금까지 신청인원의 합보다 작으면 인원수제한에 걸려 경고창출력
		alert("신청 제한인원이 초과하였습니다");
		return false;
	}
	
	var result =confirm("신청 하시겠습니까?");//신청인원수를 확인하는 if문을 통과하면 신청 컨펌을 한다
	if(result){
		self.close();//신청을 완료한뒤 팝업창은 닫아준다 form에 지정한 target은 부모창의 이름이다
		return true;
	}
	return false;
}
</script>
</body>
</html>