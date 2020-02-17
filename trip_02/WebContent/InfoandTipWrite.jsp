<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InfoandTipWrite</title>
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
<script type="text/javascript">
/* summernote에서 이미지 업로드시 실행할 함수 */
	function sendFile(file, el) {// 파일 전송을 위한 폼생성
		var form_data = new FormData();
      	form_data.append('file', file);
      	$.ajax({// ajax를 통해 파일 업로드 처리
        	data: form_data,
        	type: "POST",
        	url: "./summernote_imageUpload.jsp",
        	cache: false,
        	contentType: false,
        	enctype: 'multipart/form-data',
        	processData: false,
        	success: function(img_name) {// 처리가 성공할 경우
        	  	// 에디터에 이미지 출력
        	  //console.log(img_name+"dd")
        	  $(el).summernote('editor.insertImage', "."+img_name);
        	}
      	});
    }
    
$(document).ready(function() {
    $('#contents').summernote({ // summernote를 사용하기 위한 선언
       	width:740,
   		minWidth:740,
   		maxWidth:740,
        height: 500,                 // set editor height
        minHeight: 500,             // set minimum height of editor
        maxHeight: 500,             // set maximum height of editor
        focus: true,  
    	callbacks: { // 콜백을 사용
           // 이미지를 업로드할 경우 이벤트를 발생
	       onImageUpload: function(files, editor, welEditable) {
		   sendFile(files[0], this);
		}
	}
});
});

</script>
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

<form action="insert.my?command=insert" onsubmit="return boardcheck()" method="post">
카테고리:<input type="text" id="category" name="category" value="정보&팁" readonly/>
글쓴이:<input type="text" id="writer" name="writer" value="${ID}" readonly/>
제목:<input type="text" id="title" name="title"/>
내용:<textarea id="contents" name="contents"></textarea>
<input type="submit" value="등록"/>
</form>
<script>
function boardcheck(){
	if($("#title").val()==""||$("#title").val()==null){
		alert("제목을 입력해주세요");
		return false;
	}
	var result =confirm("게시글을 등록 하시겠습니까?");
	
	if(result){
		return true;
	}
	return false;
}
</script>
</section>
</body>
</html>