package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ThemaDetailService;
import vo.ActionForward;
import vo.ThemaDto;

public class ThemaDetailAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int num = Integer.parseInt(request.getParameter("num"));// 파라미터로 넘어온 게시글 번호를 Integer를 통해 int타입으로 형변환후 변수 num에 셋팅
		String page = request.getParameter("page"); // 보고있던 게시판 페이지를 변수 page에 셋팅

		ThemaDetailService DetailService = new ThemaDetailService();// ThemaDetailService 객체생성

		ThemaDto article = DetailService.getArticle(num);// ThemaDetailService 클래스에 게시글 번호를 보내 게시글 내용을 WithMeBean 객체에
															// 담아둔다

		ActionForward forward = new ActionForward();// 액션 객체 생성
		request.setAttribute("page", page);// page=page
		request.setAttribute("article", article);// article=article
		forward.setPath("/ThemaView.jsp");// 액션 페이지 셋팅
		return forward;
	}

}
