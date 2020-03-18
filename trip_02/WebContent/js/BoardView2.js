function delclick(){//삭제버튼이벤트
	var result =confirm("정말로 삭제 하시겠습니까?");	
	if(result){
		$("#tipView").attr("action","delete.my?command=del");
		$("#tipView").submit();
	}
}

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

function validation(fileName) {//업로드 파일 확장자 체크
	fileName = fileName + "";
	var fileNameExtensionIndex = fileName.lastIndexOf('.') + 1;
	var fileNameExtension = fileName.toLowerCase().substring(
			fileNameExtensionIndex, fileName.length);
	if (!((fileNameExtension === 'jpg')
			|| (fileNameExtension === 'gif') || (fileNameExtension === 'png'))) {
		alert('jpg, gif, png 확장자만 업로드 가능합니다.');
		return true;
	} else {
		return false;
	}
}

function updata(){//수정버튼이벤트
	$("#view").css("display","none");
	$("#contents").css("display","block");
	  $('#contents').summernote({ // summernote를 사용하기 위한 선언
	       	width:1000,
	   		minWidth:1000,
	   		maxWidth:1000,
	        height: 500,                 // set editor height
	        minHeight: 500,             // set minimum height of editor
	        maxHeight: 500,             // set maximum height of editor
	        focus: true,  
	    	callbacks: { // 콜백을 사용
	           // 이미지를 업로드할 경우 이벤트를 발생
		       onImageUpload: function(files, editor, welEditable) {
		    	   validation(files[0]);
			   sendFile(files[0], this);
			}
		}
	});
	  $("#titlediv").css("display","none");
	  $("#title").attr("type","text");
	  $("#update").attr("value","등록");
	  $("#update").removeAttr("onclick");
	  $("#tipView").attr("onsubmit","return up()");
	  $("#tipView").attr("action","update.my?command=update");
	  $("#title").removeAttr("readonly");
	  $("#contents").removeAttr("readonly");
	  $("#update").attr("type","submit");
	  return false;
}
function up(){//등록버튼 이벤트
	var result =confirm("게시글을 수정 하시겠습니까?");	
	if(result){
		return true;
	}else{
		return false;		
	}
	return false;
}

$(document).ready(function() {//게시글 상세보기를 했을때 세션ID값과 작성자ID가 동일하면 히든타입을 버튼으로  활성화  수정 삭제 가능하게 함
	var writer=$("#writer").val();
	var sessionID=$("#sessionID").val();
	
	if(writer==sessionID){
		$("#update").attr("type","button");
		$("#delete").attr("type","button");		
	}
});

function commentcheck(p){//댓글 입력시  형식 체크 
	var sessionID=$("#sessionID").val();
	var commentbox=$("#comment_box").val();
	var page=p;
	
	if(sessionID==""||sessionID==null){
		alert("로그인이 필요합니다");
		return false;
	}
	if(commentbox==""||commentbox==null){
		alert("내용을 입력하세요");
		return false;
	}
	var result =confirm("댓글을 등록 하시겠습니까?");	
	if(result){
		$("#commentwrite").attr("action","commentwrite.my?command=commentinsert&page="+p);
		$("#commentwrite").submit();
		return true;
	}	
	return false;
}

function commentdel(commentnum){//댓글삭제
	
	var bnum=$("#num").val();//게시글 번호
	var sessionID=$("#sessionID").val();//현재 로그인한 아이디
	var writer=$("#writer"+commentnum).val();//삭제할 댓글에 작성자 아이디
	
	
	if(sessionID==""||sessionID==null){//로그인여부 체크
		alert("로그인이 필요합니다");
		return false;
	}
	if(sessionID != writer){//로그인ID와 댓글작성작가 같은지 체크
		alert("삭제할 권한이 없습니다");
		return false;
	}
	var result =confirm("댓글을 삭제 하시겠습니까?");	
	if(result){//댓글 삭제 컨펌이 true값일경우 삭제 실행
		return true;
	}
	return false;
}

function commentup(commentnum,p){//댓글 수정
	
	var bnum=$("#num").val();//게시글 번호
	var sessionID=$("#sessionID").val();//현재 로그인한 아이디
	var writer=$("#writer"+commentnum).val();//삭제할 댓글에 작성자 아이디
	var page=p;
	
	if(sessionID==""||sessionID==null){//로그인여부 체크
		alert("로그인이 필요합니다");
		return false;
	}
	if(sessionID != writer){//로그인ID와 댓글작성작가 같은지 체크
		alert("삭제할 권한이 없습니다");
		return false;
	}
	var result =confirm("댓글을 수정 하시겠습니까?");	
	if(result){//댓글 삭제 컨펌이 true값일경우 수정 실행
		var url=".my?command=commentModify&commentnum="+commentnum+"&page="+page;//팝업창에 나올 url주소셋팅
	    window.name="commentModifyform";//부모창에 이름지정	
		window.open(url, "", "width=800,height=300");//셋팅한 url주소를 입력하고 팝업창을띄운다
		return false;
	}
	return false;	
}