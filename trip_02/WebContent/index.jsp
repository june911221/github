<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="vo.Food_placeDto"%>
<!doctype html>
<html lang="en">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>index</title>

  <!-- css -->
<link rel="stylesheet" href="css/index.css?ver=1.21">
  <!-- js -->
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
 
<!-- js -->
<script language="JavaScript" src="js/index1.js" charset="UTF-8"></script>
  
<div class="contents">
		<div class="banner">
			<ul>
			    <li><img src="img\b5.jpg" width="1900px" height="500px"></li>
				<li><img src="img\b1.jpg" width="1900px" height="500px"></li>
				<li><img src="img\b2.jpg" width="1900px" height="500px"></li>
				<li><img src="img\b3.jpg" width="1900px" height="500px"></li>
				<li><img src="img\b4.jpg" width="1900px" height="500px"></li>
				
			</ul>
		</div>
	</div>




  <div id=box>

<div id="sub">
  <ul id="main-menu">
    
    <li id="city"><img id="mini" src="img\aasi.jpg" width="55px;" height="45px;"><br><div id="Aname">아시아</div>
      <ul id="sub-menu">
      <div id="citylist">
        <li id="list2"><a href="TourCity.jsp?cityname=홍콩(Hongkong)&timeval=-1" aria-label="subemnu"><img id="flag" src="img\flag_HKG.gif" width="40" height="25">  홍콩</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=마카오(Macau)&timeval=1" aria-label="subemnu"><img id="flag" src="img\flag_MFM.gif" width="40" height="25">  마카오</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=도쿄(Tokyo)&timeval=0" aria-label="subemnu"><img id="flag" src="img\flag_OSA.gif" width="40" height="25">  도쿄</a></li>
		<li id="list2"><a href="TourCity.jsp?cityname=타이베이(Taipei)&timeval=-1" aria-label="subemnu"><img id="flag" src="img\flag_TPE.gif" width="40" height="25">  타이베이</a></li>
		<li id="list2"><a href="TourCity.jsp?cityname=상하이(Shanghai)&timeval=-1" aria-label="subemnu"><img id="flag" src="img\flag_BJS.gif" width="40" height="25">  상하이</a></li>
		<div>
      </ul>
    </li>
    <li id="city"><img id="mini" src="img\ddong.jpg" width="55px;" height="45px;"><br><div id="Aname">동남아</div>
      <ul id="sub-menu">
         <div id="citylist">
        <li id="list2"><a href="TourCity.jsp?cityname=싱가폴(Singapore)&timeval=-1"" aria-label="subemnu"><img id="flag"  src="img\flag_SIN.gif" width="40" height="25">  싱가폴</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=푸켓(Phuket)&timeval=-2" aria-label="subemnu"><img id="flag"  src="img\flag_BKK.gif" width="40" height="25">  푸켓</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=세부(Cebu)&timeval=-1" aria-label="subemnu"><img id="flag"  src="img\flag_CEB.gif" width="40" height="25">  세부</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=코타키나발루(KotaKinabalu)&timeval=-1" aria-label="subemnu"><img id="flag"  src="img\flag_BKI.gif" width="40" height="25">  코타키나발루</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=다낭(Danang)&timeval=-2" aria-label="subemnu"><img id="flag"  src="img\flag_DAD.gif" width="40" height="25">  다낭</a></li>
		<li id="list2"><a href="TourCity.jsp?cityname=호치민(HoChiMinh)&timeval=-2" aria-label="subemnu"><img id="flag"  src="img\flag_DAD.gif" width="40" height="25">  호치민</a></li>
		</div>
      </ul>
    </li>
    <li id="city"><img id="mini" src="img\euu.jpg" width="55px;" height="45px;"><br><div id="Aname">유럽</div>
      <ul id="sub-menu">
         <div id="citylist">
        <li id="list2"><a href="TourCity.jsp?cityname=파리(Paris)&timeval=-8" aria-label="subemnu"><img id="flag"  src="img\flag_PAR.gif" width="40" height="25">  파리</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=로마(Roma)&timeval=-8" aria-label="subemnu"><img id="flag"  src="img\flag_ROM.gif" width="40" height="25">  로마</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=런던(London)&timeval=-9" aria-label="subemnu"><img id="flag"  src="img\flag_LON.gif" width="40" height="25">  런던</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=바르셀로나(Barcelona)&timeval=-8" aria-label="subemnu"><img id="flag"  src="img\flag_BCN.gif" width="40" height="25">  바르셀로나</a></li>
		</div>
      </ul>
    </li>
     <li id="city"><img id="mini" src="img\aam.jpg" width="55px;" height="45px;"><br><div id="Aname">미주</div>
      <ul id="sub-menu">
         <div id="citylist">
        <li id="list2"><a href="TourCity.jsp?cityname=뉴욕(NewYork)&timeval=-14" aria-label="subemnu"><img id="flag"  src="img\flag_Z01.gif" width="40" height="25">  뉴욕</a></li>
        <li id="list2"><a href="TourCity.jsp?cityname=하와이(Honolulu)&timeval=-19" aria-label="subemnu"><img id="flag" src="img\flag_Z01.gif" width="40" height="25">  하와이</a></li>
		</div>
      </ul>
    </li>
	<li id="city"><img id="mini" src="img\dd.jpg" width="55px;" height="45px;"><br><div id="Aname">남태평양</div>
      <ul id="sub-menu">
         <div id="citylist">
         <li id="list2"><a href="TourCity.jsp?cityname=괌(Guam)&timeval=1" aria-label="subemnu"><img id="flag"  src="img\flag_Z01.gif" width="40" height="25">  괌</a></li>
		</div>
      </ul>
    </li>
  </ul>
</div>

 
<div class=layout id="air"><h2 id="airsearch">최저 항공권 검색</h2>
<img id="airp"src="img\air.png" width=150px; height=100px;>
<div id="go"><div id="go2">출발지를 입력하세요 : </div><input id="autocomplete" type="text" /></div><br><br><br>
<div id="back"><div id="back2">목적지를 입력하세요 : </div><input id="autocomplete2" type="text" /></div>
<input class="dal" type="text" value="출발일" id="testDatepicker">
<input class="dal2" type="text" value="도착일" id="testDatepicker2">
<button id= "green"><b>검색</b></button>
</div>
</div>
<!-- <span id="bottom"> -->
<img src="img/food_place.png">
<jsp:useBean id="mainlist" class="dao.Food_placeDao" />
<%
ArrayList<Food_placeDto> list = (ArrayList<Food_placeDto>)mainlist.Mainlist();

for(int i=0; list.size()>i; i++){
%>  
 <span class="sample_image">
 <a href="placedetail.jsp?num=<%=list.get(i).getNum()%>"><img id="london" src="img\<%=list.get(i).getPic()%>"></a>
<%-- <%="<span class='ellip' style='width:200px;'>"+list.get(i).getSubtitle()+"</span>"%> --%>
</span>
<%}%>
<!-- </span>   -->
</section>
<footer><jsp:include page="footer.jsp"/></footer>
 </body>
</html>
