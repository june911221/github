<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
	<!DOCTYPE html>
	<html lang="en" >
	<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<title>tourinfo</title>
	
<!-- css -->
<link rel="stylesheet" href="css/tour.css">
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
<!-- js -->
<script  src="js/tour.js"></script>
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
<div id="back"><p>어디로 여행을 가시나요?</p></div>
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
<!-- 나라선택메뉴 -->
<div class="container">
  <div class="tab-section1">
            <input id="section1" type="radio" name="tab" checked="checked" />
            <label for="section1">아시아</label>
            <input id="section2" type="radio" name="tab" />
            <label for="section2">동남아</label>
            <input id="section3" type="radio" name="tab" />
            <label for="section3">유럽</label>
			 <input id="section4" type="radio" name="tab" />
            <label for="section4">미주</label>
			 <input id="section5" type="radio" name="tab" />
			 <label for="section5">남태평양</label>

            <div id="sec1" class="tab2-content">
                <p>
        <ul id="sub-menu">
        <li id="list2"><a href="TourCity.jsp?cityname=홍콩(Hongkong)&timeval=-1"><img id="flag" src="img/flag_HKG.gif" width="40" height="25">홍콩</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=도쿄(Tokyo)&timeval=0"><img id="flag" src="img/flag_OSA.gif" width="40" height="25">도쿄</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=마카오(Macau)&timeval=1"><img id="flag" src="img/flag_MFM.gif" width="40" height="25">마카오</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=상하이(Shanghai)&timeval=-1"><img id="flag" src="img/flag_BJS.gif" width="40" height="25">상하이</a></li>	
       <li id="list2"><a href="TourCity.jsp?cityname=타이베이(Taipei)&timeval=-1"><img id="flag" src="img/flag_TPE.gif" width="40" height="25">타이베이</a></li>
       </ul>
                </p>
            </div>
            <div id="sec2" class="tab2-content">
                <p>
                    <ul id="sub-menu">
        <li id="list2"><a href="TourCity.jsp?cityname=싱가폴(Singapore)&timeval=-1"><img id="flag"  src="img/flag_SIN.gif" width="40" height="25">싱가폴</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=푸켓(Phuket)&timeval=-2"><img id="flag"  src="img/flag_BKK.gif" width="40" height="25">푸켓</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=호치민(HoChiMinh)&timeval=-2"><img id="flag"  src="img/flag_DAD.gif" width="40" height="25">호치민</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=다낭(Danang)&timeval=-2"><img id="flag"  src="img/flag_DAD.gif" width="40" height="25">다낭</a></li>
		<li id="list2"><a href="TourCity.jsp?cityname=세부(Cebu)&timeval=-1" style="position:relative; left:0px;"><img id="flag"  src="img/flag_CEB.gif" width="40" height="25">세부</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=코타키나발루(KotaKinabalu)&timeval=-1" style="position:relative; left:15px;"><img id="flag"  src="img/flag_BKI.gif" width="40" height="25">코타키나발루</a></li>
		</ul>
                </p>
            </div>
            <div id="sec3" class="tab2-content">
                <p>
        <ul id="sub-menu">
        <li id="list2"><a href="TourCity.jsp?cityname=파리(Paris)&timeval=-8"><img id="flag"  src="img/flag_PAR.gif" width="40" height="25">파리</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=로마(Roma)&timeval=-8"><img id="flag"  src="img/flag_ROM.gif" width="40" height="25">로마</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=런던(London)&timeval=-9"><img id="flag"  src="img/flag_LON.gif" width="40" height="25">런던</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=바르셀로나(Barcelona)&timeval=-8"><img id="flag"  src="img/flag_BCN.gif" width="40" height="25">바르셀로나</a></li>
        </ul>
		</p>
				</div>
			<div id="sec4" class="tab2-content">
                <p>
         <ul id="sub-menu">
          <li id="list2"><a href="TourCity.jsp?cityname=뉴욕(NewYork)&timeval=-14"><img id="flag" src="img/flag_Z01.gif" width="40" height="25">뉴욕</a></li>
         <li id="list2"><a href="TourCity.jsp?cityname=하와이(Honolulu)&timeval=-19"><img id="flag" src="img/flag_Z01.gif" width="40" height="25">하와이</a></li>
         </ul>     
	           </p>
            </div>
			<div id="sec5" class="tab2-content">
                <p>
                    <ul id="sub-menu">
        <li id="list2"><a href="TourCity.jsp?cityname=괌(Guam)&timeval=1"><img id="flag"  src="img/flag_Z01.gif" width="40" height="25">괌</a></li>
      </ul>
                </p>
            </div>
        </div>
    </div>

<!-- 테마선택카드 -->
<div class="gallery">  
<br><br><br><p style="font-size: 34px;
  color: #474747; font-weight:bold;">테 마 여 행</p>
<div class="view">
  <img src="img/banner6.jpg" width="100%" height="100%"/>
  <div class="mask">
    <h2>가족</h2>
    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
    <a href="Thema.do?category=가족" class="info">Read More</a>
  </div>
</div>

<div class="view">
  <img src="http://farm4.staticflickr.com/3672/9759934733_30459e24b6_c.jpg"/>
  <div class="mask">
    <h2>연인</h2>
    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
    <a href="Thema.do?category=연인" class="info">Read More</a>
  </div>
</div>

<div class="view">
  <img src="img/banner5.jpg" width="100%" height="100%"/>
  <div class="mask">
    <h2>힐링</h2>
    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
    <a href="Thema.do?category=힐링" class="info">Read More</a>
  </div>
</div>
  
<div class="view">
  <img src="http://farm3.staticflickr.com/2830/9479528002_33660b24ef_c.jpg"/>
  <div class="mask">
    <h2>익사이팅</h2>
    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
    <a href="Thema.do?category=익사이팅" class="info">Read More</a>
  </div>
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