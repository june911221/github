<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.sql.Date" %>
<%@page import="vo.BoardDto"%>
<%@page import="vo.CommentDto"%>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="js/BoardView.js"></script>
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
카테고리:<input type="text" id="category"name="category" value="<%=category%>" readonly>
제목:<input type="text" id="title" name="title" value="<%=title%>" readonly>
글쓴이:<input type="text" id="writer" name="writer" value="<%=writer%>" readonly>
date:<input type="text" id="date" name="date" value="<%=date%>" readonly>
<input type="hidden" id="hits" name="hits" value="<%=hits%>" readonly>
내용:<div><%=contents%></div>
<input type="text" id="contents" name="contents" value="<%=contents%>">
<input type="hidden" id="update" onclick="return updata()" value="수정" >
<input type="hidden" id="delete" onclick="delclick()" value="삭제">
</form>

<form method="post" id="commentwrite">
<input type="hidden" name="bnum" value="<%=num%>">
<input type="hidden" name="commentwriter" value="${ID}">
댓글:<input type="text" id="comment_box" name="comment_box">
<input type="button" onclick="return commentcheck()" value="등록">
</form>

<%
ArrayList<CommentDto> commentlist = (ArrayList<CommentDto>)request.getAttribute("codata");

for(int i=0;i<commentlist.size();i++){%>

<input type="text" id="writer<%=commentlist.get(i).getC_number()%>" readonly value="<%=commentlist.get(i).getWriter()%>">
<input type="text" id="cobox<%=commentlist.get(i).getC_number()%>" readonly value="<%=commentlist.get(i).getComment_box()%>">
<a href="" onclick="return commentup(<%=commentlist.get(i).getC_number()%>)">수정</a>
<a href=".my?command=commentdel&bnum=<%=commentlist.get(i).getB_number()%>&commentnum=<%=commentlist.get(i).getC_number()%>" onclick="return commentdel(<%=commentlist.get(i).getC_number()%>)">삭제</a>

<%}%>
</section>
</body>
</html>