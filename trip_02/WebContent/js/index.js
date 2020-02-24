

$(function(){
    var autocomplete_text =["인천국제공항 (ICN)","서울 김포 (GMP)","오사카 간사이 (KIX)","도쿄 나리타 (NRT)","홍콩 국제 (HKG)","마카오 (MFM)","타이베이 (TPE)",
	"카오슝 (KHH)","상하이 푸동 (PVG)","상해 (SHA)","칭다오 (TAO)","방콕 (BKK)","싱가포르 (SIN)","푸켓 (HKT)","베트남 다낭 (DAD)","베트남 호치민시티 (SGN)",
	"베트남 나트랑  캄란 (CXR)","파리 샤를 디 골 (CDG)","로마 레오나르도 다빈치 (FCO)","런던 히드로 (LHR)","바르셀로나 (BCN)","이스탄불 (IST)","블라디보스토크 (VVO)","모스크바 (SVO)","상트 페테르부르크 (LED)"
	,"도쿄 하네다 (HND)","마드리드 (MAD)","밀라노 말펜사 (MXP)",	"암스테르담 (AMS)","취리히 (ZRH)","프라하 (PRG)" ,"프랑크푸르트 (FRA)","뉴욕 존.F.케네디 (JFK)",
	"LA (LAX)","센프란시스코 (SFO)","시애틀 (SEA)","워싱턴 델러스 (IAD)","토론토 (YYZ)","호놀룰루 (HNL)","델리 (DEL)","뭄바이 (BOM)","세부 (CEB)","치앙마이 (CNX)",
	"쿠알라룸푸르 (KUL)","팔라우 (ROR)","하노이 (HAN)","타쉬켄트 (TAS)","울란바토르 (ULN)","두바이 (DXB)","텔아비브 (TLV)","아부다비 (AUH)","괌 (GUM)","시드니 (SYD)"
	,"브리즈번 (BNE)","댈러스 포트워스 (DFW)","시카고 (ORD)"];
         $("#autocomplete").autocomplete({
            source: autocomplete_text
         });
})
$(function(){
    var autocomplete_text = ["인천국제공항 (ICN)","서울 김포 (GMP)","오사카 간사이 (KIX)","도쿄 나리타 (NRT)","홍콩 국제 (HKG)","마카오 (MFM)","타이베이 (TPE)",
    	"카오슝 (KHH)","상하이 푸동 (PVG)","상해 (SHA)","칭다오 (TAO)","방콕 (BKK)","싱가포르 (SIN)","푸켓 (HKT)","베트남 다낭 (DAD)","베트남 호치민시티 (SGN)",
    	"베트남 나트랑  캄란 (CXR)","파리 (CDG)","로마 (FCO)","런던 (LHR)","바르셀로나 (BCN)","이스탄불 (IST)","블라디보스토크 (VVO)","모스크바 (SVO)","상트 페테르부르크 (LED)"
    	,"도쿄 하네다 (HND)","마드리드 (MAD)","밀라노 말펜사 (MXP)",	"암스테르담 (AMS)","취리히 (ZRH)","프라하 (PRG)" ,"프랑크푸르트 (FRA)","뉴욕 존.F.케네디 (JFK)",
    	"LA (LAX)","센프란시스코 (SFO)","시애틀 (SEA)","워싱턴 델러스 (IAD)","토론토 (YYZ)","호놀룰루 (HNL)","델리 (DEL)","뭄바이 (BOM)","세부 (CEB)","치앙마이 (CNX)",
    	"쿠알라룸푸르 (KUL)","팔라우 (ROR)","하노이 (HAN)","타쉬켄트 (TAS)","울란바토르 (ULN)","두바이 (DXB)","텔아비브 (TLV)","아부다비 (AUH)","괌 (GUM)","시드니 (SYD)"
    	,"브리즈번 (BNE)","댈러스 포트워스 (DFW)","시카고 (ORD)"];
         $("#autocomplete2").autocomplete({
            source: autocomplete_text
         });
})

$(function() {
    $( "#testDatepicker" ).datepicker({
    });
});
$(function() {
    $( "#testDatepicker2" ).datepicker({
    });
});
	$(document).ready(function() {
		//사용할 배너
		var $banner = $(".banner").find("ul");

		var $bannerWidth = $banner.children().outerWidth();//배너 이미지의 폭
		var $bannerHeight = $banner.children().outerHeight(); // 높이
		var $bannerLength = $banner.children().length;//배너 이미지의 갯수
		var rollingId;

		//정해진 초마다 함수 실행
		rollingId = setInterval(function() { rollingStart(); }, 3500);//다음 이미지로 롤링 애니메이션 할 시간차
		function rollingStart() {
			$banner.css("width", $bannerWidth * $bannerLength + "px");
			$banner.css("height", $bannerHeight + "px");
			//alert(bannerHeight);
			//배너의 좌측 위치를 옮겨 준다.
			$banner.animate({left: - $bannerWidth + "px"}, 3000, function() { //숫자는 롤링 진행되는 시간이다.
				//첫번째 이미지를 마지막 끝에 복사(이동이 아니라 복사)해서 추가한다.
				$(this).append("<li>" + $(this).find("li:first").html() + "</li>");
				//뒤로 복사된 첫번재 이미지는 필요 없으니 삭제한다.
				$(this).find("li:first").remove();
				//다음 움직임을 위해서 배너 좌측의 위치값을 초기화 한다.
				$(this).css("left", 0);
				//이 과정을 반복하면서 계속 롤링하는 배너를 만들 수 있다.
			});
		}
	}); 

