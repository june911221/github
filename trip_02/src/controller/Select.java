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
		ActionList model = ActionList.instance(); //ActionList 占쏙옙체 占쏙옙占쏙옙
		
		String category=request.getParameter("category");//카占쌓곤옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
						
		if(category.equals("hugi")) {//占쏙옙占쏙옙 category 占쏙옙占쏙옙 占쏙옙占쌔쇽옙 占쏙옙占쏙옙 占쏙옙占쏙옙 카占쌓곤옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쌔댐옙
			category="여행후기";
		}else if(category.equals("infoandtip")) {
			category="정보&팁";
		}else {
			category="Q&A";
		}
		
		BoardDto li=new BoardDto();//BoardDto 占쏙옙체 占쏙옙占쏙옙
		li.setCategory(category);//카占쌓곤옙 占쏙옙占쏙옙
		
		ArrayList<BoardDto> list = (ArrayList<BoardDto>)model.boardlist(li);//占쏙옙占쏙옙 카占쌓곤옙占쏙옙 占쌉쏙옙占쏙옙 카占쌓곤옙占쏙옙 占쏙옙占쏙옙占쌔쇽옙 占쏙옙占쏙옙歐占쏙옙占쏙옙占� 占쏙옙占�
		//Action占쏙옙占쏙옙占쏙옙 占쏙옙 category 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쌍곤옙  ArrayList<BoardDto> 占쏙옙占쏙옙 list占쏙옙  占쏙옙占싹곤옙占쏙옙 占쏙옙占쏙옙娩占�
		
		request.setAttribute("data", list);//data=list
		
		if(category.equals("여행후기")) {//category 占쏙옙占쏙옙 占쏙옙占싹울옙 占쌔댐옙 카占쌓곤옙占쏙옙 占승댐옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
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
