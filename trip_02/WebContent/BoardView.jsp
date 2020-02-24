<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.sql.Date" %>
<%@page import="vo.BoardDto"%>
<%@page import="vo.CommentDto"%>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="js/BoardView2.js"></script>
<link rel="stylesheet" href="css/BoardView.css?ver=1.5">

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>InfoandTipView</title>
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
<% 
ArrayList<BoardDto> list = (ArrayList<BoardDto>)request.getAttribute("data");
int num=list.get(0).getNum();
String category=list.get(0).getCategory();
String title=list.get(0).getTitle();
String writer=list.get(0).getWriter();
Date date=list.get(0).getDate();
int hits=list.get(0).getHits();
String contents=list.get(0).getContents();
%>

<input type="hidden" name="sessionID" id="sessionID" value=${ID}>
<form  method="post" id="tipView">
<input type="hidden" id="num" name="num" value="<%=num%>">

<div id="cate_info"><%=category%> 게시글</div>

<table class="write_table">
<tr>
<th>카테고리</th>
<td><input type="text" id="category"name="category" value="<%=category%>" readonly></td>
</tr>
<tr>
<th>제목</th>
<td><input type="text" id="title" name="title" value="<%=title%>" size="100" readonly></td>
</tr>
<tr>
<th>글쓴이</th>
<td><input type="text" id="writer" name="writer" value="<%=writer%>" readonly></td>
</tr>
<tr>
<th>date</th>
<td><%=date%></td>
</tr>
<tr>

<input type="hidden" id="hits" name="hits" value="<%=hits%>" readonly>
</tr>
<tr>
<th>내용</th>
<td><textarea id="contents" name="contents"><%=contents%></textarea><div id="view"><%=contents%></div></td>
</tr>
<tr>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
</tr>
</table>
<input type=button id="list" onclick="history.go(-1)" value="목록으로" />
<input type="hidden" id="update" onclick="return updata()" value="수정" >
<input type="hidden" id="delete" onclick="delclick()" value="삭제">

</form>

<hr>

<h1>COMMENT</h1>
<div class="comments">
<form method="post" id="commentwrite">
<input type="hidden" name="bnum" value="<%=num%>">
<input type="hidden" name="commentwriter" value="${ID}">
<input type="text" id="comment_box" name="comment_box">
<input type="button" id="comments_btn" onclick="return commentcheck()" value="등록">
</form>
</div>

<%
ArrayList<CommentDto> commentlist = (ArrayList<CommentDto>)request.getAttribute("codata");

for(int i=0;i<commentlist.size();i++){%>

<div id="commentlist">
<input type="text" class="com_writer" id="writer<%=commentlist.get(i).getC_number()%>" readonly value="<%=commentlist.get(i).getWriter()%>">
<input type="text" class="com_cobox" id="cobox<%=commentlist.get(i).getC_number()%>" readonly value="<%=commentlist.get(i).getComment_box()%>">
<a href="" id="com_update" onclick="return commentup(<%=commentlist.get(i).getC_number()%>)">수정</a>
<a href=".my?command=commentdel&bnum=<%=commentlist.get(i).getB_number()%>&commentnum=<%=commentlist.get(i).getC_number()%>" id="com_delete" onclick="return commentdel(<%=commentlist.get(i).getC_number()%>)">삭제</a>

</div>
<%}%>
</section>
</body>
</html>