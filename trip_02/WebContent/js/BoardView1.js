function delclick(){//삭제버튼이벤트
	var result =confirm("정말로 삭제 하시겠습니까?");	
	if(result){
		$("#tipView").attr("action","delete.my?command=del");
		$("#tipView").submit();
	}
}
function updata(){//수정버튼이벤트
	  $("#titlediv").css("display","none");
	  $("#update").attr("value","등록");
	  $("#update").removeAttr("onclick");
	  $("#tipView").attr("onsubmit","return up()");
	  $("#tipView").attr("action","update.my?command=update");
	  $("#title").attr("type","text");
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

function commentcheck(){//댓글 입력시  형식 체크 
	var sessionID=$("#sessionID").val();
	var commentbox=$("#comment_box").val();
	
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
		$("#commentwrite").attr("action","commentwrite.my?command=commentinsert");
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

function commentup(commentnum){//댓글 수정
	
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
	var result =confirm("댓글을 수정 하시겠습니까?");	
	if(result){//댓글 삭제 컨펌이 true값일경우 수정 실행
		var url=".my?command=commentModify&commentnum="+commentnum; //팝업창에 나올 url주소셋팅
	    window.name="commentModifyform";//부모창에 이름지정	
		window.open(url, "", "width=570,height=600");//셋팅한 url주소를 입력하고 팝업창을띄운다
		return false;
	}
	return false;	
}