<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ page import="vo.ThemaDto"%>
<%@ page import="dao.ThemaDao"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Date" %>
<%
request.setCharacterEncoding("UTF-8");
ThemaDto view = (ThemaDto)request.getAttribute("article");
String title=view.getTitle();
String contents=view.getContents();
String category=view.getCategory();
String pic=view.getPic();
String Page = (String)request.getParameter("page");
String path="./upload/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<img src="<%=path%>/<%=pic%>" width="300" height="300">
카테고리:<input type="text" value="<%=category%>" readonly>
제목:<input type="text" value="<%=title%>">
내용:<input type="text" value="<%=contents%>">

</section>
</body>
</html>