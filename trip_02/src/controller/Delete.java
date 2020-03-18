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

		ActionDelete model = ActionDelete.instance(); // 野껓옙占쏙옙疫뀐옙占쏙옙占쏙옙 action 揶쏉옙筌ｋ똻占쏙옙占쏙옙
		int num = Integer.parseInt(request.getParameter("num"));
		// 癰귨옙占쏙옙 num占쏙옙 野껓옙占쏙옙疫뀐옙 甕곤옙占쏙옙 占쏙옙占쏙옙(String 占쏙옙占쏙옙占쏙옙 野껓옙占쏙옙疫뀐옙甕곤옙占쎈챶占쏙옙 Inteager�몴�눛占쎈벏占쏙옙 int 占쏙옙占쏙옙占쎌눖占� 占쏙옙癰귨옙占쏙옙)
		String category = new String(request.getParameter("category").getBytes("8859_1"), "UTF-8");
		// 野껓옙占쏙옙疫뀐옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 野껓옙占쏙옙疫뀐옙 燁삳똾占쏙옙�⑨옙�뵳�딉옙占� 筌랃옙占쏙옙 �뵳�딉옙�끋占쏙옙 占쏙옙占쎈똻占썹몴占� 占쏙옙占썬끉竊쒏묾怨쀯옙占쏙옙占� 燁삳똾占쏙옙�⑨옙�뵳�됵옙占� 癰귨옙占쏙옙占쏙옙 筌욑옙占쏙옙

		BoardDto list = new BoardDto();// BoardDto 揶쏉옙筌ｏ옙 占쏙옙占쏙옙
		list.setNum(num);// 野껓옙占쏙옙疫뀐옙甕곤옙占쏙옙 占쏙옙占쏙옙

		model.Delete(list);// 占썩돦占쏙옙占쏙옙占쎈똻占쏙옙紐꾬옙占쏙옙筌롫똻占쏙옙 癰귨옙占쏙옙 list�몴占� 癰귣�占쎈똻占쏙옙占�

		if (category.equals("후기")) {// category 揶쏉옙占쏙옙 �뜮占썸뤃占쏙옙占쏙옙占� 占쎈�占쏙옙 燁삳똾占쏙옙�⑨옙�뵳�딉옙占� 筌랃옙占쏙옙 占쏙옙占쎈똻占썹몴占� �뵳�뗰옙�똾占쎈똻占�
			return ".my?command=list&category=hugi";
		} else if (category.equals("정보&팁")) {
			return ".my?command=list&category=infoandtip";
		} else {
			return ".my?command=list&category=QA";
		}
	}

}
