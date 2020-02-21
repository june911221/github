package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ThemaListService;
import vo.ActionForward;
import vo.PageInfo;
import vo.ThemaDto;

public class ThemaListAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		ArrayList<ThemaDto> articleList=new ArrayList<ThemaDto>();
		PageInfo pageInfo = new PageInfo();
		int page=1;
		int limit=9;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("page")==null){
			page=1;
		}
		
		if(request.getParameter("category")==null) {
		
	    ThemaListService ListService = new ThemaListService();
		int listCount=ListService.getListCount();
		articleList = ListService.getArticleList(page,limit);
		
		//�� ������ ��.
  	    int maxPage=(int)((double)listCount/limit+0.95); //0.95�� ���ؼ� �ø� ó��.
  		//���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
  		int startPage = (((int) ((double)page / 9 + 0.9)) - 1) * 9 + 1;
  		//���� �������� ������ ������ ������ ��.(10, 20, 30 ��...)
  	        int endPage = startPage+9-1;
		
  		if (endPage> maxPage) endPage= maxPage;

  		pageInfo.setEndPage(endPage);
  		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		}
		else {
			    ThemaListService ListService = new ThemaListService();
				int listCount=ListService.CategorygetListCount(request.getParameter("category"));
				articleList = ListService.getcategoryArticleList(page,limit,request.getParameter("category"));
				
				//�� ������ ��.
		  	    int maxPage=(int)((double)listCount/limit+0.95); //0.95�� ���ؼ� �ø� ó��.
		  		//���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
		  		int startPage = (((int) ((double)page / 9 + 0.9)) - 1) * 9 + 1;
		  		//���� �������� ������ ������ ������ ��.(10, 20, 30 ��...)
		  	        int endPage = startPage+9-1;
				
		  		if (endPage> maxPage) endPage= maxPage;

		  		pageInfo.setEndPage(endPage);
		  		pageInfo.setListCount(listCount);
				pageInfo.setMaxPage(maxPage);
				pageInfo.setPage(page);
				pageInfo.setStartPage(startPage);
			
		}
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		ActionForward forward= new ActionForward();
  		forward.setPath("/Thema.jsp");
  		return forward;
  		
	 }
}
