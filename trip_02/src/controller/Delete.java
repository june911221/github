package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatismodel.ActionDelete;
import vo.BoardDto;

public class Delete implements Cominterface {
	static Delete ser = new Delete();
	public static Delete instance() {
		return ser;
	}
	
	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionDelete model = ActionDelete.instance(); //게시글삭제 action 객체생성
		int num=Integer.parseInt(request.getParameter("num"));
		//변수 num에 게시글 번호 입력(String 타입인 게시글번호를 Inteager를통해 int 타입으로 형변환)
		String category=new String(request.getParameter("category").getBytes("8859_1"),"UTF-8");
		//게시글을 삭제한후 삭제된 게시글 카테고리에 맞는 리스트 페이지를 돌려주기위해 카테고리를 변수에 지정 
		
		BoardDto list=new BoardDto();//BoardDto 객체 생성
		list.setNum(num);//게시글번호 셋팅
		
		model.Delete(list);//액션페이지호출하면서 변수 list를 보내준다
		
		
		if(category.equals("여행후기")) {//category 값을 비교하여 해당 카테고리에 맞는 페이지를 리턴해줌
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
