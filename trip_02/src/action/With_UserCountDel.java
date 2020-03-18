package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.With_UserCountDelService;
import vo.ActionForward;
import vo.With_UserBean;

public class With_UserCountDel implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession(true);// 세션을 가져온다
		With_UserCountDelService countDel = new With_UserCountDelService();// 함께해요 신청자 서비스 객체생성
		With_UserBean user = new With_UserBean();// 신청자 Dto 객체 생성
		user.setNum(Integer.parseInt(request.getParameter("boardnum")));// 게시글번호 파라미터 값이 String 형태이기에 Int타입으로형변환
		user.setId((String) httpSession.getAttribute("ID"));// 세션값에서 로그인 ID를 가져온후 user 객체에 셋팅
		countDel.usercountDel(user);// WithMePeopleCountService 를호출해서 셋팅된 Withm_UserBean 객체값을 보내준다

		ActionForward forward = new ActionForward();// 액션 객체형성
		forward.setRedirect(true);// 액션에 forward 가 아닌 페이지 이동 Redirect를 넣어준다
		forward.setPath("WithMeDetail.do?num=" + user.getNum() + "&page=" + request.getParameter("page") + "&ID="
				+ user.getId());// url셋팅

		return forward;
	}
}
