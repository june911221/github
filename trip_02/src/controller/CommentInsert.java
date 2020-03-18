package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatismodel.ActionCommentInsert;
import vo.CommentDto;

public class CommentInsert implements Cominterface {
	static CommentInsert ser = new CommentInsert();

	public static CommentInsert instance() {
		return ser;
	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionCommentInsert mode = ActionCommentInsert.instance();// 댓글쓰기 객체생성

		String comment = new String(request.getParameter("comment_box").getBytes("8859_1"), "UTF-8");// 게시글내용을 불러와서 한글이
        
		int page = Integer.parseInt(request.getParameter("page"));//페이지변수		
		
        List<CommentDto> list = null;// List<CommentDto> 객체 생성후 null값으로 초기화
		CommentDto li = new CommentDto();// CommentDto 객체생성
		li.setB_number(Integer.parseInt(request.getParameter("bnum")));// CommentDto 에 게시글 번호 셋팅
		li.setComment_box(comment);// CommentDto 에 댓글 셋팅
		li.setWriter(request.getParameter("commentwriter"));// CommentDto 에 작성자 셋팅

		mode.commentInsert(li); // 댓글쓰기 메소드 에 변수로 li 객체 보내준다

		return ".my?command=view&num=" + li.getB_number()+"&page="+page;
	}
}
