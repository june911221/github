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
		ActionInsert model = ActionInsert.instance(); // 寃���湲� ����Action 媛�泥댄����

		String category = new String(request.getParameter("category").getBytes("8859_1"), "UTF-8");
		// 移댄��怨�由� 媛��� 蹂����� �댁��以���(new
		// String(request.getParameter("���쇰�명�곌�").getBytes("8859_1"),"UTF-8")���쇰�명�곕� ���댁�� 媛���
		// ��湲��� 源⑥�吏���寃� �≪��以���)
		String title = new String(request.getParameter("title").getBytes("8859_1"), "UTF-8");
		// 湲���紐⑹�� 蹂����� �댁��以���
		String writer = request.getParameter("writer");
		// 湲��댁�대�� 蹂����� �댁��以���
		String contents = new String(request.getParameter("contents").getBytes("8859_1"), "UTF-8");
		// 湲��댁�⑹�� 蹂����� �댁��以���

		BoardDto list = new BoardDto();// BoardDto 媛�泥댄���깊�� 媛��� �����댁���
		list.setCategory(category);// 移댄��怨�由� ����
		list.setTitle(title);// 湲���紐� ����
		list.setWriter(writer);// ���깆�� ����
		list.setContents(contents);// 寃���湲��댁�� ����

		model.boardInsert(list);// �≪�����댁��몄���硫댁�� 蹂��� list瑜� 蹂대�댁���

		if (category.equals("여행후기")) {// category 媛��� 鍮�援����� �대�� 移댄��怨�由ъ�� 留��� ���댁�瑜� 由ы�댄�댁�
			return ".my?command=list&category=hugi";
		} else if (category.equals("정보&팁")) {
			return ".my?command=list&category=infoandtip";
		} else {
			return ".my?command=list&category=QA";
		}

	}
}
