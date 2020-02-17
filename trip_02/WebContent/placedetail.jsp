<%@page import="vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.Food_placeDto"%>
<%@ page import="vo.PageInfo"%>
<%@ page import="dao.Food_placeDao"%>
<%@ page import="java.util.ArrayList"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%-- <%Food_placeDto view= (Food_placeDto)request.getAttribute("arti");
int num= view.getNum();
String title= view.getTitle();
String contents= view.getContents();
String pic= view.getPic();
String place= view.getPlace();
String tel= view.getTel();
String time= view.getTime();
String category= view.getCategory();
String cityname= view.getCityname();
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int listCount=pageInfo.getListCount();
	int nowPage=pageInfo.getPage();
	int maxPage=pageInfo.getMaxPage();
	int startPage=pageInfo.getStartPage();
	int endPage=pageInfo.getEndPage();%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>명소</title>
<style>
section {
	width: 100%;
	height: 2150px;
}

table {
	float: right;
	margin-right: 150px;
	text-align: center;
	width: 60%;
	/*  border:solid 1px black;   */
}

td, tr {
	/*  border:solid 1px black; */
	
}

ul {
	list-style: none;
}

/* SIDE CSS */
.sideArea {
	width: 200px;
	min-width: 200px;
	background: /* #c0c0c0 */ rgba( 173, 205, 237, 0.2);
	position: absolute;
	top: 200px;
	bottom: 0;
	left: 0;
	transition: 0.5s;
	height: 1370px;
}

.container.is-click .sideArea {
	left: -200px;
}

.sideArea li>a {
	display: block;
	color: black;
	font-weight: bold;
	padding: 1em;
	border-bottom: 1px solid rgba(255, 255, 255, 0.2);
	margin-bottom: 40px;
	opacity: 1.0;
}

.sideArea li>a:hover {
	background: rgba(255, 255, 255, 0.1);
}

.sideArea li>a>.fa {
	width: 1em;
	text-align: center;
	margin-right: 10px;
}

.submenu {
	display: none;
	border-bottom: 1px solid rgba(255, 255, 255, 0.2);
	margin-top: 170px;
}

.submenu li>a {
	padding-left: 2em;
	border-bottom: none;
}

.sideMenu {
	border-top: 1px solid rgba(255, 255, 255, 0.2);
	margin-top: 200px;
}

footer {
	height: 200px;
	width: 100%;
	background: #D6503E;
}
</style>
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
		<!--     SIDE AREA -->
		<div class="sideArea">


			<ul class="sideMenu">
				<li><a href="CitySel.jsp" class="has-submenu"><span
						class="fa fa-table"></span>도시</a></li>
				<li><a href="thema.jsp"><span class="fa fa-sitemap"></span>테마</a></li>
				<li><a href="place.jsp"><span class="fa fa-money"></span>명소</a></li>
				<li><a href="food.jsp"><span class="fa fa-user-o"></span>맛집</a></li>

			</ul>
		</div>
		<!--     SIDE AREA -->
		<%
			request.setCharacterEncoding("UTF-8");
			ArrayList<Food_placeDto> list = (ArrayList<Food_placeDto>) request.getAttribute("articleList");
			/* out.print("<input type='hidden' id=size value="+list.size()+">");
			out.print(list.size());
			if(articleList != null && listCount > 0){
			for(int i=0; i<list.size(); i++) */
		%>
		<div class="a">
			<div class="s"></div>
			<%-- <a href=placedetail.jsp?num=<%=list.get(i).getNum()%>&page=<%=nowPage%> class="card_link"> --%>
			<table>
				<tr>
					<th colspan="2"><br> <br> <br> <span><img
							src=img/point1.PNG style="width: 30px; height: 30px;">카피올라니
							공원 <%-- <%= list.get(i).getTitle()%> --%></span></th>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><br> <br>
						<span><img src=img/kapiolani_park.jpg
							style="width: 500px; height: 500px;"> <%-- <%= list.get(i).getPic() %> --%></span>
					</td>
				</tr>
				<tr>

					<td><span><img src=img/tel1.PNG
							style="width: 30px; height: 30px;"></td>
					<td style="text-align: left;">33-115-487-41215 <%-- <%= list.get(i).getTel() %> --%>
						</span></td>
				</tr>
				<tr>
					<td><span><img src=img/clock1.PNG
							style="width: 30px; height: 30px;"></td>
					<td style="text-align: left;">09:00am-10:00pm <%-- <%= list.get(i).getTime() %> --%>
						</span>
					</td>
				</tr>

				<tr>
					<td><span><img src=img/loca1.PNG
							style="width: 30px; height: 30px;"></td>
					<td style="text-align: left;">위치 설명 <%-- <%= list.get(i).getPlace() %> --%>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="2"><span><img src=img/text1.PNG
							style="width: 30px; height: 30px;"> 본문 내용<br></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: left;">sadf sadf<br>
						sadf<br> sadf<br> sadfsda<br> f<br> sad<br>
						fa<br> s<br> </span></td>
				</tr>
			</table>
	</section>
	<footer>
		제작자 : 박하영, 홍준영, 한상혁<br> copyright © TOURTIPS Inc. All rights
		Reserved.
	</footer>
</body>
</html>