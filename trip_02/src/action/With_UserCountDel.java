package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.With_UserCountDelService;
import vo.ActionForward;
import vo.With_UserBean;

public class With_UserCountDel implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession(true);// ������ �����´�
		With_UserCountDelService countDel = new With_UserCountDelService();// �Բ��ؿ� ��û�� ���� ��ü����
		With_UserBean user = new With_UserBean();// ��û�� Dto ��ü ����
		user.setNum(Integer.parseInt(request.getParameter("boardnum")));// �Խñ۹�ȣ �Ķ���� ���� String �����̱⿡ IntŸ����������ȯ
		user.setId((String) httpSession.getAttribute("ID"));// ���ǰ����� �α��� ID�� �������� user ��ü�� ����
		countDel.usercountDel(user);// WithMePeopleCountService ��ȣ���ؼ� ���õ� Withm_UserBean ��ü���� �����ش�

		ActionForward forward = new ActionForward();// �׼� ��ü����
		forward.setRedirect(true);// �׼ǿ� forward �� �ƴ� ������ �̵� Redirect�� �־��ش�
		forward.setPath("WithMeDetail.do?num=" + user.getNum() + "&page=" + request.getParameter("page") + "&ID="
				+ user.getId());// url����

		return forward;
	}
}
