package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.WithMeDetailService;
import svc.WithMeSinchungCheckService;
import vo.ActionForward;
import vo.WithMeBean;

public class WithMeDetailAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession(true);// 세션을 가져온다

		int num = Integer.parseInt(request.getParameter("num"));// 파라미터로 넘어온 게시글 번호를 Integer를 통해 int타입으로 형변환후 변수 num에 셋팅
		String page = request.getParameter("page"); // 보고있던 게시판 페이지를 변수 page에 셋팅

		WithMeDetailService DetailService = new WithMeDetailService();// WithMeDetailService 객체생성
		WithMeSinchungCheckService checkservice = new WithMeSinchungCheckService();// WithMeSinchungCheckService 객체 생성
																					// 신청인원 체크서비스이다

		WithMeBean article = DetailService.getArticle(num);// WithMeDetailService 클래스에 게시글 번호를 보내 게시글 내용을 WithMeBean 객체에
															// 담아둔다

		String id = (String) httpSession.getAttribute("ID");// 세션값에서 로그인 ID를 가져온후 변수 id에 셋팅

		int check = 0;// 로그인 ID를 가지고 신청인원이 있는지 체크하기위해 변수 check 생성후 값은 0을준다

		if (id != null) {
			check = checkservice.sinchungCheck(num, id);// 신청인원을 체크해서 값을 반환받는다 만약 로그인ID가 이미 해당 게시글에 신청을 했다면 값은 1을 리턴받는다
		}

		ActionForward forward = new ActionForward();// 액션 객체 생성
		request.setAttribute("page", page);// page=page
		request.setAttribute("check", check);// article=article
		request.setAttribute("article", article);// article=article
		forward.setPath("/WithMeView.jsp");// 액션 페이지 셋팅
		return forward;
	}

}