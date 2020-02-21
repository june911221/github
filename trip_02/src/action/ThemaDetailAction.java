package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ThemaDetailService;
import vo.ActionForward;
import vo.ThemaDto;

public class ThemaDetailAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	   	
		int num=Integer.parseInt(request.getParameter("num"));//�Ķ���ͷ� �Ѿ�� �Խñ� ��ȣ�� Integer�� ���� intŸ������ ����ȯ�� ���� num�� ����
		String page = request.getParameter("page"); //�����ִ� �Խ��� �������� ���� page�� ����
						
		ThemaDetailService DetailService = new ThemaDetailService();//ThemaDetailService ��ü����
		
		ThemaDto article = DetailService.getArticle(num);//ThemaDetailService Ŭ������ �Խñ� ��ȣ�� ���� �Խñ� ������ WithMeBean ��ü��  ��Ƶд� 
				
		ActionForward forward = new ActionForward();//�׼� ��ü ����
		request.setAttribute("page", page);//page=page
	   	request.setAttribute("article", article);//article=article
  		forward.setPath("/ThemaView.jsp");//�׼� ������ ����
  		return forward;
	 }
	 

}
