package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.WithMeListService;
import svc.With_UserCountListService;
import vo.ActionForward;
import vo.PageInfo;
import vo.WithMeBean;
import vo.With_UserBean;

public class With_UserPeopleCountInfoAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArrayList<With_UserBean> countList = new ArrayList<With_UserBean>();

		With_UserCountListService ListService = new With_UserCountListService();
		countList = ListService.countList(Integer.parseInt(request.getParameter("boardnum")));

		request.setAttribute("articleList", countList);
		ActionForward forward = new ActionForward();
		forward.setPath("/WithMECountInfoList.jsp");
		return forward;

	}
}
