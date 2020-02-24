<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.BoardDto"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.sql.Date"%>
<!doctype html>
<!-- CSS -->
<link rel="stylesheet" href="css/Hugi.css?ver=1.3">
<!-- js -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="./js/Hugi1.js"></script>

<html>
<head>
<meta charset="UTF-8">

<title>Hugi</title>
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
				<li><a href="WithMe.do" class="has-submenu"><span
						class="fa fa-table"></span>함께해요</a></li>
				<li><a href="infoandtip.my?command=list&category=hugi"><span
						class="fa fa-sitemap"></span>여행후기</a></li>
				<li><a href="infoandtip.my?command=list&category=infoandtip"><span
						class="fa fa-money"></span>정보&팁</a></li>
				<li><a href="infoandtip.my?command=list&category=qa"><span
						class="fa fa-user-o"></span>Q&A</a></li>

			</ul>
		</div>
		<!--     SIDE AREA -->

		<!--banner -->

		<img id="hugi_banner" src="img/hugi_banner.jpg" width="100%" height="300"> 
			<img id="hugi_banner2" src="img/thum.jpg" width="55%" height="300">

		<!--banner -->

		<h2 id="id">여행후기 게시판</h2>
		<hr>
		
		<!--검색 및 조회-->
		<input type="hidden" name="sessioncheck" id="sessioncheck"
			value=<%=ses%>> <input type=button onclick="writepage()"
			name="write" id="btnwrite" value="글쓰기"/>
		<div id="scbox">
			<form action="Hugi.jsp" onsubmit="return search()" method="post">
				<select class="sel" name="Boardselectmenu" id="Boardselectmenu">
					<option id="op" value="none" selected>전체</option>
					<option id="op" value="title_contents">제목+내용</option>
					<option id="op" value="title">제목</option>
					<option id="op" value="contents">내용</option>
					<option id="op" value="writer">작성자</option>
				</select> <input type="text" value="" name="searchinfo" id="searchinfo">
				<input id="search" type="submit" value="검색">
		</div>
		</form>
		<!--검색 및 조회 -->

		<!--table -->
		<table class="sub_news" border="1" cellspacing="0">
			<thead>
				<tr>
					<th width="40px;">글번호</th>
					<th width="40px">카테고리</th>
					<th width="150px;">제목</th>
					<th width="70px;">글쓴이</th>
					<th width="50px;">날짜</th>
					<th width="50px;">조회수</th>
				</tr>
			</thead>
			<%
				/* String opt=null;
				String text=null;
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				opt=(String)request.getParameter("Boardselectmenu");
				text=(String)request.getParameter("searchinfo");
				//out.print(opt+"   "+text);
				if(text==""||opt==null||text==null){//검색어가 없거나 셀렉트값이 없으면 리스트 전체 순서대로 출력
				ArrayList<boardDto> list=board.List();
				out.print("<input type='hidden' id=size value="+list.size()+">");
				//out.print(list.size());
				
				for(int i=0; i<list.size(); i++){
				out.print("<tr id='tr_hover'>"+"<td width=100 align=center>"+list.get(i).getNum()+"</td>");
				out.print("<td width=100 align=center>"+list.get(i).getCategory()+"</td>");
				out.print("<td width=100 align=center>"+"<label class='newimg' id='newimg"+i+"'>new</label>"+"<a href='HugiContentsView.jsp?NO="+list.get(i).getNum()+"&hits="+list.get(i).getHits()+"'>"+list.get(i).getTitle()+"</a>"+"</td>");
				out.print("<td width=100 align=center>"+list.get(i).getWriter()+"</td>");
				out.print("<td width=100 align=center>"+list.get(i).getDate()+"</td>");
				out.print("<td width=150 align=center>"+list.get(i).getHits()+"</td>"+"<tr>");
				out.print("<input type='hidden' id='date"+i+"' value='"+list.get(i).getDate()+"'>");//hidden타입에 value값으로 날자를 넣어 스크립트에서 비교하기
				}
				}
				else{//검색에따른 리스트 출력 
				 ArrayList<boardDto> list=board.List(opt,text);
				 for(int i=0; i<list.size(); i++){
				out.print("<tr>"+"<td width=100 align=center>"+list.get(i).getNum()+"</td>");
				out.print("<td width=100 align=center>"+list.get(i).getCategory()+"</td>");
				out.print("<td width=100 align=center>"+"<a href='HugiContentsView.jsp?NO="+list.get(i).getNum()+"&hits="+list.get(i).getHits()+"'>"+list.get(i).getTitle()+"</a>"+"</td>");
				out.print("<td width=100 align=center>"+list.get(i).getWriter()+"</td>");
				out.print("<td width=100 align=center>"+list.get(i).getDate()+"</td>");
				out.print("<td width=150 align=center>"+list.get(i).getHits()+"</td>"+"<tr>");
					 }
				} */
			%>
			<%
				ArrayList<BoardDto> list = (ArrayList<BoardDto>) request.getAttribute("data");
			out.print("<input type='hidden' id=size value=" + list.size() + ">");
				for (int i = 0; i < list.size(); i++) {
					out.print("<tr id='tr_hover'><td>" + list.get(i).getNum() + "</td>");
					out.print("<td>" + list.get(i).getCategory() + "</td>");
					out.print("<td><label class='newimg' id='newimg" + i
							+ "'>new</label><a href='BoardView.my?command=view&num=" + list.get(i).getNum() + "&hits="
							+ list.get(i).getHits() + "'>" + list.get(i).getTitle() + "</a></td>");
					out.print("<td>" + list.get(i).getWriter() + "</td>");
					out.print("<td>" + list.get(i).getDate() + "</td>");
					out.print("<td>" + list.get(i).getHits() + "</td>");
					out.print("<input type='hidden' id='date" + i + "' value='" + list.get(i).getDate() + "'>");//hidden타입에 value값으로 날자를 넣어 스크립트에서 비교하기
				}
			%>
		</table>
		<!--table -->
	</section>

</body>
</html>
