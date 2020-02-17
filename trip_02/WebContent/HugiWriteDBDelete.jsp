<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.boardDto"%>
<%@ page import="dao.boardDao"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HugiWriteDBDelete</title>
</head>
<body>
<jsp:useBean id="board" class="dao.boardDao"/>
<%
String num=request.getParameter("number");
//out.print(num);
board.BoardDelete(num);
out.print("<script>location.href='Hugi.jsp'</script>");
%>
</body>
</html>