<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/*테마선택카드*/
.gallery{/*테마카드 위치조절*/
width:100%;
height:750px;
position:absolute;
background:#f9f9f9;
left:0%;
top:200px;
box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
text-align:center;
}


.view {
  width: 267px;
  height: 400px;
  margin:45px;
  margin-left: 80px;
  float: left;
  border-top: 1px solid #ccc;
  border-left: 1px solid #ccc;
  border-right: 5px solid #ccc;
 border-bottom: 5px solid #ccc;
  overflow: hidden;
  position: relative;
  top:60px;
  left:10%;
  text-align: center;
  box-shadow: 1px 1px 2px #e6e6e6;
  cursor: default;
}

.view .mask, .view .content {
  width: 267px;
  height: 400px;
  position: absolute;
  overflow: hidden;
  top: 0;
  left: 0;
}

.view img {
  display: block;
  position: relative;
  max-width: 100%;
}

.view h2 {
  text-transform: uppercase;
  color: white;
  text-align: center;
  position: relative;
  font-size: 17px;
  padding: 10px;
  background: rgba(0, 0, 0, 0.8);
  margin: 20px 0 0 0;
}

.view p {
  font-family: Georgia, serif;
  font-style: italic;
  font-size: 12px;
  position: relative;
  color: #fff;
  padding: 10px 20px 20px;
  text-align: center;
}

.view a.info {
  display: inline-block;
  text-decoration: none;
  padding: 7px 14px;
  background: #000;
  color: #fff;
  text-transform: uppercase;
  box-shadow: 0 0 1px #000;
  -webkit-box-shadow: 0 8px 6px -6px black;
  -moz-box-shadow: 0 8px 6px -6px black;
  box-shadow: 0px 8px 6px -6px black;
}

.view a.info:hover {
  box-shadow: 0 0 5px #000;
}

.view img {
  -webkit-transition: all 0.4s ease-in-out 0.5s;
  -moz-transition: all 0.4s ease-in-out 0.5s;
  -o-transition: all 0.4s ease-in-out 0.5s;
  -ms-transition: all 0.4s ease-in-out 0.5s;
  transition: all 0.4s ease-in-out 0.5s;
}

.view .mask {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=0)";
  filter: alpha(opacity=0);
  opacity: 0;
  -webkit-transition: all 0.3s ease-in 0.4s;
  -moz-transition: all 0.3s ease-in 0.4s;
  -o-transition: all 0.3s ease-in 0.4s;
  -ms-transition: all 0.3s ease-in 0.4s;
  transition: all 0.3s ease-in 0.4s;
}

.view h2 {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=0)";
  filter: alpha(opacity=0);
  opacity: 0;
  border-bottom: 1px solid rgba(0, 0, 0, 0.3);
  background: transparent;
  margin: 20px 40px 0px 40px;
  -webkit-transform: scale(10);
  -moz-transform: scale(10);
  -o-transform: scale(10);
  -ms-transform: scale(10);
  transform: scale(10);
  -webkit-transition: all 0.3s ease-in-out 0.1s;
  -moz-transition: all 0.3s ease-in-out 0.1s;
  -o-transition: all 0.3s ease-in-out 0.1s;
  -ms-transition: all 0.3s ease-in-out 0.1s;
  transition: all 0.3s ease-in-out 0.1s;
}

.view p {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=0)";
  filter: alpha(opacity=0);
  opacity: 0;
  -webkit-transform: scale(10);
  -moz-transform: scale(10);
  -o-transform: scale(10);
  -ms-transform: scale(10);
  transform: scale(10);
  -webkit-transition: all 0.3s ease-in-out 0.2s;
  -moz-transition: all 0.3s ease-in-out 0.2s;
  -o-transition: all 0.3s ease-in-out 0.2s;
  -ms-transition: all 0.3s ease-in-out 0.2s;
  transition: all 0.3s ease-in-out 0.2s;
}

.view a.info {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=0)";
  filter: alpha(opacity=0);
  opacity: 0;
  -webkit-transform: translateY(100px);
  -moz-transform: translateY(100px);
  -o-transform: translateY(100px);
  -ms-transform: translateY(100px);
  transform: translateY(100px);
  -webkit-transition: all 0.3s ease-in-out 0.1s;
  -moz-transition: all 0.3s ease-in-out 0.1s;
  -o-transition: all 0.3s ease-in-out 0.1s;
  -ms-transition: all 0.3s ease-in-out 0.1s;
  transition: all 0.3s ease-in-out 0.1s;
}

.view:hover .mask {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=100)";
  filter: alpha(opacity=100);
  opacity: 1;
  -webkit-transition-delay: 0s;
  -moz-transition-delay: 0s;
  -o-transition-delay: 0s;
  -ms-transition-delay: 0s;
  transition-delay: 0s;
}

.view:hover img {
  -webkit-transition-delay: 0s;
  -moz-transition-delay: 0s;
  -o-transition-delay: 0s;
  -ms-transition-delay: 0s;
  transition-delay: 0s;
}

.filter-gray img {
  -webkit-filter: grayscale(100%);
  -moz-filter: grayscale(100%);
  filter: grayscale(100%);
}

.view:hover h2 {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=100)";
  filter: alpha(opacity=100);
  opacity: 1;
  -webkit-transform: scale(1);
  -moz-transform: scale(1);
  -o-transform: scale(1);
  -ms-transform: scale(1);
  transform: scale(1);
  -webkit-transition-delay: 0.1s;
  -moz-transition-delay: 0.1s;
  -o-transition-delay: 0.1s;
  -ms-transition-delay: 0.1s;
  transition-delay: 0.1s;
}

.view:hover p {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=100)";
  filter: alpha(opacity=100);
  opacity: 1;
  -webkit-transform: scale(1);
  -moz-transform: scale(1);
  -o-transform: scale(1);
  -ms-transform: scale(1);
  transform: scale(1);
  -webkit-transition-delay: 0.2s;
  -moz-transition-delay: 0.2s;
  -o-transition-delay: 0.2s;
  -ms-transition-delay: 0.2s;
  transition-delay: 0.2s;
}

.view:hover a.info {
  -ms-filter: "progid: DXImageTransform.Microsoft.Alpha(Opacity=100)";
  filter: alpha(opacity=100);
  opacity: 1;
  -webkit-transform: translateY(0px);
  -moz-transform: translateY(0px);
  -o-transform: translateY(0px);
  -ms-transform: translateY(0px);
  transform: translateY(0px);
  -webkit-transition-delay: 0.3s;
  -moz-transition-delay: 0.3s;
  -o-transition-delay: 0.3s;
  -ms-transition-delay: 0.3s;
  transition-delay: 0.3s;
}
</style>
</head>
<body>
<%
		String ses = null;
		ses = (String) session.getAttribute("ID");
		if (ses == null) {
	%>
	<jsp:include page="header.jsp" />
	<%
		} else {
	%>
	<jsp:include page="Loginheader.jsp" />
	<%
		}
	%>
	<section>
		<!-- 테마선택카드 -->
		<div class="gallery">
			<br> <br> <br>
			<p style="font-size: 34px; color: #474747; font-weight: bold;">테
				마 여 행</p>
			<div class="view">
				<img src="img/family.jpg" width="100%" height="100%" />
				<div class="mask">
					<h2>가족</h2>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
						sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna
						aliquam erat volutpat.</p>
					<a href="#" class="info">Read More</a>
				</div>
			</div>

			<div class="view">
				<img
					src="http://farm4.staticflickr.com/3672/9759934733_30459e24b6_c.jpg" />
				<div class="mask">
					<h2>연인</h2>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
						sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna
						aliquam erat volutpat.</p>
					<a href="#" class="info">Read More</a>
				</div>
			</div>

			<div class="view">
				<img src="img/healing.jpg" width="100%" height="100%" />
				<div class="mask">
					<h2>힐링</h2>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
						sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna
						aliquam erat volutpat.</p>
					<a href="#" class="info">Read More</a>
				</div>
			</div>

			<div class="view">
				<img
					src="http://farm3.staticflickr.com/2830/9479528002_33660b24ef_c.jpg" />
				<div class="mask">
					<h2>익사이팅</h2>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
						sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna
						aliquam erat volutpat.</p>
					<a href="#" class="info">Read More</a>
				</div>
			</div>
		</div>
	</section>
</body>
</html>