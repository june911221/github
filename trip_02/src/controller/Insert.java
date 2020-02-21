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
		ActionInsert model = ActionInsert.instance(); //게시글 입력Action 객체형성
		
		String category=new String(request.getParameter("category").getBytes("8859_1"),"UTF-8");
		//카테고리 값을 변수에 담아준다(new String(request.getParameter("파라미터값").getBytes("8859_1"),"UTF-8")파라미터로 넘어온 값이 한글이 깨지지않게 잡아준다)
		String title=new String(request.getParameter("title").getBytes("8859_1"),"UTF-8");
		//글제목을 변수에 담아준다
		String writer=request.getParameter("writer");
		//글쓴이를 변수에 담아준다
		String contents=new String(request.getParameter("contents").getBytes("8859_1"),"UTF-8");
		//글내용을 변수에 담아준다		
		
		BoardDto list=new BoardDto();//BoardDto 객체형성후  값을 셋팅해준다
		list.setCategory(category);//카테고리 셋팅
		list.setTitle(title);//글제목 셋팅
		list.setWriter(writer);//작성자 셋팅
		list.setContents(contents);//게시글내용 셋팅
		
		model.boardInsert(list);//액션페이지호출하면서 변수 list를 보내준다
		
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
