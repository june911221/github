<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ page import="vo.ThemaDto"%>
<%@ page import="dao.ThemaDao"%>
<%@ page import="dao.Food_placeDao"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Date" %>
<jsp:useBean id="check" class="dao.Food_placeDao"></jsp:useBean>
<link rel="stylesheet" href="css/ThemaView.css?ver=1.3">
<%
request.setCharacterEncoding("UTF-8");
ThemaDto view = (ThemaDto)request.getAttribute("article");
int num=view.getNum();
String title=view.getTitle();
String contents=view.getContents();
String category=view.getCategory();
String pic=view.getPic();
String cityname=view.getCityname();
String Page = (String)request.getParameter("page");

out.print("<script>function scraps(){");
if (session.getAttribute("ID") == null) {
	out.print("alert('로그인이 필요합니다');");
} else {
	out.print("SCRAP(" + num + ")");
}
out.print("}</script>");
int scrapnum = 0;
if(session.getAttribute("ID")!=null){//로그인 아이디를 체크해서 로그인이 되어있다면 실행
 	scrapnum = (int) check.ScrapCount((String)session.getAttribute("ID"),num,category);//로그인 아이디와 게시글 번호를 가지고 게시글을 이미 스크랩했는지 유무를 판단
}
out.print("<input type='hidden' id='scrapnum' value='"+scrapnum+"'>");
out.print("<input type='hidden' id='number' value='"+num+"'>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
 
 <!--     SIDE AREA -->
			<div class="sideArea">


				<ul class="sideMenu">
					<li><a href="CitySel.jsp" class="has-submenu"><span
							class="fa fa-table"></span>도시</a></li>
					<li><a href="Thema.do"><span class="fa fa-sitemap"></span>테마</a></li>
					<li><a href="place.jsp?category1=명소"><span class="fa fa-money"></span>명소</a></li>
					<li><a href="food.jsp?category1=맛집"><span class="fa fa-user-o"></span>맛집</a></li>

				</ul>
			</div>
			<!--     SIDE AREA -->
			
 <section>
<!--<img src="img/<%=pic%>" width="300" height="300">-->
<div id="title"><%=title%></div>

<input type="hidden" id="category" value="<%=category%>">
<input type="button" class="scrapbtn" id="scrap" value="스크랩" onclick="scraps()">
<input type="hidden" class="scrapbtn" id="scrapdel" value="스크랩취소" onclick="scrapdel(<%=num%>)">
<hr>

<div id="info">
<div id="category">카테고리 | <%=category%></div>
<div id="cityname">도시명 | <%=cityname%></div>
</div>

<div id="contents"><%=contents%></div>

<script src="js/ThemaView.js"></script>
</section>
<footer>
		제작자 : 박하영, 홍준영, 한상혁<br> copyright © TOURTIPS Inc. All rights
		Reserved.
	</footer>
</body>
</html>