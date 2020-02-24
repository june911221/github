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
		ActionCommentInsert mode = ActionCommentInsert.instance();//��۾��� ��ü����
		System.out.print("d");
		String comment=new String(request.getParameter("comment_box").getBytes("8859_1"),"UTF-8");//�Խñ۳����� �ҷ��ͼ� �ѱ��� �����°� ������ ��������
		List<CommentDto> list = null;//List<CommentDto> ��ü ������   null������ �ʱ�ȭ
		CommentDto li=new CommentDto();//CommentDto ��ü����
		li.setB_number(Integer.parseInt(request.getParameter("bnum")));//CommentDto �� �Խñ� ��ȣ ����
		li.setComment_box(comment);//CommentDto �� ��� ����
		li.setWriter(request.getParameter("commentwriter"));//CommentDto �� �ۼ��� ����
			
		mode.commentInsert(li); //��۾��� �޼ҵ� �� ������ li ��ü �����ش�
		
		return ".my?command=view&num="+li.getB_number();
	}
}
