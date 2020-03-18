<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="vo.Food_placeDto"%>
<%@ page import="dao.Food_placeDao"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="vo.PageInfo"%>
<jsp:useBean id="user" class="dao.Food_placeDao" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>명소</title>
<link rel="stylesheet" href="css/place.css?ver=1.2">

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
					<li><a href="Thema.do"><span class="fa fa-sitemap"></span>테마</a></li>
					<li><a href="place.jsp?category1=명소"><span class="fa fa-money"></span>명소</a></li>
					<li><a href="food.jsp?category1=맛집"><span class="fa fa-user-o"></span>맛집</a></li>

				</ul>
			</div>
			<!--     SIDE AREA -->

		</div>
		</div>
		<img id="title" src="img/place_title.png">
		
		<!-- 검색창 -->
		<form action="place.jsp?category1=명소" method="post">
		<div id="searchbar">
			<input type="text" placeholder="검색할 도시를 입력하세요." name="searchbox">
			<input type="submit" value="검색">
		</div>
		</form>
		
		<hr>

<ul id="sub-menu">
<%
request.setCharacterEncoding("UTF-8");
int pages = 1;
int limit = 9;

if (request.getParameter("page") != null) {
	pages = Integer.parseInt(request.getParameter("page"));
}
if (request.getParameter("page") == null) {
	pages = 1;
}
int listCount=0; //글의개수를 담아둘 변수를 만들고 0으로 초기화
ArrayList<Food_placeDto> view=null;//ArrayList변수를 만들고 null로 초기화

String category = request.getParameter("category1");//카테고리를 변수에 담는다
if(request.getParameter("searchbox")==null){
listCount = (int) user.selectcategoryListCount(category);//카테고리에 해당하는 게시글 출력
view = (ArrayList<Food_placeDto>) user.Food_placeDto(category,pages,limit);//카테고리와 페이지 변수들을 메소드로 보내서 해당하는 글의 리스트를 ArrayList에 담아둔다
}
else{
String cityname=request.getParameter("searchbox");
listCount = (int) user.SearchselectcategoryListCount(category, cityname);//카테고리에 해당하는 게시글 출력
view = (ArrayList<Food_placeDto>) user.Search_Food_placeDto(category,pages,limit,cityname);//검색어가 들어왔을때  해당하는 글의 리스트틀 ArrayList에 담아둔다
}

// 총 페이지 수.
int maxPage = (int) ((double) listCount / limit + 0.95); // 0.95를 더해서 올림 처리.
// 현재 페이지에 보여줄 시작 페이지 수
int startPage = (((int) ((double) pages / 9 + 0.9)) - 1) * 9 + 1;
// 현재 페이지에 보여줄 마지막 페이지 수.

int endPage = startPage + 9 - 1;

if (endPage > maxPage)
	endPage = maxPage;

int nowPage=pages;
if(view != null && listCount > 0){
  for (int i = 0; i < view.size(); i++) {
%>

<li id="list2">
<div class="wrapper2">
<div class="product-img">
<img src="img/<%=view.get(i).getPic()%>" height="210" width="200">

					</div>
					<div class="product-info">
						<div class="product-text">
							<h1><%=view.get(i).getTitle()%></h1>
							<h2><%=view.get(i).getCityname()%></h2>
							<div class='contentbox' style=''>
							<div class='ellip' style='width:150px;'><%=view.get(i).getContents()%></div>
							</div>
							<div></div>
							<div class="product-price-btn">
								<a><button type="button"
										onclick="location.href='placedetail.jsp?num=<%=view.get(i).getNum()%>'">바로가기</button></a>
							</div>
						</div>
					</div>
			</li>
			<%}%>
		</ul>
<div id="pageList">

	<ul class="pagination">
<%if(nowPage<=1){ %>
		
		<%}else{ %>
			<li class="page-item"><a id="page-id2" href="place.jsp?category1=명소&page=<%=nowPage-1%>">[이전]</a></li>&nbsp;
		<%} %>

		<%for(int a=startPage;a<=endPage;a++){
				if(a==nowPage){%>
		<li class="page-item"><a id="page-id" href="place.jsp?category1=명소&page=<%=a%>"><%=a%></a></li>
		<%}else{ %>
			<li class="page-item"><a id="page-id" href="place.jsp?category1=명소&page=<%=a%>"><%=a%></a></li>&nbsp;
		<%} %>
		<%} %>

		<%if(nowPage>=maxPage){ %>
		
		<%}else{ %>
			<li class="page-item"><a id="page-id2" href="place.jsp?category1=명소&page=<%=nowPage+1%>">[다음]</a></li>
		<%} %>
		</ul>
	</div>
	<%
    }
	else
	{
	%>
	<div id="emptyArea">등록된 글이 없습니다.</div>
	<%
	}
%>
	</section>
	<footer>
		제작자 : 박하영, 홍준영, 한상혁<br> copyright © TOURTIPS Inc. All rights
		Reserved.
	</footer>
</body>
</html>