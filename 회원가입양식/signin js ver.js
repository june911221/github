
  function check(){
  irum()
  }

  function joososelect(){
	  alert("주소를 검색하세요")
 }

   function idcheck(su){
	   var str=SIGNIN.idd.value
	  if (str=="")
	  {
	  alert("Id를 입력하세요")
	  }
	  else{
	  alert("사용하셔도 좋습니다")
	  }
 }

  function emailselect(sun){

	  var str=""
	  if(sun.options[0].selected)
	  str=""
	  SIGNIN.email_dns.value=str

	  if(sun.options[1].selected)
	  str="daum.net"
	  SIGNIN.email_dns.value=str

	  if(sun.options[2].selected)
	  str="empal.com"
	  SIGNIN.email_dns.value=str

	  if(sun.options[3].selected)
	  str="gmail.com"

	  SIGNIN.email_dns.value=str
	  if(sun.options[4].selected)
	  str="hanmail.com"

	  SIGNIN.email_dns.value=str
	  if(sun.options[5].selected)
	  str="msn.com"
	  SIGNIN.email_dns.value=str

	  if(sun.options[6].selected)
	  str="naver.com"
	  SIGNIN.email_dns.value=str

	  if(sun.options[6].selected)
	  str="nate.com"
	  SIGNIN.email_dns.value=str

}

  function irum(su){
	  var str=SIGNIN.namea.value

	  if(str==""){
		  alert("이름을 입력하세요")
	  }
	  else{phnum()}
  }
  
   function phnum(su,si){
	   var str=SIGNIN.phone_3.value
	   var atr=SIGNIN.phone_4.value
	  if (str==""||atr=="")
	  {
	  alert("휴대폰 번호를 입력하세요")
	  }
	  else{mail()}
 }

  function mail(su,si){
	  var str=SIGNIN.email.value
	  var atr=SIGNIN.email_dns.value

	  if(str==""||atr==""){
		  alert("이메일을 입력하세요")
	  }
	  else{jooso()}
  }

 
  function jooso(su,si,sc){
	  var str=SIGNIN.addr.value
	  var atr=SIGNIN.addr_1.value
      var btr=SIGNIN.addr_2.value
	  if(str==""||atr==""){
		  alert("주소를 입력하세요")
	  }
	  else if(btr==""){
	      alert("상세주소를 입력하세요")
	  }
	  else{iddc()}	  
  }

    function iddc(su){
	  var str=SIGNIN.idd.value
	  if(str==""){
		  alert("ID를 입력하세요")
	  }
	  else{nikname()}	  
  }

   function nikname(su){
	  var str=SIGNIN.nik.value

	  if(str==""){
		  alert("닉네임을 입력하세요")
	  }
	  else{password()}
  }

  function password(){

  var pass_len=SIGNIN.pw_1.value.length

  if((pass_len>=8)&&(pass_len<=10)){
	  passwordck(pass_len)
  }
  
  else{
	alert("8~10자 사이의 암호만 유효합니다")
    SIGNIN.pw_1.value=""
    SIGNIN.pw_1.focus()
  }
 }

 function passwordck(pa){

  var pass_len=SIGNIN.pw_2.value.length

  if(pa==pass_len){
	  hint()
  }
  
  else{
	alert("비밀번호가 일치하지 않습니다")
    SIGNIN.pw_2.value=""
    SIGNIN.pw_2.focus()
  }
 }
  function hint(su){
	   var str=SIGNIN.pwqa.value
	  if (str=="")
	  {
	  alert("PW답변을 입력하세요")
	  }
	  else{
		
	  select1()
	  }
 }

 function select1(){

	  
	  {
		  if(SIGNIN.chk1.checked && SIGNIN.chk2.checked)
		  {
			  show()
			  
		  }
		  else{
		  alert("약관을 동의해주세요.")
		  }
	  }	  
  }
 function show()
 {
 alert("이름:"+SIGNIN.namea.value+
 "\n성별:"+SIGNIN.chk_male.value+
 "\n생년월일:"+SIGNIN.year.value+
 "년"+SIGNIN.month.value+
 "월"+SIGNIN.day.value+
 "일 \n통신사:"+SIGNIN.phone_1.value+
 "\n번호:"+SIGNIN.phone_2.value+
 "-"+SIGNIN.phone_3.value+
 "\n이메일 주소:"+SIGNIN.email.value+
 "@"+SIGNIN.email_dns.value+
 "\n주소"+SIGNIN.addr.value+
 "-"+SIGNIN.addr_1.value+
 "\n상세주소:"+SIGNIN.addr_2.value+
 "\n아이디:"+SIGNIN.idd.value+
 "\n닉네임:"+SIGNIN.nik.value+
 "\n비밀번호:"+SIGNIN.pw_1.value+
 "\n비밀번호 힌트 답변:"+SIGNIN.pwqa.value+
 "\n이메일 수신동의 여부:"+SIGNIN.chk_mail.value+
 "\nsns수신동의 여부"+SIGNIN.chk_sns.value+
 "\n약관동의여부:"+SIGNIN.chk1.value+
 "\n약관2동의여부:"+SIGNIN.chk2.value+
 "으로 입력했습니다. 가입이 완료되었습니다")
 
 }