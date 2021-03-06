<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
	<!DOCTYPE html>
	<html>
	<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<title>citysel</title>
<link rel="stylesheet" href="css/citysel.css?ver=1">
<script  src="js/CitySel.js"></script>
	</head>
	<body>
	
	 
  <% 
 String ses=null;
 ses=(String)session.getAttribute("ID");
 if(ses==null){%>
 <jsp:include page="header.jsp"/>
 <%} else{%>
 <jsp:include page="Loginheader.jsp"/>
 <%} %>
 
 
	<!--내용 -->
	<section>

<!--배너 -->
	<div id="mainbanner">
	<div id="captioned-gallery">
	<figure class="slider">
		<figure>
			<img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/4273/hobbiton-lake.jpg" alt>
			<figcaption>Hobbiton, New Zealand</figcaption>
		</figure>
		<figure>
			<img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/4273/wanaka-drowned-tree.jpg" alt>
			<figcaption>Wanaka, New Zealand</figcaption>
		</figure>
		<figure>
			<img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/4273/utah-peak.jpg" alt>
			<figcaption>Utah, United States</figcaption>
		</figure>
		<figure>
			<img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/4273/bryce-canyon-utah.jpg" alt>
			<figcaption>Bryce Canyon, Utah, United States</figcaption>
		</figure>
		<figure>
			<img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/4273/hobbiton-lake.jpg" alt>
			<figcaption>Hobbiton, New Zealand</figcaption>
		</figure>
	</figure>
</div>
<div id="back"><p>도시를 선택해주세요.</p></div>
<form name="cnjform">
<select class="sel" name="cityname" id="getWeatherForcast" onChange="city_time();">
<option value="0" selected>도시, 지역 선택</option>
<option value="-9">런던(London)</option>
<option value="-8">파리(Paris)</option>
<option value="1">괌(Guam)</option>
<option value="-2">다낭(Danang)</option>
<option value="-1">상하이(Shanghai)</option>
<option value="-19">하와이(Honolulu)</option>
<option value="-1">홍콩(Hongkong)</option>
<option value="-0">도쿄(Tokyo)</option>
<option value="-1">마카오(Macau)</option>
<option value="-1">타이베이(Taipei)</option>
<option value="-1">싱가폴(Singapore)</option>
<option value="-2">푸켓(Phuket)</option>
<option value="-2">호치민(HoChiMinh)</option>
<option value="-1">세부(Cebu)</option>
<option value="-1">코타키나발루(KotaKinabalu)</option>
<option value="-8">로마(Roma)</option>
<option value="-8">바르셀로나(Barcelona)</option>
<option value="-14">뉴욕(NewYork)</option>
</select>
</form>
</div>
	</div>
	<!-- 명소 -->
    <div class="wrapper">
    <div class="product-img">
      <img src="img/bestplace.png" height="400" width="327">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>추천명소 BEST</h1>
        <p>여행준비 할 때 꼭 필요한<br>인기있는 관광지들을 소개합니다!<br> 도시별 추천 명소들을 확인해보세요!</p>
      </div>
      <div class="product-price-btn">
        <a href="place.jsp?category1=명소"><button type="button">GO</button></a>
      </div>
    </div>
  </div>
<!--  맛집 -->
     <div class="wrapper2">
    <div class="product-img">
      <img src="img/bestfood.jpg" height="400" width="327">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>추천맛집 BEST</h1>
       <p>여행준비 할 때 꼭 필요한<br>맛집들을 소개합니다!<br> 도시별 추천 맛집들을 확인해보세요!</p>
      </div>
      <div class="product-price-btn">
        <a href="food.jsp?category1=맛집"><button type="button">GO</button></a>
      </div>
    </div>
  </div>

  </section>
 <footer>
   제작자 : 박하영, 홍준영, 한상혁<br>
   copyright © TOURTIPS Inc. All rights Reserved.
   </footer>
	</body>
	</html>