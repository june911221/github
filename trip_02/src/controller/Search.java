package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mybatismodel.ActionSearch;
import vo.BoardDto;
import vo.PageInfo;

public class Search implements Cominterface {

	static Search ser = new Search();

	public static Search instance() {
		return ser;
	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionSearch model = ActionSearch.instance(); // ActionSearch 揶쏉옙筌ｏ옙 占쏙옙占쏙옙

		String category = request.getParameter("category");// 燁삳똾占쏙옙�⑨옙�뵳�됵옙占� 癰귨옙占쏙옙嚥∽옙 筌욑옙占쏙옙

		if (category.equals("hugi")) {// 癰귨옙占쏙옙 category 揶쏉옙占쏙옙 �뜮占썸뤃占쏙옙�똻占쏙옙 揶쏉옙占쏙옙 占쎄퀡�뀲 燁삳똾占쏙옙�⑨옙�뵳�덌옙占쏙옙 癰귨옙野껋�占쎈똻占쏙옙占�
			category = "여행후기";
		} else if (category.equals("infoandtip")) {
			category = "정보%팁";
		} else {
			category = "Q&A";
		}

		String select = request.getParameter("Boardselectmenu");// 野껓옙占쏙옙筌∽옙 selectmenu 揶쏉옙占쏙옙 揶쏉옙占쎈챷占썩뫀占쏙옙
		String searchinfo = new String(request.getParameter("searchinfo").getBytes("8859_1"), "UTF-8");// 野껓옙占쏙옙占쎈�占쏙옙 揶쏉옙占쎈챷占썩뫀占쏙옙

		BoardDto li = new BoardDto();// BoardDto 揶쏉옙筌ｏ옙 占쏙옙占쏙옙
		ArrayList<BoardDto> list = null;// ArrayList 揶쏉옙筌ｏ옙 占쏙옙占쏙옙 null嚥∽옙 �룯占썸묾怨좑옙占�
		int page = 1;
		int limit = 10;

		li.setCategory(category);// 燁삳똾占쏙옙�⑨옙�뵳占� 占쏙옙占쏙옙

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (request.getParameter("page") == null) {
			page = 1;
		}

		int listCount = 0;// 疫뀐옙占쏙옙 揶쏉옙占쏙옙�몴占� 占쎈똻占쏙옙 listCount癰귨옙占쏙옙�몴占� 筌랃옙占쏙옙占쏙옙

		if (select.equals("none")) {

			li.setTitle(searchinfo);
			li.setContents(searchinfo);
			li.setWriter(searchinfo);
			listCount = (int) model.boardlistcountnone(li);// 疫뀐옙占쏙옙 揶쏉옙占쏙옙�몴占� �뤃�뗰옙�똻占쏙옙 listCount 癰귨옙占쏙옙占쏙옙 占쎈�占쏙옙占쏙옙
			list = (ArrayList<BoardDto>) model.boardlistnone(li);
			// Action占쏙옙占쎈똻占� 占쏙옙 category 癰귨옙占쏙옙�몴占� 癰귣�占쎈똻竊쒏�⑨옙 ArrayList<BoardDto> 癰귨옙占쏙옙 list占쏙옙 �뵳�뗰옙�떯占쏙옙占� 占쎈똻占쏙옙餓ο옙占쏙옙
		} else if (select.equals("title")) {
			li.setTitle(searchinfo);
			listCount = (int) model.boardlistcounttitle(li);// 疫뀐옙占쏙옙 揶쏉옙占쏙옙�몴占� �뤃�뗰옙�똻占쏙옙 listCount 癰귨옙占쏙옙占쏙옙 占쎈�占쏙옙占쏙옙
			list = (ArrayList<BoardDto>) model.boardlisttitle(li);
			// Action占쏙옙占쎈똻占� 占쏙옙 category 癰귨옙占쏙옙�몴占� 癰귣�占쎈똻竊쒏�⑨옙 ArrayList<BoardDto> 癰귨옙占쏙옙 list占쏙옙 �뵳�뗰옙�떯占쏙옙占� 占쎈똻占쏙옙餓ο옙占쏙옙
		} else if (select.equals("title_contents")) {
			li.setTitle(searchinfo);
			li.setContents(searchinfo);
			listCount = (int) model.boardlistcounttitle_contents(li);// 疫뀐옙占쏙옙 揶쏉옙占쏙옙�몴占� �뤃�뗰옙�똻占쏙옙 listCount 癰귨옙占쏙옙占쏙옙 占쎈�占쏙옙占쏙옙
			list = (ArrayList<BoardDto>) model.boardlisttitle_contents(li);
			// Action占쏙옙占쎈똻占� 占쏙옙 category 癰귨옙占쏙옙�몴占� 癰귣�占쎈똻竊쒏�⑨옙 ArrayList<BoardDto> 癰귨옙占쏙옙 list占쏙옙 �뵳�뗰옙�떯占쏙옙占� 占쎈똻占쏙옙餓ο옙占쏙옙
		} else if (select.equals("contents")) {
			li.setContents(searchinfo);
			listCount = (int) model.boardlistcountcontents(li);// 疫뀐옙占쏙옙 揶쏉옙占쏙옙�몴占� �뤃�뗰옙�똻占쏙옙 listCount 癰귨옙占쏙옙占쏙옙 占쎈�占쏙옙占쏙옙
			list = (ArrayList<BoardDto>) model.boardlistcontents(li);
			// Action占쏙옙占쎈똻占� 占쏙옙 category 癰귨옙占쏙옙�몴占� 癰귣�占쎈똻竊쒏�⑨옙 ArrayList<BoardDto> 癰귨옙占쏙옙 list占쏙옙 �뵳�뗰옙�떯占쏙옙占� 占쎈똻占쏙옙餓ο옙占쏙옙
		} else if (select.equals("writer")) {
			li.setWriter(searchinfo);
			listCount = (int) model.boardlistcountwriter(li);// 疫뀐옙占쏙옙 揶쏉옙占쏙옙�몴占� �뤃�뗰옙�똻占쏙옙 listCount 癰귨옙占쏙옙占쏙옙 占쎈�占쏙옙占쏙옙
			list = (ArrayList<BoardDto>) model.boardlistwriter(li);
			// Action占쏙옙占쎈똻占� 占쏙옙 category 癰귨옙占쏙옙�몴占� 癰귣�占쎈똻竊쒏�⑨옙 ArrayList<BoardDto> 癰귨옙占쏙옙 list占쏙옙 �뵳�뗰옙�떯占쏙옙占� 占쎈똻占쏙옙餓ο옙占쏙옙
		}

		int maxPage = (int) ((double) listCount / limit + 0.95); // 0.95�몴占� 占쏙옙占쎈똻占쏙옙 占싼됤뵝 筌ｏ옙�뵳占�.
		// 占쏙옙占쏙옙 占쏙옙占쎈똻占쏙옙占� 癰귣똻占싼딉옙 占쏙옙占쏙옙 占쏙옙占쎈똻占� 占쏙옙(1, 11, 21 占쏙옙...)
		int startPage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		// 占쏙옙占쏙옙 占쏙옙占쎈똻占쏙옙占� 癰귣똻占싼딉옙 筌랃옙筌욑옙筌랃옙 占쏙옙占쎈똻占� 占쏙옙.(10, 20, 30 占쏙옙...)
		int endPage = startPage + 10 - 1;

		if (endPage > maxPage)
			endPage = maxPage;

		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		li.setCategory(category);// 燁삳똾占쏙옙�⑨옙�뵳占� 占쏙옙占쏙옙
 
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("data", list);// data=list

		if (category.equals("후기")) {// category 揶쏉옙占쏙옙 �뜮占썸뤃占쏙옙占쏙옙占� 占쎈�占쏙옙 燁삳똾占쏙옙�⑨옙�뵳�딉옙占� 筌랃옙占쏙옙 占쏙옙占쎈똻占썹몴占� �뵳�뗰옙�똾占쎈똻占�
			return "Hugi.jsp";
		} else if (category.equals("정보&팁")) {
			return "InfoandTip.jsp";
		} else {
			return "QandA.jsp";
		}
	}

}
