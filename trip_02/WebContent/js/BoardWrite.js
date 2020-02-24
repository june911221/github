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
       	width:800,
   		minWidth:800,
   		maxWidth:800,
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


function boardcheck(){
	if($("#category").val()=="none"){
		alert("카테고리를 선택해주세요");
		return false;
	}
	if($("#title").val()==""||$("#title").val()==null){
		alert("제목을 입력해주세요");
		return false;
	}
	var result=confirm("게시글을 등록 하시겠습니까?");
	
	if(result){
		return true;
	}
	return false;
}