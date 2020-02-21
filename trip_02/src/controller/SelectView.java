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
		
		ActionListView model = ActionListView.instance();//�Խñۺ��� Action ��ü����
		ActionHitsUp mode2 = ActionHitsUp.instance();//��ȸ�� ���� Action ��ü ����
		ActionCommentList mode3 = ActionCommentList.instance();//��۸���Ʈ Action��ü ����
		
		int num=Integer.parseInt(request.getParameter("num"));//�Խñ۹�ȣ�� ���� num�� ����ش�
					
		BoardDto li=new BoardDto();//BoardDto ��ü����
		li.setNum(num);//��ü�� �۹�ȣ ����
		
		if(request.getParameter("hits") != null) {
		int hits=Integer.parseInt(request.getParameter("hits"))+1;//��ȸ���� ���� hits�� ����ִµ� �̋� �Ѿ�� �Ķ���Ͱ��� +1������ ��ȸ���� �����ѻ��·� hits����ش�
		li.setHits(hits);//��ü�� ��ȸ�� ����
		mode2.HitsUp(li);//��ȸ�� �����׼ǿ� li ���� �����ش�
		}
				
		ArrayList<BoardDto> list = (ArrayList<BoardDto>)model.boardlist(li);//�Խñ� �󼼺���
		//Action�������� num ������ �����ְ�  ArrayList<BoardDto> ���� list��  ���ϰ��� ����ش�
		ArrayList<CommentDto> commentlist = (ArrayList<CommentDto>)mode3.commentlist(num);//�ش�Խñۿ� ��� �ҷ�����
		//Action�������� num ������ �����ְ�  ArrayList<CommentDto> ���� commentlist��  ���ϰ��� ����ش�
		
		request.setAttribute("data", list);//data=list(�Խñ۳���)
		request.setAttribute("codata",commentlist);//codata=commentlist(��۸���Ʈ)
		
		return "BoardView.jsp";
	}
}
