package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.WithMeDetailService;
import svc.WithMeSinchungCheckService;
import vo.ActionForward;
import vo.WithMeBean;

 public class WithMeDetailAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		HttpSession httpSession = request.getSession(true);//������ �����´�
		 
		int num=Integer.parseInt(request.getParameter("num"));//�Ķ���ͷ� �Ѿ�� �Խñ� ��ȣ�� Integer�� ���� intŸ������ ����ȯ�� ���� num�� ����
		String page = request.getParameter("page"); //�����ִ� �Խ��� �������� ���� page�� ����
						
		WithMeDetailService DetailService = new WithMeDetailService();//WithMeDetailService ��ü����
		WithMeSinchungCheckService checkservice = new WithMeSinchungCheckService();//WithMeSinchungCheckService ��ü ���� ��û�ο� üũ�����̴�
		
		WithMeBean article = DetailService.getArticle(num);//WithMeDetailService Ŭ������ �Խñ� ��ȣ�� ���� �Խñ� ������ WithMeBean ��ü��  ��Ƶд� 
		
		String id=(String) httpSession.getAttribute("ID");//���ǰ����� �α��� ID��  �������� ���� id�� ����
		
		int check = 0;//�α��� ID�� ������ ��û�ο��� �ִ��� üũ�ϱ����� ���� check ������ ���� 0���ش�
		
		if(id!=null) {
		check = checkservice.sinchungCheck(num, id);//��û�ο��� üũ�ؼ� ���� ��ȯ�޴´� ���� �α���ID�� �̹� �ش� �Խñۿ� ��û�� �ߴٸ� ���� 1�� ���Ϲ޴´�
		}
				
		ActionForward forward = new ActionForward();//�׼� ��ü ����
		request.setAttribute("page", page);//page=page
		request.setAttribute("check", check);//article=article
	   	request.setAttribute("article", article);//article=article
   		forward.setPath("/WithMeView.jsp");//�׼� ������ ����
   		return forward;
	 }
	 
}