<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
	<!DOCTYPE html>
	<html>
	<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<title>citysel</title>
<link rel="stylesheet" href="css/citysel.css">
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
      <img src="http://bit.ly/2tMBBTd" height="420" width="327">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>BESt 명소</h1>
        <h2>by studio and friends</h2>
        <p>Harvest Vases are a reinterpretation<br> of peeled fruits and vegetables as<br> functional objects. The surfaces<br> appear to be sliced and pulled aside,<br> allowing room for growth. </p>
      </div>
      <div class="product-price-btn">
        <a><button type="button">바로가기</button></a>
      </div>
    </div>
  </div>
<!--  맛집 -->
     <div class="wrapper2">
    <div class="product-img">
      <img src="http://bit.ly/2tMBBTd" height="420" width="327">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>BEST 맛집</h1>
        <h2>by studio and friends</h2>
        <p>Harvest Vases are a reinterpretation<br> of peeled fruits and vegetables as
      </div>
      <div class="product-price-btn">
        <a><button type="button">바로가기</button></a>
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