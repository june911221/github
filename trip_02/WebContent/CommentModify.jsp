<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="vo.CommentDto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CommentModify</title>
</head>
<body>
<%
ArrayList<CommentDto> commentlist = (ArrayList<CommentDto>)request.getAttribute("commentdata");
String comment=commentlist.get(0).getComment_box();
int commentnum=commentlist.get(0).getC_number();
int boardnum=commentlist.get(0).getB_number();
%>
<form action=".my?command=commentupdate&commnetnum=<%=commentnum%>&bnum=<%=boardnum%>" onsubmit="return Modify()" target="commentModifyform" method="post">
<textarea rows="7" cols="70" name="comment_box" id="comment_box"><%=comment%></textarea>
<input type="submit" value="수정">
</form>
<script>
function Modify(){ //댓글 수정 컨펌 
	
	var result =confirm("수정 하시겠습니까?");	
	if(result){
		self.close();//댓글수정을 완료한뒤 팝업창은 닫아준다 form에 지정한 target은 부모창의 이름이다
		return true;
	}
	return false;
}
</script>
</body>
</html>