package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ScrapPageService;
import vo.ActionForward;
import vo.Food_placeDto;
import vo.ScrapDto;
import vo.ThemaDto;

public class ScrapPageAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession httpSession = request.getSession(true);// 세션을 가져온다
		ScrapDto scrap = new ScrapDto();// 스크랩 Dto 객체 생성
		ScrapPageService Service = new ScrapPageService();// ThemaDetailService 객체생성
		ArrayList<ThemaDto> thema= new ArrayList<ThemaDto>();
		ArrayList<Food_placeDto> food = new ArrayList<Food_placeDto>();
		ArrayList<Food_placeDto> place = new ArrayList<Food_placeDto>();
		scrap.setId((String) httpSession.getAttribute("ID"));// 세션값에서 로그인 ID를 가져온후 객체에 셋팅
		
		food = Service.Scrapfood(scrap);
		place = Service.Scrapplace(scrap);
		thema = Service.Scrapthema(scrap);

		ActionForward forward = new ActionForward();// 액션 객체 생성
		request.setAttribute("food", food);
		request.setAttribute("place", place);
		request.setAttribute("thema", thema);
		forward.setPath("/scrap.jsp");// 액션 페이지 셋팅
		return forward;
	}

}
