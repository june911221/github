<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="vo.Food_placeDto"%>
<%@ page import="dao.Food_placeDao"%>
<%@ page import="java.util.ArrayList"%>
<jsp:useBean id="user" class="dao.Food_placeDao" />
<%

ArrayList<Food_placeDto> view= (ArrayList<Food_placeDto>)user.Food_placeDto();
out.println(view.size());
for(int i =0 ; i<view.size(); i++)
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>명소</title>
<link rel="stylesheet" href="css/place.css?ver=1.5">
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

		<div class="mainbox">
			<img src="img/08.jpg" width="100%" height="500" />
		</div>
		<div class="container">

			<!--     SIDE AREA -->
			<div class="sideArea">


				<ul class="sideMenu">
					<li><a href="CitySel.jsp" class="has-submenu"><span
							class="fa fa-table"></span>도시</a></li>
					<li><a href="thema.jsp"><span class="fa fa-sitemap"></span>테마</a></li>
					<li><a href="place.jsp"><span class="fa fa-money"></span>명소</a></li>
					<li><a href="food.jsp"><span class="fa fa-user-o"></span>맛집</a></li>

				</ul>
			</div>
			<!--     SIDE AREA -->

		</div>
		</div>



		<h2 id="id">명소 BEST</h2>
		<br>
		<br>
		<hr>

		<!-- 검색창 -->
		<div id="searchbar">
			<input type="text" placeholder="검색할 도시를 입력하세요.">
			<button>검색</button>
		</div>

		<ul id="sub-menu">
			<li id="list2">
				<div class="wrapper2">
					<div class="product-img">
						<img src="img/kapiolani_park.jpg" height="210" width="200">
					</div>
					<div class="product-info">
						<div class="product-text">
							<h1>BEST 명소</h1>
							<h2>명소는 명소지</h2>
							<p>이곳은 카피올리니 공원</p>
						</div>
						<div class="product-price-btn">
							<a><button type="button"
									onclick="location.href='placedetail.jsp?num='">바로가기</button></a>
						</div>
					</div>
				</div>
			</li>

			
		</ul>
	</section>
	<footer>
		제작자 : 박하영, 홍준영, 한상혁<br> copyright © TOURTIPS Inc. All rights
		Reserved.
	</footer>
</body>
</html>