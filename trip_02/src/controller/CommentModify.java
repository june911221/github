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
		ActionCommentModify mode = ActionCommentModify.instance();//��� ����â ��ü����
		CommentDto li=new CommentDto();//CommentDto ��ü����
		li.setC_number(Integer.parseInt(request.getParameter("commentnum")));//CommentDto �� �Խñ� ��ȣ ����	
		
		ArrayList<CommentDto> list=(ArrayList<CommentDto>)mode.commentModify(li); //��۾��� �޼ҵ� �� ������ li ��ü �����ش�
		
		request.setAttribute("commentdata", list);//commentdata=list
		
		return "CommentModify.jsp";
	}
}
