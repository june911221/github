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
  <h1>ȸ �� Ż ��</h1>
  <div class="info_text">�ѹ� ȸ��Ż�� �̷������ ������ ������ �� �����ϴ�.<br><br>ȸ��Ż�� �����Ͻ÷��� ȸ�����̵�� ��й�ȣ�� �Է����ּ���.</div>
  <input type="hidden" id="x" name="x" value="">
  <input type="text" id="userid" name="userid" value="${ID}" readonly>
  <br>
  <input type="password" placeholder="��й�ȣ�� �Է��ϼ���." id="password" name="password">
<input type="button" id="Delbtn" name="Delbtn" value="ȸ �� Ż ��" onclick="del()">
<input type="button" id="mainbtn" name="mainbtn" value="�� �� �� ��" onclick="location='index.jsp'">
</form>
  
</div>
</section>
</body>
</html>