package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatismodel.ActionList;
import vo.BoardDto;

public class Select implements Cominterface{

	static Select ser = new Select();
	public static Select instance() {
		return ser;
	}
	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionList model = ActionList.instance(); //ActionList ��ü ����
		
		String category=request.getParameter("category");//ī�װ��� ������ ����
						
		if(category.equals("hugi")) {//���� category ���� ���ؼ� ���� ���� ī�װ����� �������ش�
			category="�����ı�";
		}else if(category.equals("infoandtip")) {
			category="����&��";
		}else {
			category="Q&A";
		}
		
		BoardDto li=new BoardDto();//BoardDto ��ü ����
		li.setCategory(category);//ī�װ� ����
		
		ArrayList<BoardDto> list = (ArrayList<BoardDto>)model.boardlist(li);//���� ī�װ��� �Խ��� ī�װ��� �����ؼ� ����ϱ����� ���
		//Action������ �� category ������ �����ְ�  ArrayList<BoardDto> ���� list��  ���ϰ��� ����ش�
		
		request.setAttribute("data", list);//data=list
		
		if(category.equals("�����ı�")) {//category ���� ���Ͽ� �ش� ī�װ��� �´� �������� ��������
			return "Hugi.jsp";
		}
		else if(category.equals("����&��")) {
			return "InfoandTip.jsp";
		}
		else {
			return "QandA.jsp";
		}
	}
}
