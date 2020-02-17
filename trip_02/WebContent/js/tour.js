/**
 * 
 */
function city_time() { //도시select 선택

var f = document.cnjform; //select form

zone = f.cityname.options[f.cityname.selectedIndex].value; //form 에 value값을 변수에 지정
city_zone = f.cityname.options[f.cityname.selectedIndex].text //form 에 text를 변수에지정

changeView(city_zone,zone);

}




function changeView(city_zone,zone) { //변수를 파라미터로전달

	 location.href = "TourCity.jsp?cityname="+city_zone+"&timeval="+zone;
} 