<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.WithMeBean"%>
<%@ page import="dao.WithMeDao"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Date" %>
<%
request.setCharacterEncoding("UTF-8");
WithMeBean view = (WithMeBean)request.getAttribute("article");
String title=view.getTitle();
Date date=view.getDate();
int people=view.getPeople();
int peoplecount=view.getPeoplecount();
String lim=view.getLim();
String photo=view.getPhoto();
String pic1=view.getPic1();
String pic2=view.getPic2();
String pic3=view.getPic3();
String pic4=view.getPic4();
Date Writedate=view.getWritedate();
Date limitdate=view.getLimitdate();
String writer=view.getWriter();
String localcontenct=view.getLocalcontenct();
String contents=view.getContents();
int num=view.getNum();
String Page = (String)request.getParameter("page");
String path="./upload/";
int check = (int)request.getAttribute("check");
%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>WithMeView</title>

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
<link rel="stylesheet" href="css/WithMeView.css?ver=1.1">
<form action="" method="post" id="WithMeform" enctype="multipart/form-data">

  <div class="textboxcontainer">
      <h2>함 께 해 요</h2><br>
        
        <input type="hidden" class="taskName" name="num" id="num" value="<%=num%>">
         
        <div class="inputContainer">
          <input type="text" class="taskName" name="writer" id="writer" value="<%=writer%>" readonly>
          <label>작성자</label>
        </div>
        <div class="inputContainer">
          <input type="text" class="taskName" placeholder="제목을 입력하세요" name="title" id="title" value="<%=title%>" readonly>
          <label>제목</label>
        </div>
        <div class="inputContainer">
          <input type="text" class="taskName" placeholder="제한조건이 있으면 적어주세요" name="limit" id="limit" value="<%=lim%>" readonly>
          <label>제한조건</label>
        </div>        
        <div class="inputContainer">
          <input type="text" class="taskName" placeholder="숫자만 입력해주세요" name="people" id="people" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" value="<%=people%>" readonly>
          <label>모집인원</label>
        </div>        
        <div class="inputContainer">
          <input type="text" class="taskName" placeholder="숫자만 입력해주세요" name="peoplecount" id="peoplecount" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" value="<%=peoplecount%>" readonly>
          <label>신청인원</label>
        </div>
        <div class="inputContainer">
          <input type="text" class="taskName" placeholder="연락가능한 연락처를 적어주세요" name="localcontenct" id="localcontenct" readonly value="<%=localcontenct%>">
          <label>현지연락처</label>
        </div>				
	    <div class="inputContainer half last right">
          <input type="date" class="taskDate" name="date" id="date" value="<%=date%>" readonly>
          <label>만남일</label>
        </div>
		  <div class="inputContainer half last right">
          <input type="date"  class="taskDate" name="limitdate" id="limitdate" value="<%=limitdate%>" readonly >
          <label>마감일</label>
        </div><br><br><br><br>
        <!-- 이미지 미리보기 컨테이너  -->
<div class="image-viewer">
<!-- 파일첨부 버튼  -->
<label class="waves-effect waves-teal btn-flat" for="uploadInputBox0" style="display: none;" id="fileclick">사진첨부:Click!</label>
    <div class="main-image">
      <img  src="<%=path%><%=photo%>" id="img1" width="500" height="500">
    </div>
    <div class="secondary-images">
      <div class="secondary-image">
        <img src="<%=path%><%=photo%>" id="img2" width="50" height="50"/>
      </div>
      <div class="secondary-image">
        <img src="<%=path%><%=pic1%>" id="img3" width="50" height="50"/>
      </div>
      <div class="secondary-image">
        <img src="<%=path%><%=pic2%>" id="img4" width="50" height="50"/>
      </div>
      <div class="secondary-image">
        <img src="<%=path%><%=pic3%>" id="img5" width="50" height="50"/>
      </div>
	  <div class="secondary-image">
        <img src="<%=path%><%=pic4%>" id="img6" width="50" height="50"/>
      </div>
    </div>
    <!-- 넘어오는 img check 만약 값이 없으면 다시 업데이트시 여기안에 값을 넘겨주고 첨부파일이 있으면 첨부파일을 넘겨주기위해 비교로 필요 -->
    <input type="hidden" value=<%=photo%> name="checkimg1" id="checkimg1">
    <input type="hidden" value=<%=pic1%> name="checkimg2" id="checkimg2">
    <input type="hidden" value=<%=pic2%> name="checkimg3" id="checkimg3">
    <input type="hidden" value=<%=pic3%> name="checkimg4" id="checkimg4">
    <input type="hidden" value=<%=pic4%> name="checkimg5" id="checkimg5">
  </div>  
  <!-- 이미지 삭제버튼 -->
    <div id="xbutton1"><input type="hidden" id="1xbutton" onclick="file1del()" value="x"/></div>
    <div id="xbutton2"><input type="hidden" id="2xbutton" onclick="file2del()" value="x"/></div>
    <div id="xbutton3"><input type="hidden" id="3xbutton" onclick="file3del()" value="x"/></div>
    <div id="xbutton4"><input type="hidden" id="4xbutton" onclick="file4del()" value="x"/></div>
    <div id="xbutton5"><input type="hidden" id="5xbutton" onclick="file5del()" value="x"/></div>
    <!-- 첨부파일  -->
<input id="uploadInputBox0"  type="file" style="display:none;" name="filedata0"/>
<input id="uploadInputBox1"  type="file" style="display:none;" name="filedata1"/>
<input id="uploadInputBox2"  type="file" style="display:none;" name="filedata2"/>
<input id="uploadInputBox3"  type="file" style="display:none;" name="filedata3"/>
<input id="uploadInputBox4"  type="file" style="display:none;" name="filedata5"/>
		 <div>
		 <pre id="pre"><%=contents%></pre>
         <textarea name='contents' id='contents'><%=contents%></textarea>
        </div>
</div>
 <div class="btnwich">
<input type="hidden" id="checkcountpeople" value="<%=check%>">
<input type="hidden" id="update" onclick="return updata()" value="수정">
<input type="hidden" id="delete" value="삭제" onclick="boarddel(<%=Page%>)">
<input type="button" id="sin" value="신청" onclick="return sinchung1(<%=num%>,<%=Page%>,<%=people%>,<%=peoplecount%>)">
<input type="hidden" id="sindel" value="신청취소" onclick="return countdel(<%=num%>,<%=Page%>)">
<input type="hidden" id="sininfo" value="신청자현황" onclick="countlist(<%=num%>)">
<input type="button" id="listpage" value="목록으로" onclick="location.href='WithMe.do?page=<%=Page%>'">
</div>
<input type="hidden" name="sessionID" id="sessionID" value=${ID}>
</form>
<script  src="js/WithMeView.js?ver=1"></script>
<script>

function sinchung1(boardnum,page,people,count){//신청버튼 이벤트
	
	if($("#sessionID").val()==null||$("#sessionID").val()==""){//로그인 아이디를 체크해서 로그인안되었으면 로그인 필요 경고창
		alert("로그인이 필요합니다");
		return false;
	}
	var url = "WithMePeopleCountPage.do?boardnum="+boardnum+"&page="+page+"&limitpeople="+people+"&count="+count; //팝업창에 나올 url주소셋팅
    window.name="withmeform";//부모창에 이름지정	
	window.open(url, "", "width=570,height=300");//셋팅한 url주소를 입력하고 팝업창을띄운다
	return true;
}

function countdel(boardnum,page){
	
	var id=$("#sessionID").val();
	if($("#sessionID").val()==null||$("#sessionID").val()==""){//로그인 아이디를 체크해서 로그인안되었으면 로그인 필요 경고창
		alert("로그인이 필요합니다");
		return false;
	}
	
	var result =confirm("신청을 취소 하시겠습니까?");	
	if(result){
		location.href="With_userDel.do?boardnum="+boardnum+"&page="+page;
		return true;
	}
	return false;
}

function countlist(boardnum){
	var url = "With_UserPeopleCountInfo.do?boardnum="+boardnum; //팝업창에 나올 url주소셋팅
	window.open(url, "", "width=624,height=299");//셋팅한 url주소를 입력하고 팝업창을띄운다
}
</script>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

  </section>

</body>
</html>
