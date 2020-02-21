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
<form action="insert.my?command=insert" onsubmit="return boardcheck()" method="post">
카테고리:
<select class="sel" name="category" id="category">
<option value="none" selected>카테고리를 선택하세요</option>
<option value="여행후기">여행후기</option>
<option value="정보&팁">정보&팁</option>
<option value="Q&A">Q&A</option>
</select>
글쓴이:<input type="text" id="writer" name="writer" value="${ID}" readonly/>
제목:<input type="text" id="title" name="title"/>
내용:<textarea id="contents" name="contents"></textarea>
<input type="submit" value="등록"/>
</form>

</section>
</body>
</html>