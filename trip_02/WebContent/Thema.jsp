<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="vo.ThemaDto"%>
<%@ page import="vo.PageInfo"%>
<%@ page import="dao.ThemaDao"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thema</title>
</head>
<body>
<style>
/*테마선택카드*/
.gallery{/*테마카드 위치조절*/
width:80%;
height:1600px;
position:absolute;
left:20%;
top:880px;
box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
text-align:center;
}


.view {
  width: 267px;
  height: 400px;
  margin:45px;
  margin-left: 80px;
  float: left;
  border-top: 1px solid #ccc;
  border-left: 1px solid #ccc;
  border-right: 5px solid #ccc;
  border-bottom: 5px solid #ccc;
  overflow: hidden;
  position: relative;
  top:10px;
  left:10%;
  text-align: center;
  box-shadow: 1px 1px 2px #e6e6e6;
  cursor: default;
}

.view .mask, .view .content {
  width: 267px;
  height: 400px;
  position: absolute;
  overflow: hidden;
  top: 0;
  left: 0;
}

.view img {
  display: block;
  position: relative;
  max-width: 100%;
}

.view h2 {
  text-transform: uppercase;
  color: white;
  text-align: center;
  position: relative;
  font-size: 17px;
  padding: 10px;
  background: rgba(0, 0, 0, 0.8);
  margin: 20px 0 0 0;
}

.view p {
  font-family: Georgia, serif;
  font-style: italic;
  font-size: 12px;
  position: relative;
  color: #fff;
  padding: 10px 20px 20px;
  text-align: center;
}

.view a.info {
  display: inline-block;
  text-decoration: none;
  padding: 7px 14px;
  background: #000;
  color: #fff;
  text-transform: uppercase;
  box-shadow: 0 0 1px #000;
  -webkit-box-shadow: 0 8px 6px -6px black;
  -moz-box-shadow: 0 8px 6px -6px black;
  box-shadow: 0px 8px 6px -6px black;
}

.view a.info:hover {
  box-shadow: 0 0 5px #000;
}

.view img {
  -webkit-transition: all 0.4s ease-in-out 0.5s;
  -moz-transition: all 0.4s ease-in-out 0.5s;
  -o-transition: all 0.4s ease-in-out 0.5s;
  -ms-transition: all 0.4s ease-in-out 0.5s;
  transition: all 0.4s ease-in-out 0.5s;
}

.view .mask {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=0)";
  filter: alpha(opacity=0);
  opacity: 0;
  -webkit-transition: all 0.3s ease-in 0.4s;
  -moz-transition: all 0.3s ease-in 0.4s;
  -o-transition: all 0.3s ease-in 0.4s;
  -ms-transition: all 0.3s ease-in 0.4s;
  transition: all 0.3s ease-in 0.4s;
}

.view h2 {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=0)";
  filter: alpha(opacity=0);
  opacity: 0;
  border-bottom: 1px solid rgba(0, 0, 0, 0.3);
  background: transparent;
  margin: 20px 40px 0px 40px;
  -webkit-transform: scale(10);
  -moz-transform: scale(10);
  -o-transform: scale(10);
  -ms-transform: scale(10);
  transform: scale(10);
  -webkit-transition: all 0.3s ease-in-out 0.1s;
  -moz-transition: all 0.3s ease-in-out 0.1s;
  -o-transition: all 0.3s ease-in-out 0.1s;
  -ms-transition: all 0.3s ease-in-out 0.1s;
  transition: all 0.3s ease-in-out 0.1s;
}

.view p {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=0)";
  filter: alpha(opacity=0);
  opacity: 0;
  -webkit-transform: scale(10);
  -moz-transform: scale(10);
  -o-transform: scale(10);
  -ms-transform: scale(10);
  transform: scale(10);
  -webkit-transition: all 0.3s ease-in-out 0.2s;
  -moz-transition: all 0.3s ease-in-out 0.2s;
  -o-transition: all 0.3s ease-in-out 0.2s;
  -ms-transition: all 0.3s ease-in-out 0.2s;
  transition: all 0.3s ease-in-out 0.2s;
}

.view a.info {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=0)";
  filter: alpha(opacity=0);
  opacity: 0;
  -webkit-transform: translateY(100px);
  -moz-transform: translateY(100px);
  -o-transform: translateY(100px);
  -ms-transform: translateY(100px);
  transform: translateY(100px);
  -webkit-transition: all 0.3s ease-in-out 0.1s;
  -moz-transition: all 0.3s ease-in-out 0.1s;
  -o-transition: all 0.3s ease-in-out 0.1s;
  -ms-transition: all 0.3s ease-in-out 0.1s;
  transition: all 0.3s ease-in-out 0.1s;
}

.view:hover .mask {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=100)";
  filter: alpha(opacity=100);
  opacity: 1;
  -webkit-transition-delay: 0s;
  -moz-transition-delay: 0s;
  -o-transition-delay: 0s;
  -ms-transition-delay: 0s;
  transition-delay: 0s;
}

.view:hover img {
  -webkit-transition-delay: 0s;
  -moz-transition-delay: 0s;
  -o-transition-delay: 0s;
  -ms-transition-delay: 0s;
  transition-delay: 0s;
}

.filter-gray img {
  -webkit-filter: grayscale(100%);
  -moz-filter: grayscale(100%);
  filter: grayscale(100%);
}

.view:hover h2 {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=100)";
  filter: alpha(opacity=100);
  opacity: 1;
  -webkit-transform: scale(1);
  -moz-transform: scale(1);
  -o-transform: scale(1);
  -ms-transform: scale(1);
  transform: scale(1);
  -webkit-transition-delay: 0.1s;
  -moz-transition-delay: 0.1s;
  -o-transition-delay: 0.1s;
  -ms-transition-delay: 0.1s;
  transition-delay: 0.1s;
}

.view:hover p {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=100)";
  filter: alpha(opacity=100);
  opacity: 1;
  -webkit-transform: scale(1);
  -moz-transform: scale(1);
  -o-transform: scale(1);
  -ms-transform: scale(1);
  transform: scale(1);
  -webkit-transition-delay: 0.2s;
  -moz-transition-delay: 0.2s;
  -o-transition-delay: 0.2s;
  -ms-transition-delay: 0.2s;
  transition-delay: 0.2s;
}

.view:hover a.info {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=100)";
  filter: alpha(opacity=100);
  opacity: 1;
  -webkit-transform: translateY(0px);
  -moz-transform: translateY(0px);
  -o-transform: translateY(0px);
  -ms-transform: translateY(0px);
  transform: translateY(0px);
  -webkit-transition-delay: 0.3s;
  -moz-transition-delay: 0.3s;
  -o-transition-delay: 0.3s;
  -ms-transition-delay: 0.3s;
  transition-delay: 0.3s;
}

#thmamenu{
position:absolute;
top:800px;
left:35%;
height:80px;
width:800px;
}
#thmamenu a{
font-size:20px;
color:gray;
margin-right:80px;
}
</style>
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
String path="./upload/";
if(articleList != null && listCount > 0){
for(int i=0; i<list.size(); i++){%>
<div class="view">
  <img src="<%=path%>/<%=list.get(i).getPic()%>" width="100%" height="100%"/>
  <div class="mask">
    <h2><%=list.get(i).getTitle()%></h2>
    <p><%=list.get(i).getContents()%></p>
    <a href="ThemaView.do?num=<%=list.get(i).getNum()%>&page=<%=nowPage%>" class="info">Read More</a>
  </div>
</div>
<%}%>
<div id="pageList">
		<%if(nowPage<=1){ %>
		
		<%}else{ %>
		<a href="Thema.do?page=<%=nowPage-1 %>">[이전]</a>&nbsp;
		<%} %>

		<%for(int a=startPage;a<=endPage;a++){
				if(a==nowPage){%>
		[<%=a %>]
		<%}else{ %>
		<a href="Thema.do?page=<%=a %>">[<%=a %>]
		</a>&nbsp;
		<%} %>
		<%} %>

		<%if(nowPage>=maxPage){ %>
		
		<%}else{ %>
		<a href="Thema.do?page=<%=nowPage+1 %>">[다음]</a>
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