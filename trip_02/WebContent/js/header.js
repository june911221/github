	//메뉴바 스크롤 이벤트
$(document).ready(function() {
	var jbOffset = $ ('nav').offset();
	$(window).scroll(function(){
		if($(document).scrollTop()>jbOffset.top) {
			$('nav').addClass('jbFixed');
			}
			else{
				$('nav').removeClass('jbFixed');
				}
				});
});


function openForm() {
	  document.getElementById("myForm").style.display = "block";
	}

	function closeForm() {
	  document.getElementById("myForm").style.display = "none";
	}
	
	
function noPageAction(){//마이페이지와 해당 서브메뉴 클릭시 로그인필요 안내
	alert("로그인이 필요합니다");
	return false;
}