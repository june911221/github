package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatismodel.ActionCommentList;
import Mybatismodel.ActionHitsUp;
import Mybatismodel.ActionListView;
import vo.BoardDto;
import vo.CommentDto;

public class SelectView implements Cominterface {
	static SelectView ser = new SelectView();

	public static SelectView instance() {
		return ser;
	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionListView model = ActionListView.instance();// 게시글보기 Action 객체형성
		ActionHitsUp mode2 = ActionHitsUp.instance();// 조회수 증가 Action 객체 형성
		ActionCommentList mode3 = ActionCommentList.instance();// 댓글리스트 Action객체 형성

		int num = Integer.parseInt(request.getParameter("num"));// 게시글번호를 변수 num에 담아준다

		BoardDto li = new BoardDto();// BoardDto 객체생성
		li.setNum(num);// 객체에 글번호 셋팅

		if (request.getParameter("hits") != null) {
			int hits = Integer.parseInt(request.getParameter("hits")) + 1;// 조회수를 변수 hits에 담아주는데 이떄 넘어온 파라미터값에 +1을시켜
																			// 조회수가 증가한상태로 hits담아준다
			li.setHits(hits);// 객체에 조회수 셋팅
			mode2.HitsUp(li);// 조회수 증가액션에 li 값을 보내준다
		}

		ArrayList<BoardDto> list = (ArrayList<BoardDto>) model.boardlist(li);// 게시글 상세보기
		// Action페이지에 num 변수를 보내주고 ArrayList<BoardDto> 변수 list에 리턴값을 담아준다
		ArrayList<CommentDto> commentlist = (ArrayList<CommentDto>) mode3.commentlist(num);// 해당게시글에 댓글 불러오기
		// Action페이지에 num 변수를 보내주고 ArrayList<CommentDto> 변수 commentlist에 리턴값을 담아준다

		request.setAttribute("data", list);// data=list(게시글내용)
		request.setAttribute("codata", commentlist);// codata=commentlist(댓글리스트)

		return "BoardView.jsp";
	}
}
