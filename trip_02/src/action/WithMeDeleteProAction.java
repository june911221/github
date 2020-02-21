package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.WithMeDeleteProService;
import vo.ActionForward;

public class WithMeDeleteProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{	 

		ActionForward forward = null;//액션 변수 생성 null로 초기화
		int num=Integer.parseInt(request.getParameter("num"));//게시글 번호 셋팅 String 타입 파라미터를 Integer로 형변환
		String nowPage = request.getParameter("page");//삭제한 게시글이 있던 페이지번호 변수에 셋팅
				
		WithMeDeleteProService DeleteProService = new WithMeDeleteProService();//WithMeDeleteProService 객체 생성
		DeleteProService.removeArticle(num);//WithMeDeleteProService 객체를 통해 removeArticle 메소드를 호출하고 변수로 게시글 번호를 보낸다
	
		forward = new ActionForward();//객체 생성
		forward.setRedirect(true);//페이지 이동 Redirect에 true값을 주어 페이지고정이아닌 페이지이동을 한다
		forward.setPath("WithMe.do?page=" + nowPage);// 이동할 url주소 셋팅

		return forward;
	}

}