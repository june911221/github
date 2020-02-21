package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatismodel.ActionDelete;
import vo.BoardDto;

public class Delete implements Cominterface {
	static Delete ser = new Delete();
	public static Delete instance() {
		return ser;
	}
	
	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionDelete model = ActionDelete.instance(); //�Խñۻ��� action ��ü����
		int num=Integer.parseInt(request.getParameter("num"));
		//���� num�� �Խñ� ��ȣ �Է�(String Ÿ���� �Խñ۹�ȣ�� Inteager������ int Ÿ������ ����ȯ)
		String category=new String(request.getParameter("category").getBytes("8859_1"),"UTF-8");
		//�Խñ��� �������� ������ �Խñ� ī�װ��� �´� ����Ʈ �������� �����ֱ����� ī�װ��� ������ ���� 
		
		BoardDto list=new BoardDto();//BoardDto ��ü ����
		list.setNum(num);//�Խñ۹�ȣ ����
		
		model.Delete(list);//�׼�������ȣ���ϸ鼭 ���� list�� �����ش�
		
		
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
