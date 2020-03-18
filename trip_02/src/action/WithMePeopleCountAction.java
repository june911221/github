package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WithMeDao;
import svc.WithMePeopleCountService;
import vo.ActionForward;
import vo.With_UserBean;

public class WithMePeopleCountAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		WithMePeopleCountService Peoplecount = new WithMePeopleCountService();// 함께해요 신청자 서비스 객체생성

		With_UserBean user = new With_UserBean();// 신청자 Dto 객체 생성
		user.setNum(Integer.parseInt(request.getParameter("boardnum")));// 게게시글번호 파라미터 값이 String 형태이기에 Int타입으로형변환
		user.setId(request.getParameter("sessionID"));// 신청자 ID 셋팅
		user.setTel(request.getParameter("tel"));// 신청자 연락처 셋팅
		user.setCount(Integer.parseInt(request.getParameter("peoplecount")));// 신청인원 셋팅 파라미터 값이 String 형태이기에 Int타입으로형변환

		Peoplecount.peoplecount(user);// WithMePeopleCountService 를호출해서 셋팅된 Withm_UserBean 객체값을 보내준다

		// System.out.println(request.getParameter("page"));

		ActionForward forward = new ActionForward();// 액션 객체형성
		forward.setRedirect(true);// 액션에 forward 가 아닌 페이지 이동 Redirect를 넣어준다
		forward.setPath("WithMeDetail.do?num=" + user.getNum() + "&page=" + request.getParameter("page") + "&ID="
				+ user.getId());// url셋팅

		return forward;

	}

}
