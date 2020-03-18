package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatismodel.ActionCommentDelete;
import vo.CommentDto;

public class CommentDelete implements Cominterface {
	static CommentDelete ser = new CommentDelete();

	public static CommentDelete instance() {
		return ser;
	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionCommentDelete mode = ActionCommentDelete.instance(); // delete action 객체 형성

		int page = Integer.parseInt(request.getParameter("page"));	//페이지변수
		
		CommentDto list = new CommentDto();// CommentDto 객체 형성
		list.setC_number(Integer.parseInt(request.getParameter("commentnum")));
		// 객체에 댓글번호 셋팅(String 타입으로 넘어온 파라미터이기에 Int 타입인 댓글번호에 셋팅하기위에 Integer를통한 형변환)

		mode.commentDelete(list);
		// delete액션에 게시글변수 전달

		return ".my?command=view&num=" + request.getParameter("bnum")+"&page="+page;
		// 댓글삭제후 게시글 번호를 파라미터로 뷰페이지로 전달 해서 보고있던 페이지로 다시 이동한다
	}

}
