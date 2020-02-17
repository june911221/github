<%@page import="vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.Food_placeDto"%>
<%@ page import="vo.PageInfo"%>
<%@ page import="dao.Food_placeDao"%>
<%@ page import="java.util.ArrayList"%>

<%request.setCharacterEncoding("UTF-8");%>
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
table {
	width: 100%;
	border: 1px solid #444444;
}

th, td {
	border: 1px solid #444444;
}
</style>
</head>
<body>
	<% 
 String ses=null;
 ses=(String)session.getAttribute("ID");
 if(ses==null){%>
	<jsp:include page="header.jsp" />
	<%} else{%>
	<jsp:include page="Loginheader.jsp" />
	<%} %>

	<section>
		<%
request.setCharacterEncoding("UTF-8");
ArrayList<Food_placeDto> list=(ArrayList<Food_placeDto>)request.getAttribute("articleList");
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
					<td><span>장소명: <%-- <%= list.get(i).getTitle()%> --%></span></td>
					</tr>
					<tr>
					<td><span>대표사진:<img src=img/kapiolani_park.jpg> <%-- <%= list.get(i).getPic() %> --%></span>
					</td>
				</tr>
				<tr>
				    
					<td><span>연락처: <%-- <%= list.get(i).getTel() %> --%></span></td>
					
				</tr>
				<tr>
				    <td><span>운영시간: <%-- <%= list.get(i).getTime() %> --%></span>
					</td>
					</tr>
					<tr>
					<td><span>찾아가는 길: <%-- <%= list.get(i).getPlace() %> --%></span>
					</td>
				</tr>
				<tr>
				    <td><span>내용: sadf
				    sadf<br>
				    sadf<br>
				    sadf<br>
				    sadfsda<br>
				    f<br>
				    sad<br>
				    fa<br>
				    s<br></span></td>
				</tr>
			</table>
	</section>
	<footer>
		제작자 : 박하영, 홍준영, 한상혁<br> copyright © TOURTIPS Inc. All rights
		Reserved.
	</footer>
</body>
</html>