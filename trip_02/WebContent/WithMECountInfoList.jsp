<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="vo.With_UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>With_UserList</title>
</head>
<body>
<link rel="stylesheet" href="css/withmecountinfolist.css?ver=1">
 <div id="wrapper">
  <h1>함께해요 신청자 현황</h1>
  
  <table id="keywords" cellspacing="0" cellpadding="0">
    <thead>
      <tr>
        <th id="t_head"><span>신청자 ID</span></th>
        <th id="t_head"><span>신청 인원</span></th>
        <th id="t_head"><span>연락처</span></th>
      </tr>
    </thead>
    <tbody>
<%
ArrayList<With_UserBean> countlist = (ArrayList<With_UserBean>)request.getAttribute("articleList");

if(countlist.size()==0){%>
      <tr>
        <td colspan="3" class="lalign">아직 신청자가 없습니다</td>
      </tr>
<%}else{
for(int i=0;i<countlist.size();i++){
%>
      <tr>
        <td class="lalign" id="table_td1"><%=countlist.get(i).getId()%></td>
        <td  id="table_td2"><%=countlist.get(i).getCount()%></td>
        <td  id="table_td3"><%=countlist.get(i).getTel()%></td>
      </tr>
<%}}%>
    </tbody>
  </table>
 </div> 
</body>
</html>