<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>UserDelete</title>
</head>
<body>
<link rel="stylesheet" href="css/signin.css">
<link rel="stylesheet" href="css/userdel.css">
<script src="js/UserDel.js"></script>
  <% 
 String ses=null;
 ses=(String)session.getAttribute("ID");
 if(ses==null){%>
 <jsp:include page="header.jsp"/>
 <%} else{%>
 <jsp:include page="Loginheader.jsp"/>
 <%} %>

<section>
<form  method="post" id="userDel">
<div class="box">
  <h1>회 원 탈 퇴</h1>
  <div class="info_text">한번 회원탈퇴가 이루어지면 계정을 복구할 수 없습니다.<br><br>회원탈퇴를 진행하시려면 회원아이디와 비밀번호를 입력해주세요.</div>
  <input type="hidden" id="x" name="x" value="">
  <input type="text" id="userid" name="userid" value="${ID}" readonly>
  <br>
  <input type="password" placeholder="비밀번호를 입력하세요." id="password" name="password">
<input type="button" id="Delbtn" name="Delbtn" value="회 원 탈 퇴" onclick="del()">
<input type="button" id="mainbtn" name="mainbtn" value="메 인 으 로" onclick="location='index.jsp'">
</form>
  
</div>
</section>
</body>
</html>