package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatismodel.ActionUpdate;
import vo.BoardDto;

public class Update implements Cominterface {
	static Update ser = new Update();

	public static Update instance() {
		return ser;
	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionUpdate model = ActionUpdate.instance(); // 게시글 수정 Action 객체 형성

		int num = Integer.parseInt(request.getParameter("num")); // 게시글번호 변수에담아준다
		String category = new String(request.getParameter("category").getBytes("8859_1"), "UTF-8");// 카테고리를 변수에 담아준다
		String title = new String(request.getParameter("title").getBytes("8859_1"), "UTF-8");// 글제목을 변수에담아준다
		String contents = new String(request.getParameter("contents").getBytes("8859_1"), "UTF-8");// 글내용을 변수에담아준다

		BoardDto list = new BoardDto();// BoardDto 객체 생성
		list.setNum(num);// 게시글 번호 셋팅
		list.setTitle(title);// 글제목 셋팅
		list.setCategory(category);// 카테고리 셋팅
		list.setContents(contents);// 글내용 셋팅

		model.Update(list);// 업데이트 액션 호출 list를 변수로 보내준다

		return ".my?command=view&num=" + list.getNum();
	}
}
