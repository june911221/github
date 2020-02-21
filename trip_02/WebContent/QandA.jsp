<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="vo.BoardDto"%>
<!DOCTYPE html>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A</title>
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

<table class="sub_news" border="1" cellspacing="0">
<caption>정보 & TIP</caption>
<thead>
<tr>
<th width="50">글번호</th>
<th width="170">카테고리</th>
<th width="250">제목</th>
<th width="170">글쓴이</th>
<th width="170">날짜</th>
<th width="170">조회수</th>
</tr>
</thead>
<% ArrayList<BoardDto> list = (ArrayList<BoardDto>)request.getAttribute("data");
out.print("<input type='hidden' id=size value="+list.size()+">");
for (int i=0; i<list.size(); i++){
	out.print("<tr id='tr_hover'><td>"+list.get(i).getNum()+"</td>");
	out.print("<td>"+list.get(i).getCategory()+"</td>");
	out.print("<td><label class='newimg' id='newimg"+i+"'>new</label><a href='BoardView.my?command=view&num="+list.get(i).getNum()+"&hits="+list.get(i).getHits()+"'>"+list.get(i).getTitle()+"</a></td>");
	out.print("<td>"+list.get(i).getWriter()+"</td>");
	out.print("<td>"+list.get(i).getDate()+"</td>");
	out.print("<td>"+list.get(i).getHits()+"</td>");
	out.print("<input type='hidden' id='date"+i+"' value='"+list.get(i).getDate()+"'>");//hidden타입에 value값으로 날자를 넣어 스크립트에서 비교하기
}
%>
<input type="hidden" value="${ID}" id="sessioncheck"/>
</table>
<input type="button" onclick="writepage()" value="글쓰기"/>
</body>
</html>