<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="vo.UserDto"%>
<%@ page import="dao.UserDao"%>
<%@ page import="vo.Food_placeDto"%>
<%@ page import="vo.ThemaDto"%>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="user" class="dao.UserDao"/>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>Mypage</title>
  <!-- CSS -->
  <link rel="stylesheet" href="css/scrap.css?ver=1.3">
	<!-- JS -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/Mypages.js"></script>

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
<!--   사이드메뉴 -->
<aside>
<ul class="note-wrap note" style="list-style-type:none">

 <li align="left", list style="none"><a href="User.jsp">회원정보수정</a></li>
 <li align="left"><a href="scrappage.do">스크랩</a></li>
 <li align="left"><a href="Air.jsp">항공예약확인/취소</a></li>
 <li align="left"><a href="#">작성 게시물 관리</a></li>
 <li align="left"><a href="UserDelete.jsp">회원탈퇴</a></li>
 </ul>
 </aside> 

<!-- 메인배너   -->
<div class="mainbox" >
<img src="img/08.jpg"width="100%" height="500"/>
</div>

<!--본문-->

<section>
<div class="in_section">
<h3>여행에 필요한  테마, 명소, 맛집의 모든 정보를 스크랩하세요!</h3>
<br><br>
<hr>

<!-- 탭메뉴 -->
<div class="container">
  <div class="tab-section1">
            <input id="section1" type="radio" name="tab" checked="checked" />
            <label for="section1">명소</label>
            <input id="section2" type="radio" name="tab" />
            <label for="section2">맛집</label>
            <input id="section3" type="radio" name="tab" />
            <label for="section3">테마</label>
			<div id="sec1" class="tab2-content">
                <p>
        <ul id="sub-menu">
 <% ArrayList<Food_placeDto> place=(ArrayList<Food_placeDto>)request.getAttribute("place");
//out.print("place="+place.size());
            		if(place != null && place.size() > 0){
            			for(int i=0;i<place.size();i++){%>
		<li id="list2">
				<div class="wrapper2">
					<div class="product-img">
						<img src="img/<%=place.get(i).getPic()%>" height="210"
							width="200">
					</div>
					<div class="product-info">
						<div class="product-text">
							<h1><%=place.get(i).getTitle()%></h1>
							<h2><%=place.get(i).getCityname()%></h2>
							<p><%="<div class='ellip' style='width:150px;'>" + place.get(i).getContents() + "</div>"%></p>
						</div>
						<div class="product-price-btn">
							<a href="placedetail.jsp?num=<%=place.get(i).getNum()%>">
							<button>바로가기</button></a>
						</div>
					</div>
				</div>
			</li>
 <%}}else{%><div>스크랩한 게시물이 없습니다</div><%}%>
 </ul>

                </p>
            </div>
            <div id="sec2" class="tab2-content">
                <p>
                    <ul id="sub-menu">
<%ArrayList<Food_placeDto> food=(ArrayList<Food_placeDto>)request.getAttribute("food");
//out.print("food="+food.size());
            		if(food != null && food.size() > 0){
            			for(int i=0;i<food.size();i++){%>     
		<li id="list2">
				<div class="wrapper2">
					<div class="product-img">
						<img src="img/<%=food.get(i).getPic()%>" height="210"
							width="200">
					</div>
					<div class="product-info">
						<div class="product-text">
							<h1><%=food.get(i).getTitle()%></h1>
							<h2><%=food.get(i).getCityname()%></h2>
							<p><%="<div class='ellip' style='width:150px;'>" + food.get(i).getContents() + "</div>"%></p>
						</div>
						<div class="product-price-btn">
							<a href="placedetail.jsp?num=<%=food.get(i).getNum()%>">
							<button>바로가기</button></a>
						</div>
					</div>
				</div>
			</li>
 <%}}else{%><div>스크랩한 게시물이 없습니다</div><%}%>  
  </ul>
   </div>
 <div id="sec3" class="tab2-content">
               <p>
                    <ul id="sub-menu">
<%ArrayList<ThemaDto> thema=(ArrayList<ThemaDto>)request.getAttribute("thema");
//out.print("thema="+thema.size());
            		if(thema != null && thema.size() > 0){
            			for(int i=0;i<thema.size();i++){%>     
<div class="view">
  <img src="img/<%=thema.get(i).getPic()%>" width="100%" height="100%"/>
  <div class="mask">
    <h2><%=thema.get(i).getTitle()%></h2>
    <p><%=thema.get(i).getContents()%></p>
    <a href="ThemaView.do?num=<%=thema.get(i).getNum()%>" class="info">GO</a>
  </div>
</div>
 <%}}else{%><div>스크랩한 게시물이 없습니다</div><%}%>  
  </ul>
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
