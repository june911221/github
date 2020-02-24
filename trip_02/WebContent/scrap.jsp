<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="vo.UserDto"%>
<%@ page import="dao.UserDao"%>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="user" class="dao.UserDao"/>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>Mypage</title>
  <!-- CSS -->
  <link rel="stylesheet" href="css/scrap.css?ver=1">
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
 <li align="left"><a href="#">스크랩</a></li>
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
<h1>나의 스크랩</h1>
<br><br>
<hr>
<h3>여행에 필요한 일정, 테마, 명소, 맛집, 항공 등 모든 정보를 스크랩하세요!</h3>






</div>
</section>


   <footer>
   제작자 : 박하영, 홍준영, 한상혁<br>
   copyright © TOURTIPS Inc. All rights Reserved.
   </footer>
 </body>
</html>
