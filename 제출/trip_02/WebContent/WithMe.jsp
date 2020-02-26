<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="vo.WithMeBean"%>
<%@ page import="vo.PageInfo"%>
<%@ page import="dao.WithMeDao"%>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<WithMeBean> articleList=(ArrayList<WithMeBean>)request.getAttribute("articleList");
    PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int listCount=pageInfo.getListCount();
	int nowPage=pageInfo.getPage();
	int maxPage=pageInfo.getMaxPage();
	int startPage=pageInfo.getStartPage();
	int endPage=pageInfo.getEndPage();
%>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>WithMe</title>




 </head>
 <body>


  <%
  	String ses=null;
     ses=(String)session.getAttribute("ID");
     if(ses==null){
  %>
 <jsp:include page="header.jsp"/>
 <%
 	} else{
 %>
 <jsp:include page="Loginheader.jsp"/>
 <%
 	}
 %>
 
 
 <section>
 <!-- 메인배너   -->
 <link rel="stylesheet" href="css/withme.css?ver=1.4">
<!-- 메인배너   -->
<div class="mainbox" >
<img src="img/08.jpg"width="100%" height="500"/></div>

<div class="container">

			<!--     SIDE AREA -->
			<div class="sideArea">


				<ul class="sideMenu">
					<li><a href="WithMe.do" class="has-submenu"><span
							class="fa fa-table"></span>함께해요</a></li>
					<li><a href="infoandtip.my?command=list&category=hugi"><span class="fa fa-sitemap"></span>여행후기</a></li>
					<li><a href="infoandtip.my?command=list&category=infoandtip"><span class="fa fa-money"></span>정보&팁</a></li>
					<li><a href="infoandtip.my?command=list&category=qa"><span class="fa fa-user-o"></span>Q&A</a></li>

				</ul>
			</div>
			<!--     SIDE AREA -->

		</div>
		</div>

		<h2 id="id">함께해요 게시판</h2>
		<br> <br>
		<hr>
<div id="withmebox">
<%
request.setCharacterEncoding("UTF-8");
ArrayList<WithMeBean> list=(ArrayList<WithMeBean>)request.getAttribute("articleList");
out.print("<input type='hidden' id=size value="+list.size()+">");
String path="./upload/";
if(articleList != null && listCount > 0){
for(int i=0; i<list.size(); i++){
	String st="모집중";
if(list.get(i).getPeoplecount()==list.get(i).getPeople()){
	st="마감";
}
%>
 <div class="card card--1">
  <div class="card__img"></div>
  <a href="WithMeDetail.do?num=<%=list.get(i).getNum()%>&page=<%=nowPage%>" onclick="return sessionIDcheck(<%=ses%>)" class="card_link">
  <div class="card__img--hover" style=background-image:url("<%=path%><%=list.get(i).getPhoto()%>");></div>
  </a>
  <div class="card__info">
    <span class="card__category"><%=list.get(i).getTitle()%></span>
    <h5 class="card__title">모집인원 :<%=list.get(i).getPeoplecount() %> / <%=list.get(i).getPeople() %></h5>    
	<h5 class="card__title">만남일 : <%=list.get(i).getDate()%></h5>
	<h5 class="card__title">마감일 : <%=list.get(i).getLimitdate()%></h5>
    <span class="card__by">by <label class="card__author" title="author"><%=list.get(i).getWriter()%></label></span>
	<label class="setting" title="author"><%=st%></label>
  </div>
</div>
<%} %>
</div>
<input type="hidden" id="sessionID" value="${ID}"/>
<input type="button" onclick="Write()" name="write" id="btnwrite" value="글쓰기" />
<div id="pageList">
		<%if(nowPage<=1){ %>
		
		<%}else{ %>
		<a href="WithMe.do?page=<%=nowPage-1 %>">[이전]</a>&nbsp;
		<%} %>

		<%for(int a=startPage;a<=endPage;a++){
				if(a==nowPage){%>
		[<%=a %>]
		<%}else{ %>
		<a href="WithMe.do?page=<%=a %>">[<%=a %>]
		</a>&nbsp;
		<%} %>
		<%} %>

		<%if(nowPage>=maxPage){ %>
		
		<%}else{ %>
		<a href="WithMe.do?page=<%=nowPage+1 %>">[다음]</a>
		<%} %>
	</div>
	<%
    }
	else
	{
	%>
	<div id="emptyArea">등록된 글이 없습니다.</div>
    <input type="button" onclick="Write()" name="write" id="btnwrite" value="글쓰기" />
	<%
	}
%>
<script>
function sessionIDcheck(id){
	if(id==null){
		alert("로그인이 필요합니다");
		return false;
	}
	return true;
}

function Write(){//글쓰기누를시 페이지이동
	var id=$("#sessionID").val();
	if(id!=""){
		location.href="WithMeWrite.jsp";
		return true;
	}
	alert("로그인이 필요합니다");
	return false;
}
</script>
 </section>
 </body>

</html>
