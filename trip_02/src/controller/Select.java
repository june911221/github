package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatismodel.ActionList;
import vo.BoardDto;

public class Select implements Cominterface{

	static Select ser = new Select();
	public static Select instance() {
		return ser;
	}
	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionList model = ActionList.instance(); //ActionList 객체 생성
		
		String category=request.getParameter("category");//카테고리를 변수로 지정
						
		if(category.equals("hugi")) {//변수 category 값을 비교해서 값에 따른 카테고리값을 변경해준다
			category="여행후기";
		}else if(category.equals("infoandtip")) {
			category="정보&팁";
		}else {
			category="Q&A";
		}
		
		BoardDto li=new BoardDto();//BoardDto 객체 생성
		li.setCategory(category);//카테고리 셋팅
		
		ArrayList<BoardDto> list = (ArrayList<BoardDto>)model.boardlist(li);//변수 카테고리는 게시판 카테고리를 구별해서 출력하기위해 사용
		//Action페이지 에 category 변수를 보내주고  ArrayList<BoardDto> 변수 list에  리턴값을 담아준다
		
		request.setAttribute("data", list);//data=list
		
		if(category.equals("여행후기")) {//category 값을 비교하여 해당 카테고리에 맞는 페이지를 리턴해줌
			return "Hugi.jsp";
		}
		else if(category.equals("정보&팁")) {
			return "InfoandTip.jsp";
		}
		else {
			return "QandA.jsp";
		}
	}
}
