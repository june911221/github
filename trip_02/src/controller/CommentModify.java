package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatismodel.ActionCommentModify;
import vo.CommentDto;

public class CommentModify implements Cominterface {
	static CommentModify ser = new CommentModify();
	public static CommentModify instance() {
		return ser;
	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionCommentModify mode = ActionCommentModify.instance();//댓글 수정창 객체생성
		CommentDto li=new CommentDto();//CommentDto 객체생성
		li.setC_number(Integer.parseInt(request.getParameter("commentnum")));//CommentDto 에 게시글 번호 셋팅	
		
		ArrayList<CommentDto> list=(ArrayList<CommentDto>)mode.commentModify(li); //댓글쓰기 메소드 에 변수로 li 객체 보내준다
		
		request.setAttribute("commentdata", list);//commentdata=list
		
		return "CommentModify.jsp";
	}
}
