package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatismodel.ActionInsert;
import Mybatismodel.ActionList;
import vo.BoardDto;


public class Insert implements Cominterface {
	static Insert ser = new Insert();
	public static Insert instance() {
		return ser;
	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionInsert model = ActionInsert.instance(); //占쌉시깍옙 占쌉뤄옙Action 占쏙옙체占쏙옙占쏙옙
		
		String category=new String(request.getParameter("category").getBytes("8859_1"),"UTF-8");
		//카占쌓곤옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙娩占�(new String(request.getParameter("占식띰옙占쏙옙叩占�").getBytes("8859_1"),"UTF-8")占식띰옙占쏙옙庫占� 占싼억옙占� 占쏙옙占쏙옙 占싼깍옙占쏙옙 占쏙옙占쏙옙占쏙옙占십곤옙 占쏙옙占쏙옙娩占�)
		String title=new String(request.getParameter("title").getBytes("8859_1"),"UTF-8");
		//占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙娩占�
		String writer=request.getParameter("writer");
		//占쌜억옙占싱몌옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙娩占�
		String contents=new String(request.getParameter("contents").getBytes("8859_1"),"UTF-8");
		//占쌜놂옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙娩占�		
		
		BoardDto list=new BoardDto();//BoardDto 占쏙옙체占쏙옙占쏙옙占쏙옙  占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쌔댐옙
		list.setCategory(category);//카占쌓곤옙 占쏙옙占쏙옙
		list.setTitle(title);//占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
		list.setWriter(writer);//占쌜쇽옙占쏙옙 占쏙옙占쏙옙
		list.setContents(contents);//占쌉시글놂옙占쏙옙 占쏙옙占쏙옙
		
		model.boardInsert(list);//占쌓쇽옙占쏙옙占쏙옙占쏙옙호占쏙옙占싹면서 占쏙옙占쏙옙 list占쏙옙 占쏙옙占쏙옙占쌔댐옙
		
		if(category.equals("여행후기")) {//category 占쏙옙占쏙옙 占쏙옙占싹울옙 占쌔댐옙 카占쌓곤옙占쏙옙 占승댐옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
			return ".my?command=list&category=hugi";
		}
		else if(category.equals("정보&팁")) {
			return ".my?command=list&category=infoandtip";
		}
		else {
			return ".my?command=list&category=QA";
		}
		
	}
}
