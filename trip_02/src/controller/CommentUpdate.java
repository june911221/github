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
		ActionCommentUpdate mode = ActionCommentUpdate.instance();//��۾��� ��ü����
		
		String comment=new String(request.getParameter("comment_box").getBytes("8859_1"),"UTF-8");//��� ������ �ҷ��ͼ� �ѱ��� �����°� ������ ��������
		
			
		List<CommentDto> list = null;//List<CommentDto> ��ü ������   null������ �ʱ�ȭ
		CommentDto li=new CommentDto();//CommentDto ��ü����
		li.setC_number(Integer.parseInt(request.getParameter("commnetnum")));//CommentDto �� �Խñ� ��ȣ ����
		li.setComment_box(comment);//CommentDto �� ��� ����
		
		mode.commentUpdate(li); //��۾��� �޼ҵ� �� ������ li ��ü �����ش�
		
		return ".my?command=view&num="+request.getParameter("bnum");//num=�Խñ۹�ȣ �Խñ۹�ȣ�� ������ �Խ���View �������δ� �õ�
	}
}
