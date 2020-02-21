package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatismodel.ActionCommentUpdate;
import vo.CommentDto;

public class CommentUpdate implements Cominterface {
	static CommentUpdate ser = new CommentUpdate();
	public static CommentUpdate instance() {
		return ser;
	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionCommentUpdate mode = ActionCommentUpdate.instance();//댓글쓰기 객체생성
		
		String comment=new String(request.getParameter("comment_box").getBytes("8859_1"),"UTF-8");//댓글 내용을 불러와서 한글이 깨지는걸 보안후 변수지정
		
			
		List<CommentDto> list = null;//List<CommentDto> 객체 생성후   null값으로 초기화
		CommentDto li=new CommentDto();//CommentDto 객체생성
		li.setC_number(Integer.parseInt(request.getParameter("commnetnum")));//CommentDto 에 게시글 번호 셋팅
		li.setComment_box(comment);//CommentDto 에 댓글 셋팅
		
		mode.commentUpdate(li); //댓글쓰기 메소드 에 변수로 li 객체 보내준다
		
		return ".my?command=view&num="+request.getParameter("bnum");//num=게시글번호 게시글번호를 가지고 게시판View 페이지로다 시동
	}
}
