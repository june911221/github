<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="vo.BoardDto"%>
<!DOCTYPE html>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/Hugi.css?ver=1.2">
<html>
<head>
<meta charset="UTF-8">
<title>InfoandTip</title>
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


	<section>

		<table class="sub_news" border="1" cellspacing="0">
			<caption>정보 & TIP</caption>
			
			<!--     SIDE AREA -->
			<div class="sideArea">

				<ul class="sideMenu">
					<li><a href="WithMe.do" class="has-submenu"><span
							class="fa fa-table"></span>함께해요</a></li>
					<li><a href="infoandtip.my?command=list&category=hugi"><span
							class="fa fa-sitemap"></span>여행후기</a></li>
					<li><a href="infoandtip.my?command=list&category=infoandtip"><span
							class="fa fa-money"></span>정보&팁</a></li>
					<li><a href="infoandtip.my?command=list&category=qa"><span
							class="fa fa-user-o"></span>Q&A</a></li>

				</ul>
			</div>
			<!--     SIDE AREA -->

			<!--banner -->

			<img id="hugi_banner" src="img/hugi_banner.jpg" width="100%"
				height="300">
			<img id="hugi_banner2" src="img/thum.jpg" width="55%" height="300">

			<!--banner -->

			<h2 id="id">정보 & TIP</h2>
			<hr>

			<input type="button" onclick="writepage()" id="btnwrite" value="글쓰기" />
			<div id="scbox">
				<form action="Hugi.jsp" onsubmit="return search()" method="post">
					<select class="sel" name="Boardselectmenu" id="Boardselectmenu">
						<option id="op" value="none" selected>전체</option>
						<option id="op" value="title_contents">제목+내용</option>
						<option id="op" value="title">제목</option>
						<option id="op" value="contents">내용</option>
						<option id="op" value="writer">작성자</option>
					</select> <input type="text" value="" name="searchinfo" id="searchinfo">
					<input id="search" type="submit" value="검색">
			</div>

			<thead>
				<tr>
					<th width="40px;">글번호</th>
					<th width="40px">카테고리</th>
					<th width="150px;">제목</th>
					<th width="70px;">글쓴이</th>
					<th width="50px;">날짜</th>
					<th width="50px;">조회수</th>
				</tr>
			</thead>
			<%
				ArrayList<BoardDto> list = (ArrayList<BoardDto>) request.getAttribute("data");
				out.print("<input type='hidden' id=size value=" + list.size() + ">");
				for (int i = 0; i < list.size(); i++) {
					out.print("<tr id='tr_hover'><td>" + list.get(i).getNum() + "</td>");
					out.print("<td>" + list.get(i).getCategory() + "</td>");
					out.print("<td><label class='newimg' id='newimg" + i
							+ "'>new</label><a href='BoardView.my?command=view&num=" + list.get(i).getNum() + "&hits="
							+ list.get(i).getHits() + "'>" + list.get(i).getTitle() + "</a></td>");
					out.print("<td>" + list.get(i).getWriter() + "</td>");
					out.print("<td>" + list.get(i).getDate() + "</td>");
					out.print("<td>" + list.get(i).getHits() + "</td>");
					out.print("<input type='hidden' id='date" + i + "' value='" + list.get(i).getDate() + "'>");//hidden타입에 value값으로 날자를 넣어 스크립트에서 비교하기
				}
			%>
			<input type="hidden" value="${ID}" id="sessioncheck" />
		</table>


		<script>
			function writepage() {//session 을 ID가sessionchek인 input hidden박스에 value값으로 넣어주고 값 을 비교하여 로그인과 비로그인 구별하여 글쓰기제한둠
				var sessioncheck = $("#sessioncheck").val();
				var check = "null";
				var check2 = "";
				if (sessioncheck == check || sessioncheck == check2) {
					alert("로그인이 필요합니다.");
				} else {
					location.href = "BoardWrite.jsp";
				}
			}

			$(document).ready(function() {//현재날짜와 게시글작성일을 비교해서 new출력
				var today = new Date();//날짜를 가져온다
				var dd = today.getDate();//일
				var mm = today.getMonth() + 1;//월
				var yyyy = today.getFullYear();//년
				if (dd < 10) {
					dd = '0' + dd
				}
				if (mm < 10) {
					mm = '0' + mm
				}
				var today = yyyy + "-" + mm + "-" + dd;//년-월-일 로 변수에담는다
				var size = $("#size").val();//list사이즈를 변수로 담는다

				for (var i = 0; i < size; i++) {//list사이즈만큼 for문을 돌린다
					if (today == $("#date" + i).val())//현재날짜와 hidden에 담긴 작성일을 비교해서 일치하면 new출력
						$("#newimg" + i).css("display", "block");
				}
			});
		</script>
	</section>
</body>
</html>