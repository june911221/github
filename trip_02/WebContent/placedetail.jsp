<%@page import="vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.Food_placeDto"%>
<%@ page import="vo.PageInfo"%>
<%@ page import="dao.Food_placeDao"%>
<%@ page import="java.util.ArrayList"%>
<jsp:useBean id="view" class="dao.Food_placeDao"></jsp:useBean>
<%
	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("num"));
	Food_placeDto dto = (Food_placeDto) view.SelectPlace(num);
	String title = dto.getTitle();
	String contents = dto.getContents();
	String pic = dto.getPic();
	String place = dto.getPlace();
	String tel = dto.getTel();
	String time = dto.getTime();
	String subtitle = dto.getSubtitle();
	String category = dto.getCategory();
	String cityname = dto.getCityname();
%>

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

		<div class="a">
			<div class="s"></div>
			<%-- <a href=placedetail.jsp?num=<%=list.get(i).getNum()%>&page=<%=nowPage%> class="card_link"> --%>
			<table>
				<tr>
					<th colspan="2"><br> <br> <br> <span><img
							src=img/point1.PNG style="width: 30px; height: 30px;"> <%=title%></span></th>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><br> <br>
						<span><img src=img/<%=pic%>
							style="width: 500px; height: 500px;"></span></td>
				</tr>
				<tr>

					<td><span><img src=img/tel1.PNG
							style="width: 30px; height: 30px;"></td>
					<td style="text-align: left;"><%=tel%> </span></td>
				</tr>
				<tr>
					<td><span><img src=img/clock1.PNG
							style="width: 30px; height: 30px;"></td>
					<td style="text-align: left;"><%=time%> </span></td>
				</tr>

				<tr>
					<td><span><img src=img/loca1.PNG
							style="width: 30px; height: 30px;"></td>
					<td style="text-align: left;"><%=place%> </span></td>
				</tr>
				<tr>
					<td colspan="2"><span><img src=img/text1.PNG
							style="width: 30px; height: 30px;"> 본문 내용<br></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: left; color:gray; "><h2><%=subtitle%></h2><br><br></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: left;"><%=contents%> </span></td>
				</tr>
			</table>
	</section>
	<footer>
		제작자 : 박하영, 홍준영, 한상혁<br> copyright © TOURTIPS Inc. All rights
		Reserved.
	</footer>
</body>
</html>