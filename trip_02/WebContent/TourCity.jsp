<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>


<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>tourcity</title>
  <!-- CSS -->
  <link rel="stylesheet" href="css/tourcity.css">
	<!-- JS -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/TourCity.js"></script>

</body>


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
 
 
  <section>
<script src="js/TourCity2.js"></script>
 <!-- 도시이름을 담아놨다가 스크립트에서 이름을 뽑아서 해당도시 날짜를 가져오는 스크립트에 도시이름을 가져간다 -->
<input type="hidden" value="<%=request.getParameter("cityname")%>" id="test">
<input type="hidden" value="<%=request.getParameter("timeval")%>"  id="timeval">
<!--   사이드메뉴 -->
<aside>
<ul class="note-wrap note">
 <li align="center"><a href="CitySel.jsp">도시</a></li>
 <li align="center"><a href="#">테마</a></li>
 <li align="center"><a href="#">명소</a></li>
 <li align="center"><a href="#">맛집</a></li>
 </ul>
 </aside> 

<!-- 메인배너   -->
<div class="mainbox" >
<img src="" id="mainimg" width="100%" height="500"/>
<!-- 메인에 도시이름표시 -->
<div id="cityval"><%=request.getParameter("cityname")%></div>
<!-- 배너에시간표시 -->
<div id="clock"></div>
<!-- 배너에날씨정보표시 -->
<div id="showWeatherForcast"></div>
</div>

<!-- 나라선택폼 -->
<form name="cnjform">
<select class="sel" name="cityname" id="getWeatherForcast" onChange="city_time();">
<option value="0" selected>도시, 지역 선택</option>
<option value="-9">런던(London)</option>
<option value="-8">파리(Paris)</option>
<option value="1">괌(Guam)</option>
<option value="-2">다낭(Danang)</option>
<option value="-1">상해(Shanghai)</option>
<option value="-19">하와이(Honolulu)</option>
</select>
</form>
<div class="cityment">여행하실 도시를 선택해주세요</div>


<!-- 도시정보 -->
<div class="cityinfo">
<div id="cityval2"><%=request.getParameter("cityname")%></div>
<div class="subinfo" id="subinfo"></div>
</div>
<!--best명소&맛집-->
<div class="best">

<div class="bestbanner">
<div class="subtitle"><span>Best1</span></div>
<img src="img/logo2.png">
</div>
<div class="bestbanner">
<div class="subtitle"><span>Best2</span></div>
<img src="img/logo2.png">
</div>
<div class="bestbanner">
<div class="subtitle"><span>Best3</span></div>
<img src="img/logo2.png">
</div>

</div>

<!-- 탭메뉴 -->
<div class="container">
  <div class="tab-section1">
            <input id="section1" type="radio" name="tab" checked="checked" />
            <label for="section1">명소</label>
            <input id="section2" type="radio" name="tab" />
            <label for="section2">맛집</label>
			<div id="sec1" class="tab2-content">
                <p>
        <ul id="sub-menu">
        <li id="list2"><div class="wrapper2">
    <div class="product-img">
      <img src="http://bit.ly/2tMBBTd" height="210" width="200">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>BEST 명소</h1>
        <h2>by studio and friends</h2>
        <p>Harvest Vases are a reinterpretation</p>
      </div>
      <div class="product-price-btn">
        <a><button type="button">바로가기</button></a>
      </div>
    </div>
  </div>
  </li>
   <li id="list2"> <div class="wrapper2">
    <div class="product-img">
      <img src="http://bit.ly/2tMBBTd" height="210" width="200">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>BEST 명소</h1>
        <h2>by studio and friends</h2>
        <p>Harvest Vases are a reinterpretation</p>
      </div>
      <div class="product-price-btn">
        <a><button type="button">바로가기</button></a>
      </div>
    </div>
  </div>
  </li>
   <li id="list2"> <div class="wrapper2">
    <div class="product-img">
      <img src="http://bit.ly/2tMBBTd" height="210" width="200">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>BEST 명소</h1>
        <h2>by studio and friends</h2>
        <p>Harvest Vases are a reinterpretation</p>
      </div>
      <div class="product-price-btn">
        <a><button type="button">바로가기</button></a>
      </div>
    </div>
  </div>
  </li>
   <li id="list2"> <div class="wrapper2">
    <div class="product-img">
      <img src="http://bit.ly/2tMBBTd" height="210" width="200">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>BEST 명소</h1>
        <h2>by studio and friends</h2>
        <p>Harvest Vases are a reinterpretation</p>
      </div>
      <div class="product-price-btn">
        <a><button type="button">바로가기</button></a>
      </div>
    </div>
  </div>
  </li>
   <li id="list2"> <div class="wrapper2">
    <div class="product-img">
      <img src="http://bit.ly/2tMBBTd" height="210" width="200">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>BEST 명소</h1>
        <h2>by studio and friends</h2>
        <p>Harvest Vases are a reinterpretation</p>
      </div>
      <div class="product-price-btn">
        <a><button type="button">바로가기</button></a>
      </div>
    </div>
  </div>
  </li>
   <li id="list2"> <div class="wrapper2">
    <div class="product-img">
      <img src="http://bit.ly/2tMBBTd" height="210" width="200">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>BEST 명소</h1>
        <h2>by studio and friends</h2>
        <p>Harvest Vases are a reinterpretation</p>
      </div>
      <div class="product-price-btn">
        <a><button type="button">바로가기</button></a>
      </div>
    </div>
  </div>
  </li>
       </ul>
                </p>
            </div>
            <div id="sec2" class="tab2-content">
                <p>
                    <ul id="sub-menu">
         <li id="list2"> <div class="wrapper2">
    <div class="product-img">
      <img src="http://bit.ly/2tMBBTd" height="210" width="200">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>BEST 맛집</h1>
        <h2>by studio and friends</h2>
        <p>Harvest Vases are a reinterpretation</p>
      </div>
      <div class="product-price-btn">
        <a><button type="button">바로가기</button></a>
      </div>
    </div>
  </div>
  </li>
   <li id="list2"> <div class="wrapper2">
    <div class="product-img">
      <img src="http://bit.ly/2tMBBTd" height="210" width="200">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>BEST 맛집</h1>
        <h2>by studio and friends</h2>
        <p>Harvest Vases are a reinterpretation</p>
      </div>
      <div class="product-price-btn">
        <a><button type="button">바로가기</button></a>
      </div>
    </div>
  </div>
  </li>
   <li id="list2"> <div class="wrapper2">
    <div class="product-img">
      <img src="http://bit.ly/2tMBBTd" height="210" width="200">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>BEST 맛집</h1>
        <h2>by studio and friends</h2>
        <p>Harvest Vases are a reinterpretation</p>
      </div>
      <div class="product-price-btn">
        <a><button type="button">바로가기</button></a>
      </div>
    </div>
  </div>
  </li>
   <li id="list2"> <div class="wrapper2">
    <div class="product-img">
      <img src="http://bit.ly/2tMBBTd" height="210" width="200">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>BEST 맛집</h1>
        <h2>by studio and friends</h2>
        <p>Harvest Vases are a reinterpretation</p>
      </div>
      <div class="product-price-btn">
        <a><button type="button">바로가기</button></a>
      </div>
    </div>
  </div>
  </li>
   <li id="list2"> <div class="wrapper2">
    <div class="product-img">
      <img src="http://bit.ly/2tMBBTd" height="210" width="200">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>BEST 맛집</h1>
        <h2>by studio and friends</h2>
        <p>Harvest Vases are a reinterpretation</p>
      </div>
      <div class="product-price-btn">
        <a><button type="button">바로가기</button></a>
      </div>
    </div>
  </div>
  </li>
   <li id="list2"> <div class="wrapper2">
    <div class="product-img">
      <img src="http://bit.ly/2tMBBTd" height="210" width="200">
    </div>
    <div class="product-info">
      <div class="product-text">
        <h1>BEST 맛집</h1>
        <h2>by studio and friends</h2>
        <p>Harvest Vases are a reinterpretation</p>
      </div>
      <div class="product-price-btn">
        <a><button type="button">바로가기</button></a>
      </div>
    </div>
  </div>
  </li>
  </ul>
   </div>
    </div>
 </section>
   <footer>
   제작자 : 박하영, 홍준영, 한상혁<br>
   copyright © TOURTIPS Inc. All rights Reserved.
   </footer>
 </body>
</html>
