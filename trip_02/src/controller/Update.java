package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatismodel.ActionUpdate;
import vo.BoardDto;

public class Update implements Cominterface{
	static Update ser = new Update();
	public static Update instance() {
		return ser;
	}
	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionUpdate model = ActionUpdate.instance(); //�Խñ� ���� Action ��ü ����
		
		int num=Integer.parseInt(request.getParameter("num")); //�Խñ۹�ȣ ����������ش�
		String category=new String(request.getParameter("category").getBytes("8859_1"),"UTF-8");//ī�װ��� ������ ����ش�
		String title=new String(request.getParameter("title").getBytes("8859_1"),"UTF-8");//�������� ����������ش�
		String contents=new String(request.getParameter("contents").getBytes("8859_1"),"UTF-8");//�۳����� ����������ش�
			
		BoardDto list=new BoardDto();//BoardDto ��ü ����
		list.setNum(num);//�Խñ� ��ȣ ����
		list.setTitle(title);//������ ����
		list.setCategory(category);//ī�װ� ����
		list.setContents(contents);//�۳��� ����
		
		model.Update(list);//������Ʈ �׼� ȣ�� list�� ������ �����ش�
		
		return ".my?command=view&num="+list.getNum();
	}
}
