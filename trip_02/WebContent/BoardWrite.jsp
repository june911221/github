<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardWrite</title>
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
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<script src="js/BoardWrite.js"></script>
<link rel="stylesheet" href="css/BoardWrite.css?ver=1.3">

<div id="id">게시물 등록</div>
<hr>

<form action="insert.my?command=insert" onsubmit="return boardcheck()" method="post">

<table class="write_table">
<tr>
<th>카테고리</th>
<td><select class="sel" name="category" id="category">
<option id="op" value="none" selected>카테고리를 선택하세요</option>
<option id="op"  value="여행후기">여행후기</option>
<option id="op"  value="정보&팁">정보&팁</option>
<option id="op"  value="Q&A">Q&A</option>
</select>
</td>
</tr>
<tr>
<th>글쓴이</th>
<td><input type="text" id="writer" name="writer" value="${ID}" readonly/></td>
</tr>
<tr>
<th>제목</th>
<td><input type="text" id="title" name="title" size="80"/></td>
</tr>
<tr>
<th>내용</th>
<td><textarea id="contents" name="contents"></textarea></td>

</tr>
</table>
<input id="ok" type="submit" value="등록"/><input  id="re" type="button" value="취소" onClick="history.go(-1)"/>

</form>

</section>
</body>
</html>