package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ScrapService;
import vo.ActionForward;
import vo.ScrapDto;

public class ScrapAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{	 
		HttpSession httpSession = request.getSession(true);//세션을 가져온다
		ScrapService scrapservice = new ScrapService();//스크랩 서비스 객체생성
		ScrapDto scrap=new ScrapDto();//스크랩 Dto 객체 생성
		scrap.setNum(Integer.parseInt(request.getParameter("boardnum")));//게시글번호  파라미터 값이 String 형태이기에 Int타입으로형변환
		scrap.setId((String)httpSession.getAttribute("ID"));//세션값에서 로그인 ID를  가져온후  객체에 셋팅
		scrap.setCategory(request.getParameter("category"));//카테고리를 가져와서 객체에 셋팅
		scrap.setCityname(request.getParameter("cityname"));//도시이름을 가져와서 객체에 셋팅
		scrapservice.Scrap(scrap);//scrapService 를호출해서 셋팅된 ScrapDto 객체값을 보내준다
				
		ActionForward forward = new ActionForward();//액션 객체형성
		forward.setRedirect(true);//액션에 forward 가 아닌 페이지 이동 Redirect를 넣어준다
		forward.setPath("do.?num="+scrap.getNum());//url셋팅
		
		return forward;
	}

}
