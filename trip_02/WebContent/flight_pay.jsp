<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS -->
<link rel="stylesheet" href="css/flight_pay.css?ver=1.62">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- JS -->
<script src=js/flight_pay.js></script>

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




	<div id="air_box">
		<section>
			

			<div class="container">
				<div class="menu-steps">

					<div class="btn-step step-1 active-menu">
						Step 1<span> </span>
					</div>
					<div class="btn-step step-2">
						Step 2<span> </span>
					</div>
					<div class="btn-step step-4">
						Step 3<span></span>
					</div>
					<div class="btn-step conclude">
						Step 4<span></span>
					</div>
				</div>

				<!-- 페이지1 -->
				<div id="step-1" class="step-content active">
					<h3>예약내역</h3>
					<form id="question-1">
						<div>

							<h2 class="flight-info">
								<span>출국일 : </span> <span>2020년 2월 12일 (수)</span> <span>서울/인천(ICN)
									<span aria-hidden="true" class="usdot-arrow"> →</span> <span
									class="offscreen">&nbsp;&nbsp;</span>런던(LHR) - 히드로
								</span>
							</h2>

							<colgroup>
								<col style="width: 20%;">
								<col style="width: 24%;">
								<col style="width: 24%;">
								<col style="width: 24%;">
								<col>
							</colgroup>

							<table id="go_table">
								<thead>
									<tr>
										<th scope="col">항공사</th>
										<th scope="col">항공편</th>
										<th scope="col">출발시간</th>
										<th scope="col">도착시간</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>대한항공</td>
										<td class="flight">
											<dl>
												<dt>KE907</dt>
												<dd>
													서울/인천(ICN)<br>→ &nbsp;&nbsp;런던(LHR) - 히드로
												</dd>
											</dl>
										</td>
										<td>13:00</td>
										<td>16:30</td>
									</tr>
								</tbody>
							</table>



							<h2 class="flight-info2">
								<span>귀국일 : </span> <span>2020년 2월 18일 (화)</span> <span>런던(LHR)
									- 히드로<span aria-hidden="true" class="usdot-arrow"> →</span> <span
									class="offscreen">&nbsp;&nbsp;</span>서울/인천(ICN)
								</span>
							</h2>

							<table class="back_table">
								<thead>
									<tr>
										<th scope="col">항공사</th>
										<th scope="col">항공편</th>
										<th scope="col">출발시간</th>
										<th scope="col">도착시간</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>대한항공</td>
										<td class="flight">
											<dl>
												<dt>KE907</dt>
												<dd>
													서울/인천(ICN)<br> → &nbsp;&nbsp;런던(LHR) - 히드로
												</dd>
											</dl>
										</td>
										<td>13:00</td>
										<td>16:30</td>
									</tr>
								</tbody>
							</table>

						</div>
						<div id="ok_text">
							<input type="radio" name="option-1" value="1"> <label>내용을
								확인했습니다.</label>
						</div>

						<input type="button" class="btn-next" name="Next" value="Next"
							disabled="disabled">
					</form>
				</div>

				<!-- 페이지2 -->
				<div id="step-2" class="step-content">
					<h3>예약자 및 탑승자 정보입력</h3>
					<form id="question-2">
						<h4>예약자 정보 입력</h4>
						<table id="re_table">
							<thead>
								<tr>
									<th>예약자명</th>
									<th>이메일</th>
									<th>휴대전화</th>
								</tr>
							</thead>
							<tbody>
								<td><input type="text" placeholder="예) 홍길동"></td>

								<td><input type="text"
									placeholder="예) ForTraveler@tour.com"></td>
								<td><select id="select"><option>010</option>
										<option>011</option>
										<option>016</option>
										<option>017</option></select> -<input type="text" id="text_box_num">-<input
									type="text" id="text_box_num2"></td>
								</tr>
							</tbody>
						</table>

						<h4 id="rider_info">탑승자 정보 입력</h4>
						<table id="re_table2">
							<thead>
								<tr id="rider_tr">
									<th>구분</th>
									<th>영문성</th>
									<th>영문이름</th>
									<th>생년월일</th>
									<th>성별</th>
								</tr>
								<tr id="rider_tr">
							<tbody>
								<td>성인 1</td>
								<td><input type="text" placeholder="예) HONG" name="first_name"></td>
								<td><input type="text" placeholder="예) GILDONG" name="name"></td>
								<td><input type="text" placeholder="예) 19940922" name="birth"></td>
								<td><select><option selected>성별</option>
										<option>남성</option>
										<option>여성</option></select></td>
							</tbody>
						</table>

						<div id="ok_text2">
							<input type="radio" name="option-2" value="1"> <label
								for="">내용을 확인했습니다.</label>
						</div>

						<input type="button" class="btn-back" name="Back" value="Back">
						<input type="button" class="btn-next" name="Next" value="Next"
							disabled="disabled" id="btn-next3">
					</form>
				</div>

				<!-- 페이지3 -->
				<div id="step-3" class="step-content">
					<h3>항공권 금액</h3>

					<form id="question-3">

						<h2 class="flight-info">
							<span>출국일 : </span> <span>2020년 2월 12일 (수)</span> <span>서울/인천(ICN)
								<span aria-hidden="true" class="usdot-arrow"> →</span> <span
								class="offscreen">&nbsp;&nbsp;</span>런던(LHR) - 히드로
							</span>
						</h2>

						<table id="price_table">
							<thead>
								<tr>
									<th>항공료</th>
									<th>제세공과금</th>
									<th>유류할증료</th>
									<th>발권수수료</th>
									<th>총금액</th>
								</tr>
							<tbody>
								<tr>
									<td>588,000 원</td>
									<td>211,000 원</td>
									<td>76,800 원</td>
									<td>10,000원</td>
									<td>885,800 원</td>
								</tr>
							</tbody>
						</table>

						<h2 class="flight-info3">
							<span>귀국일 : </span> <span>2020년 2월 18일 (화)</span> <span>런던(LHR)
								- 히드로<span aria-hidden="true" class="usdot-arrow"> →</span> <span
								class="offscreen">&nbsp;&nbsp;</span>서울/인천(ICN)
							</span>
						</h2>

						<table id="price_table2">
							<thead>
								<tr>
									<th>항공료</th>
									<th>제세공과금</th>
									<th>유류할증료</th>
									<th>발권수수료</th>
									<th>총금액</th>
								</tr>
							<tbody>

								<tr>
									<td>588,000 원</td>
									<td>211,000 원</td>
									<td>76,800 원</td>
									<td>10,000원</td>
									<td>885,800 원</td>
								</tr>
							</tbody>
						</table>

						<div id="ok_text3">
							<input type="radio" name="option-3" value="1"> <label
								for="">내용을 확인했습니다.</label>
						</div>
						<input type="button" class="btn-back" name="Back" value="Back">
						<input type="button" class="btn-next" name="Next" value="Next"
							disabled="disabled" id="btn-next3">
					</form>
				</div>

				<!-- 페이지4 -->
				<div id="step-4" class="step-content">
					<h3>결제확인</h3>
					
			
					
					<div id="pay_box">
						결제사: for traveler<br> 항공명 : ***<br> 항공권 총금액 : ***원
					</div>
					<form id="question-4">
						<div id="payinfo_text">결제수단 선택</div>
						<hr id="line">

						<!-- 결제선택메뉴 -->
						<div class="container">
							<div class="tab-section1">
								<input id="section1" class="sec1" type="radio" name="tab"
									checked="checked" /> <label for="section1">신용카드</label> <input
									id="section2" class="sec1" type="radio" name="tab" /> <label
									for="section2">휴대폰결제</label> <input id="section3" class="sec1"
									type="radio" name="tab" /> <label for="section3">계좌이체</label>
					</form>

					<div id="sec1" class="tab2-content">
						<p>
						<ul id="sub-menu">
							<label id="cardSec">카드선택</label>
							<select name="" id="cardSec2" title="카드선택">
								<option value="">신한카드</option>
								<option value="">국민카드</option>
								<option value="">우리카드</option>
								<option value="">삼성카드</option>
								<option value="">현대카드</option>
							</select>

							<label for="nstallmentSec">할부선택</label>
							<select name="" id="nstallmentSec" title="할부선택">
								<option value="">일시불</option>
								<option value="">2개월</option>
								<option value="">3개월</option>
								<option value="">4개월</option>
								<option value="">5개월</option>
								<option value="">6개월</option>
								<option value="">7개월</option>
								<option value="">8개월</option>
								<option value="">9개월</option>
								<option value="">10개월</option>
								<option value="">11개월</option>
								<option value="">12개월</option>

							</select>
						</ul>


						<div id="cardnum">
							<label>카드번호</label> <input type="text" class='cardno'
								style="width: 50px;"> - <input type="text"
								class='cardno' style="width: 50px;"> - <input
								type="password" class='cardno' style="width: 50px;">- <input
								type="password" class='cardno' style="width: 50px;">

						</div>
						<div id="cvcnum">
							<label>CVC번호</label> <input type="password" />

						</div>

						</p>
					</div>
					<div id="sec2" class="tab2-content">
						<p>
						<ul id="sub-menu" class="menu2">
							<label>휴대폰 번호 : </label>
							<select id="select"><option>010</option>
								<option>011</option>
								<option>016</option>
								<option>017</option></select> -
							<input type="text" id="text_box_num"> -
							<input type="text" id="text_box_num2">


							<select id="T">
								<option>SKT</option>
								<option>LG</option>
								<option>KT</option>
							</select>

							<div id="birth">
								<label>가입자 주민번호 : </label> <input type="text" id="birth_text" />
								- <input type="password" id="birth_text" />
							</div>

							<div id="number">
								<label>휴대폰 인증번호:</label> <input type="text" id="in_num" />
								<button onClick="return pop()" id="go">인증번호 받기</button>
							</div>



						</ul>
						</p>
					</div>
					<div id="sec3" class="tab2-content">
						<p>
						<ul id="sub-menu">

							<div id="bank_name">
								<label>입금 은행 : </label> <select id="bank">
									<option>신한은행</option>
									<option>국민은행</option>
									<option>우리은행</option>
									<option>농협</option>
									<option>하나은행</option>
								</select>
							</div>

							<div id="name">
								<label>입금자 명 : </label> <input type="text" id="name_text" />
							</div>

							<div id="bank_num">
								<label>입금계좌번호 :</label> <input type="text" id="banknum_show">
							</div>
						</ul>
						</p>
					</div>


					<div id="ok_text4">
						<input type="radio" name="option-4" value="1"> <label
							for="">내용을 확인했습니다.</label> <input type="button" class="btn-back"
							id="btn-back4" name="Back" value="Back"> <input
							type="button" class="btn-next" id="btn-next4" name="Next"
							value="Next" disabled="disabled">
					</div>
				</div>
			</div>
	</div>
	</form>
	</div>


	<div id="conclude-last" class="step-content">
		<h3>항공권 결제 완료</h3>
		<form id="form-conclude">
			<div id="pay_ok">항공권이 결제완료되었습니다.</div>

			<div id="text_box">
				<br> E-Ticket 발송은 예약 확인 후부터 영업일 기준 1-3일 이내에 발송됩니다. 이후에도 티켓을 받지
				못하신 경우에는<br>Q&A 게시판을 이용해주시기 바랍니다. <br> <br> E-Ticket이
				발행되면 ForTraveler 공식 메일을 통해 발송됩니다. 예약 시 입력해주신 메일 주소로 티켓을 확인해주세요.<br>
				메일을 받지 못 했을 경우, 스팸 메일함도 확인 부탁드립니다. <input type=button value="메인으로 돌아가기"
					class="main_back" onclick="location.href='index.jsp'" />

			</div>

		</form>


	</div>
	</div>
	</section>
</body>
</html>
