<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="vo.ThemaDto"%>
<%@ page import="vo.PageInfo"%>
<%@ page import="dao.ThemaDao"%>
<%@ page import="java.util.ArrayList" %>
<link rel="stylesheet" href="css/Thema.css?ver=1.4">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thema</title>
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
<!-- 메인배너   -->
<div class="mainbox" >
<img src="img/08.jpg"width="100%" height="500"/>
</div>
<!-- 메인카테고리메뉴   -->
<div id="thmamenu">
<a href="Thema.do?">전체보기</a><a href="Thema.do?category=가족">가족</a> <a href="Thema.do?category=연인">연인</a> <a href="Thema.do?category=힐링">힐링</a> <a href="Thema.do?category=익사이팅">익사이팅</a>
</div>
<!-- 테마카드 -->
<div class="gallery">  
<%
ArrayList<ThemaDto> articleList=(ArrayList<ThemaDto>)request.getAttribute("articleList");
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
int listCount=pageInfo.getListCount();
int nowPage=pageInfo.getPage();
int maxPage=pageInfo.getMaxPage();
int startPage=pageInfo.getStartPage();
int endPage=pageInfo.getEndPage();

request.setCharacterEncoding("UTF-8");
ArrayList<ThemaDto> list=(ArrayList<ThemaDto>)request.getAttribute("articleList");
//out.print(list.size());
if(articleList != null && listCount > 0){
for(int i=0; i<list.size(); i++){%>
<div class="view">
  <img id="pic" src="img/<%=list.get(i).getPic()%>" width="100%" height="100%"/>
  <div class="mask">
  
    <a href="ThemaView.do?num=<%=list.get(i).getNum()%>&page=<%=nowPage%>" class="info">Go</a>
  </div>
</div>
<%}%>
<div id="pageList">
<ul class="pagination">
		<%if(nowPage<=1){ %>
		
		<%}else{ %>
		<li class="page-item"><a a id="page-id2" href="Thema.do?page=<%=nowPage-1 %>">[이전]</a></li>&nbsp;
		<%} %>

		<%for(int a=startPage;a<=endPage;a++){
				if(a==nowPage){%>
		<li class="page-item"><a id="page-id" href="Thema.do?page=<%=a %>"><%=a %></a></li>
		<%}else{ %>
		<li class="page-item"><a id="page-id" href="Thema.do?page=<%=a %>"><%=a %></a></li>&nbsp;
		<%} %>
		<%} %>

		<%if(nowPage>=maxPage){ %>
		
		<%}else{ %>
		<li class="page-item"><a a id="page-id2" href="Thema.do?page=<%=nowPage+1 %>">[다음]</a></li>
		<%} %>
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
</div>

</section>
</body>
</html>