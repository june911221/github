<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="vo.Food_placeDto"%>
<%@ page import="dao.Food_placeDao"%>
<%@ page import="java.util.ArrayList"%>
<jsp:useBean id="user" class="dao.Food_placeDao" />
<%-- <%
Food_placeDto view= (Food_placeDto)request.getAttribute("article");
 int num= view.getNum(); 
String title= view.getTitle();
String contents= view.getContents();
String pic= view.getPic();
String place= view.getPlace();
String tel= view.getTel();
String time= view.getTime();
String category= view.getCategory();
String cityname= view.getCityname(); %>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>명소</title>
<link rel="stylesheet" href="css/place.css?ver=1.03">
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

		<!--   사이드메뉴 -->
		<aside>
			<ul class="note-wrap note" style="list-style-type: none">

				<li align="left" , list style=""><a href="#">도시</a></li>
				<li align="left"><a href="#">테마</a></li>
				<li align="left"><a href="#">명소</a></li>
				<li align="left"><a href="#">맛집</a></li>
			</ul>
		</aside>
		<!-- 검색창 -->
		<div>
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

			<li id="list2">
				<div class="wrapper2">
					<div class="product-img">
						<img src="img/Shanghai.jpg" height="210" width="200">
					</div>
					<div class="product-info">
						<div class="product-text">
							<h1>BEST 명소</h1>
							<h2>명소는 명소지</h2>
							<p>이곳은 상해의 예원</p>
						</div>
						<div class="product-price-btn">
							<a><button type="button" onclick="location.href='#'">바로가기</button></a>
						</div>
					</div>
				</div>
			</li>

			<li id="list2">
				<div class="wrapper2">
					<div class="product-img">
						<img src="img/Paris.jpg" height="210" width="200">
					</div>
					<div class="product-info">
						<div class="product-text">
							<h1>BEST 명소</h1>
							<h2>명소는 명소지</h2>
							<p>이곳은 카피올리니 공원</p>
						</div>
						<div class="product-price-btn">
							<a><button type="button" onclick="location.href='#'">바로가기</button></a>
						</div>
					</div>
				</div>
			</li>

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
							<a><button type="button" onclick="location.href='#'">바로가기</button></a>
						</div>
					</div>
				</div>
			</li>

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
							<a><button type="button" onclick="location.href='#'">바로가기</button></a>
						</div>
					</div>
				</div>
			</li>

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
							<a><button type="button" onclick="location.href='#'">바로가기</button></a>
						</div>
					</div>
				</div>
			</li>

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
							<a><button type="button" onclick="location.href='#'">바로가기</button></a>
						</div>
					</div>
				</div>
			</li>

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
							<a><button type="button" onclick="location.href='#'">바로가기</button></a>
						</div>
					</div>
				</div>
			</li>

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
							<a><button type="button" onclick="location.href='#'">바로가기</button></a>
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