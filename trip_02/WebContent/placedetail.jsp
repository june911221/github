<%@page import="vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.Food_placeDto"%>
<%@ page import="vo.PageInfo"%>
<%@ page import="dao.Food_placeDao"%>
<%@ page import="java.util.ArrayList"%>
<jsp:useBean id="view" class="dao.Food_placeDao"></jsp:useBean>
<link rel="stylesheet" href="css/placedetail.css?ver=1.1">
<%
	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("num"));
	Food_placeDto dto = (Food_placeDto) view.SelectPlace(num);//게시글 번호를 가지고 게시글내용을 뽑아와서 dto에 셋팅
	String category = dto.getCategory();
	String subtitle = dto.getSubtitle();
	String lng = dto.getLng();
	String lat = dto.getLat();
	int scrapnum = 0;
	if(session.getAttribute("ID")!=null){//로그인 아이디를 체크해서 로그인이 되어있다면 실행
     	scrapnum = (int) view.ScrapCount((String)session.getAttribute("ID"),num,category);//로그인 아이디와 게시글 번호를 가지고 게시글을 이미 스크랩했는지 유무를 판단
	}
	out.print("<input type='hidden' id='scrapnum' value='"+scrapnum+"'>");
	String title = dto.getTitle();
	String contents = dto.getContents();
	String pic = dto.getPic();
	String place = dto.getPlace();
	String tel = dto.getTel();
	String time = dto.getTime();
	String cityname = dto.getCityname();
	out.print("<script>function scraps(){");
	if (session.getAttribute("ID") == null) {
		out.print("alert('로그인이 필요합니다');");
	} else {
		out.print("SCRAP(" + num + ")");
	}
	out.print("}</script>");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=true"></script>
<title>명소</title>

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


				<div class="a">
			<div class="s"></div>
			<%-- <a href=placedetail.jsp?num=<%=list.get(i).getNum()%>&page=<%=nowPage%> class="card_link"> --%>
			<table>
				<tr>
					<th colspan="2"><br> <br> <br> <span id="title"><img
							src=img/point1.jpg id="point1" style="width: 50px; height: 50px;"> <%=title%></span><hr></th>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><br> <br>
						<span><img id="big_img" src=img/<%=pic%>
							style="width: 800px; height: 500px;"></span></td>
				</tr>				
				<tr id="line0">
                   
					<td><span><img src=img/tel2.PNG
							style="width: 40px; height: 40px;"></td>
					<td style="text-align: left;"><%=tel%> </span></td>
				</tr>
				<tr id="line1">
					<td><span><img src=img/clock2.PNG
							style="width: 40px; height: 40px;"></td>
					<td style="text-align: left;"><%=time%> </span></td>
				</tr>

				<tr id="line2">
					<td><span><img src=img/loca1.jpg
							style="width: 40px; height: 40px;"></td>
					<td style="text-align: left;"><%=place%> </span></td>
				</tr>
				<tr id="line3">
					<td colspan="2"><span><img src=img/text1.jpg
							style="width: 40px; height: 40px;"> 본문 내용<br></td>
				
				</tr>
				
				<tr>
				<td colspan="2" id="subtitle" style="text-align: left; color:gray;" ><h2><%=subtitle%></h2><br><br></td></tr>
				<tr>
					<td colspan="2" id="contents" style="text-align: left;"><%=contents%> </span></td>
				</tr>
			</table>
<input type="hidden" id="category" value="<%=category%>">
<input type="button" class="scrapbtn" id="scrap" value="스크랩" onclick="scraps()">
<input type="hidden" class="scrapbtn" id="scrapdel" value="스크랩취소" onclick="scrapdel(<%=num%>)">
<script src="js/placedetail2.js?ver=1.1"></script>	
<div id="map"></div>
    <script>
      var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: <%=lat%>, lng: <%=lng%>},
          zoom: 18
        });
      }
     
    </script>
     <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAZ_RlT_AbwseK450BB2gyyyf2EHlJ9a7E&callback=initMap"
    async defer></script>
		
		
	</section>

	<footer>
		제작자 : 박하영, 홍준영, 한상혁<br> copyright © TOURTIPS Inc. All rights
		Reserved.
	</footer>
</body>
</html>