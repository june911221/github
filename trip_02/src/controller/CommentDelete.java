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
		ActionCommentDelete mode = ActionCommentDelete.instance(); //delete action ��ü ����
				
		CommentDto list=new CommentDto();//CommentDto ��ü ����
		list.setC_number(Integer.parseInt(request.getParameter("commentnum")));
		//��ü�� ��۹�ȣ ����(String Ÿ������ �Ѿ�� �Ķ�����̱⿡ Int Ÿ���� ��۹�ȣ�� �����ϱ����� Integer������ ����ȯ)
		
		mode.commentDelete(list);
		//delete�׼ǿ� �Խñۺ��� ����
		
		return ".my?command=view&num="+request.getParameter("bnum"); 
		//��ۻ����� �Խñ� ��ȣ�� �Ķ���ͷ� ���������� ���� �ؼ� �����ִ� �������� �ٽ� �̵��Ѵ� 
	}

}
