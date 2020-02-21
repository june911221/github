package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatismodel.ActionInsert;
import Mybatismodel.ActionList;
import vo.BoardDto;


public class Insert implements Cominterface {
	static Insert ser = new Insert();
	public static Insert instance() {
		return ser;
	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionInsert model = ActionInsert.instance(); //�Խñ� �Է�Action ��ü����
		
		String category=new String(request.getParameter("category").getBytes("8859_1"),"UTF-8");
		//ī�װ� ���� ������ ����ش�(new String(request.getParameter("�Ķ���Ͱ�").getBytes("8859_1"),"UTF-8")�Ķ���ͷ� �Ѿ�� ���� �ѱ��� �������ʰ� ����ش�)
		String title=new String(request.getParameter("title").getBytes("8859_1"),"UTF-8");
		//�������� ������ ����ش�
		String writer=request.getParameter("writer");
		//�۾��̸� ������ ����ش�
		String contents=new String(request.getParameter("contents").getBytes("8859_1"),"UTF-8");
		//�۳����� ������ ����ش�		
		
		BoardDto list=new BoardDto();//BoardDto ��ü������  ���� �������ش�
		list.setCategory(category);//ī�װ� ����
		list.setTitle(title);//������ ����
		list.setWriter(writer);//�ۼ��� ����
		list.setContents(contents);//�Խñ۳��� ����
		
		model.boardInsert(list);//�׼�������ȣ���ϸ鼭 ���� list�� �����ش�
		
		if(category.equals("�����ı�")) {//category ���� ���Ͽ� �ش� ī�װ��� �´� �������� ��������
			return ".my?command=list&category=hugi";
		}
		else if(category.equals("����&��")) {
			return ".my?command=list&category=infoandtip";
		}
		else {
			return ".my?command=list&category=QA";
		}
		
	}
}
