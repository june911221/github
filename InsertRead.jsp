<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">

  <title>정보 관리</title>
 </head>
 <body>
  <h4>정보가 입력되었습니다.<h4>
  입력된 정보를 조회하려면 아래의 링크를 클릭하시오.<br><br>
  <a href=databaseconn2.jsp?id=<%= request.getParameter("id") %>>정보 조회</a>
 </body>
</html>
