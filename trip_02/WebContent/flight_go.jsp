<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <!-- CSS -->
 <link rel="stylesheet" href="css/flight_go.css?ver=1.1">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<%
	request.setCharacterEncoding("UTF-8");
%>
 
</head>
<body>

	<%
		String ses = null;
		ses = (String) session.getAttribute("ID");
		if (ses == null) {
	%>
	<jsp:include page="header.jsp" />
	<%
		} else {
	%>
	<jsp:include page="Loginheader.jsp" />
	<%
		}
	%>
	

	
	<script>
$(function(){
	$('#decreaseQuantity').click(function(e){
	e.preventDefault();
	var stat = $('#numberUpDown').text();
	var num = parseInt(stat,10);
	num--;
	if(num<=0){
	alert('최소 인원수는 1명이상입니다.');
	num =1;
	}
	$('#numberUpDown').text(num);
	});
	$('#increaseQuantity').click(function(e){
	e.preventDefault();
	var stat = $('#numberUpDown').text();
	var num = parseInt(stat,10);
	num++;

	if(num>8){
	alert('최대 인원수는 8명입니다.');
	num=8;
	}
	$('#numberUpDown').text(num);
	});
	});

</script>

<script>
$(document).ready (function () {

    //탭(ul) onoff
    $('.tab-wrapper>.jq_cont').children().css('display', 'none');
    $('.tab-wrapper>.jq_cont div:first-child').css('display', 'block');
    $('.tab-wrapper>.jq_tab li:first-child').addClass('on');
    $('.tab-wrapper').delegate('.jq_tab>li', 'click', function() {
        var index = $(this).parent().children().index(this);
        $(this).siblings().removeClass();
        $(this).addClass('on');
        $(this).parent().next('.jq_cont').children().hide().eq(index).show();
    });
});
</script>





	<section>
	
<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet"
			href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
			type="text/css" />

		<script
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
		<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
		<!-- js -->
		<script language="JavaScript" src="js/index.js" charset="UTF-8"></script>

		
		<img src="img/UK_banner.png">
	<div id="air_box"> 
	
	<!-- 라디오버튼 -->

	<label class="box-radio-input">
	<%
String s=request.getParameter("cp_item");
if(s.equals("왕복")){
%>	
	<input type="radio" id="cp_item1" name="cp_item1" value="옵션1" checked="checked"><span>왕복</span>
	</label>
    <label class="box-radio-input">
    <input type="radio" id="cp_item2" name="cp_item2" value="옵션2"><span>편도</span>
  </label>
 <%} else{%>
 
	<input type="radio" id="cp_item1" name="cp_item1" value="옵션1" ><span>왕복</span>
	</label>
    <label class="box-radio-input">
    <input type="radio" id="cp_item2" name="cp_item2" value="옵션2" checked="checked"><span>편도</span>
  </label>
  <%} %>
    
    <!-- 인원수 증감-->
    <h2 id="h2_text">인원수</h2>
    <div id="count_number">
    <a herf="#" id="decreaseQuantity"><img src="img/minus.png" width="40px;" height="40px;"></a>
    <span id="numberUpDown"><%=request.getParameter("number")%></span>
    <a herf="#" id="increaseQuantity"><img src="img/plus.png" width="40px;" height="40px;"></a>
    </div>
    
     <!-- 좌석등급-->
         <h2 id="h2_text2">좌석등급</h2>
    <label class="box-radio-input2">
    <%
String seat=request.getParameter("seat_item");
 
if(seat.equals("옵션1")){
%>	
	<input type="radio" name="seat_item" value="옵션1" checked="checked"  id="seat1"><span>이코노미</span>
	
	</label>
    <label class="box-radio-input2">
    <input type="radio" name="seat_item" value="옵션2"  id="seat2"><span>비즈니스</span>
    </label>
    <label class="box-radio-input2">
    <input type="radio" name="seat_item" value="옵션3"  id="seat3"><span>퍼스트</span>
    </label>
 <%}else if(seat.equals("옵션2")){ %>
 
 <input type="radio" name="seat_item" value="옵션1" id="seat1"><span>이코노미</span>
	</label>
    <label class="box-radio-input2">
    <input type="radio" name="seat_item" value="옵션2"  id="seat2" checked="checked"><span>비즈니스</span>
    </label>
    <label class="box-radio-input2">
    <input type="radio" name="seat_item" value="옵션3"  id="seat3"><span>퍼스트</span>
    </label>
   <%}else{ %>
    <input type="radio" name="seat_item" value="옵션1" id="seat1"><span>이코노미</span>
	</label>
    <label class="box-radio-input2">
    <input type="radio" name="seat_item" value="옵션2"  id="seat2"><span>비즈니스</span>
    </label>
    <label class="box-radio-input2">
    <input type="radio" name="seat_item" value="옵션3"  id="seat3" checked="checked"><span>퍼스트</span>
    </label>
    <%} %>
       
              
    <div id = "text_section">     
    <input id="autocomplete" type="text" placeholder="출발지를 입력하세요" value=<%=request.getParameter("autocomplete")%>/>
		<br>
		<br>
		<br>
		
		<input id="autocomplete2" type="text" placeholder="목적지를 입력하세요" value=<%=request.getParameter("autocomplete2")%>/>
		
		<input class="dal" type="text" placeholder="출발일을 선택하세요" id="testDatepicker" value=<%=request.getParameter("dal")%>>
		<input class="dal2" type="text" placeholder="도착일을 선택하세요" id="testDatepicker2" value=<%=request.getParameter("dal2")%>>
		<button class="pressDown">
		GO
		</button>
		</div>
	</div>
	
	<!-- 탭메뉴 -->
	<div class="tab-wrapper comm_tab1">
  <!-- 1단 탭메뉴  -->         
  <ul class="jq_tab tab_menu">
    <li>가는날</li>
    <li>오는날</li>
  </ul>
  <!--// 1단 탭메뉴  --> 

  <!-- 1단 탭 내용  -->  
  <div class="jq_cont tab_cont">
    <!--  탭1 -->
    <div class="cont">                                                                           
      <div class="tab-wrapper comm_tab2">
      
      <!-- 안내사항 -->
      <ul class="section-text-block">
      <li class="txt-belt">운항 편명 및 출발일자가 변경된 경우, 
      <span>'최초 스케줄상의 운항 편명과 출발일자'</span>로 조회하시기 바랍니다.</li>
      <li class="txt-belt">항공편 출도착 정보는 D-30일부터 D+1일, 총 32일간 조회 가능합니다.</li>
      <li class="txt-belt">해당항공사 항공편에 한하여 출도착 조회가 가능하며, 공동운항편의 출도착 정보는 홈페이지에서 조회되지 않으므로 해당 항공사 홈페이지에서 조회하시기 바랍니다. </li>
       </ul>
      <!-- 날짜와 항공편문구 -->
      
          
          <!-- 라디오버튼1 -->
      <fieldset class="options">
		
		<h2 class="flight-info">
          <span>2020년 2월 12일 (수)</span>    
          <span>서울/인천(ICN) <span aria-hidden="true" class="usdot-arrow"> → </span> 
          <span class="offscreen">&nbsp;&nbsp;</span> 런던(LHR) - 히드로  </span>
          </h2>
         
		<ul>
	<input type="radio" id="air_radio1" name="air_radio" value="1">
	
			<table class="start_table">
      
      <colgroup> 
      <col style="width: 15%;">
      <col style="width: 24%;">
      <col style="width: 24%;">
      <col style="width: 24%;">
      <col>
      </colgroup>
      
      <thead>
      <tr>
      <th scope="col">항공사</th>
      <th scope="col">항공편</th>
      <th scope="col">출발시간</th>
      <th scope="col">도착시간</th>
      <th scope="col">항공운임료</th>
      </tr>
      </thead>
      
      <tbody>
      <tr>
      <th scope="row">대한 항공</th>
      <td class="flight">
      <dl><dt>KE907 </dt><dd>서울/인천(ICN)<br><span aria-hidden="true"> →
       &nbsp;&nbsp;런던(LHR) - 히드로 </dd>
      </dl></td><td>13:00
      </td><td>16:30</td><td> 
      <div>885,800</div></td></tr>
      </tbody>
      </table>
      </label></li>    
      
      <!-- 라디오버튼2 -->
      	<input type="radio" id="air_radio2" name="air_radio" value="2"> 
      	
      	 <table class="start_table2">
      
      <colgroup> 
      <col style="width: 15%;">
      <col style="width: 24%;">
      <col style="width: 24%;">
      <col style="width: 24%;">
      <col>
      </colgroup>
      
      <thead>
      <tr>
      <th scope="col">항공사</th>
      <th scope="col">항공편</th>
      <th scope="col">출발시간</th>
      <th scope="col">도착시간</th>
      <th scope="col">항공운임료</th>
      </tr>
      </thead>
      
      <tbody>
      <tr>
      <th>아시아나 항공</th>
      <td class="flight">
      <dl><dt>OZ521 </dt><dd>서울/인천(ICN)<br> → 
     &nbsp;&nbsp;런던(LHR) - 히드로 </dd>
      </dl></td><td>14:30
      </td><td>18:00</td><td> 
      <div>940,700</div></td></tr>
     </tbody>
      </table>
      </label></li>
      </ul>
      
      <div id="pay">
      <h3>항공권 금액</h3>
      
      <div id="pay_list">
      
      <div id = "fare">항공료 : 588,000원 </div> 
      <div id = "tax">제세공과금 : 211,000원 </div> 
      <div id = "oil">유류할증료 : 76,800원 </div>
      <div id = "tictax">발권수수료 : 10,000원 </div>
      <div id="all">총 금액 : 885,800원 </div>
      <input type=button class="myButton" value="항공권 결제" onclick="location.href='flight_pay.jsp'"/>   
      </div>
      
      
      </div>
      </fieldset>
      </div>
    </div>
    
    
    <!-- 탭2  -->  
    <div class="cont">
     <!-- 안내사항 -->
      <ul class="section-text-block">
      <li class="txt-belt">운항 편명 및 출발일자가 변경된 경우, 
      <span>'최초 스케줄상의 운항 편명과 출발일자'</span>로 조회하시기 바랍니다.</li>
      <li class="txt-belt">항공편 출도착 정보는 D-30일부터 D+1일, 총 32일간 조회 가능합니다.</li>
      <li class="txt-belt">해당항공사 항공편에 한하여 출도착 조회가 가능하며, 공동운항편의 출도착 정보는 홈페이지에서 조회되지 않으므로 해당 항공사 홈페이지에서 조회하시기 바랍니다. </li>
       </ul>
      <!-- 날짜와 항공편문구 -->
      
          
          <!-- 라디오버튼1 -->
      <fieldset class="options">
		
		<h2 class="flight-info">
          <span>2020년 2월 18일 (화)</span>    
          <span>런던(LHR) - 히드로  <span> → </span> 
          <span>&nbsp;&nbsp;</span>서울/인천(ICN)</span>
          </h2>
         
		<ul>
			<input type="radio" id="air_radio3" name="air_radio">
			
			<table class="start_table">
     
      <colgroup> 
      <col style="width: 15%;">
      <col style="width: 24%;">
      <col style="width: 24%;">
      <col style="width: 24%;">
      <col>
      </colgroup>
      
      <thead>
      <tr>
      <th scope="col">항공사</th>
      <th scope="col">항공편</th>
      <th scope="col">출발시간</th>
      <th scope="col">도착시간</th>
      <th scope="col">항공운임료</th>
      </tr>
      </thead>
      
      <tbody>
      <tr>
      <th scope="row">대한 항공</th>
      <td class="flight">
      <dl><dt>KE907 </dt><dd>런던(LHR) - 히드로<br>→
       &nbsp;&nbsp;서울/인천(ICN) </dd>
      </dl></td><td>13:00
      </td><td>16:30</td><td> 
      <div>885,800</div></td></tr>
      </tbody>
      </table>
      </label></li>    
      
      <!-- 라디오버튼2 -->
      <input type="radio" id="air_radio4" name="air_radio">
      
      	 <table class="start_table2">
      
      <colgroup> 
      <col style="width: 15%;">
      <col style="width: 24%;">
      <col style="width: 24%;">
      <col style="width: 24%;">
      <col>
      </colgroup>
      
      <thead>
      <tr>
      <th scope="col">항공사</th>
      <th scope="col">항공편</th>
      <th scope="col">출발시간</th>
      <th scope="col">도착시간</th>
      <th scope="col">항공운임료</th>
      </tr>
      </thead>
      
      <tbody>
      <tr>
      <th>아시아나 항공</th>
      <td>
      <dl><dt>OZ521 </dt><dd>런던(LHR) - 히드로<br>→
       &nbsp;&nbsp;서울/인천(ICN) </dd>
      </dl></td><td>14:30
      </td><td>18:00</td><td> 
      <div>940,700</div></td></tr>
     </tbody>
      </table>
      </label></li>
      </ul>
      
      <div id="pay">
      <h3>항공권 금액</h3>
      
      <div id="pay_list">
      
      <div id = "fare">항공료 : 588,000원 </div> 
      <div id = "tax">제세공과금 : 211,000원 </div> 
      <div id = "oil">유류할증료 : 76,800원 </div>
      <div id = "tictax">발권수수료 : 10,000원 </div>
      <div id="all">총 금액 : 885,800원 </div>
      <input type=button class="myButton" value="항공권 결제" onclick="location.href='flight_pay.jsp'"/>   
      </div>
      </div>
      </fieldset>
    </div>
  </div>
  
</div>
</div>
	
	</section>
</body>
</html>
