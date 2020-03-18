package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatismodel.ActionList;
import svc.WithMeListService;
import vo.ActionForward;
import vo.BoardDto;
import vo.PageInfo;

public class Select implements Cominterface {

	static Select ser = new Select();

	public static Select instance() {
		return ser;
	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionList model = ActionList.instance(); // ActionList 媛�泥� ����
		int page = 1;
		int limit = 10;

		String category = request.getParameter("category");// 移댄��怨�由щ�� 蹂���濡� 吏���

		if (category.equals("hugi")) {// 蹂��� category 媛��� 鍮�援��댁�� 媛��� �곕Ⅸ 移댄��怨�由ш��� 蹂�寃쏀�댁���
			category = "여행후기";
		} else if (category.equals("infoandtip")) {
			category = "정보&팁";
		} else {
			category = "Q&A";
		}

		BoardDto li = new BoardDto();// BoardDto 媛�泥� ����
		li.setCategory(category);// 移댄��怨�由� ����

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (request.getParameter("page") == null) {
			page = 1;
		}
		int listCount = (int) model.boardlistcount(li);// 湲��� 媛���瑜� 援ы�댁�� listCount 蹂����� �대����
		// 珥� ���댁� ��.
		int maxPage = (int) ((double) listCount / limit + 0.95); // 0.95瑜� ���댁�� �щ┝ 泥�由�.
		// ���� ���댁��� 蹂댁�ъ� ���� ���댁� ��(1, 11, 21 ��...)
		int startPage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		// ���� ���댁��� 蹂댁�ъ� 留�吏�留� ���댁� ��.(10, 20, 30 ��...)
		int endPage = startPage + 10 - 1;

		if (endPage > maxPage)
			endPage = maxPage;

		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);

		ArrayList<BoardDto> list = (ArrayList<BoardDto>) model.boardlist(li, page, limit);// 蹂��� 移댄��怨�由щ�� 寃����� 移댄��怨�由щ�� 援щ��댁��
																							// 異��ν��湲곗���� �ъ��
		// Action���댁� �� category 蹂���瑜� 蹂대�댁＜怨� ArrayList<BoardDto> 蹂��� list�� 由ы�닿��� �댁��以���
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("data", list);// data=list

		if (category.equals("여행후기")) {// category 媛��� 鍮�援����� �대�� 移댄��怨�由ъ�� 留��� ���댁�瑜� 由ы�댄�댁�
			return "Hugi.jsp";
		} else if (category.equals("정보&팁")) {
			return "InfoandTip.jsp";
		} else {
			return "QandA.jsp";
		}
	}
}
