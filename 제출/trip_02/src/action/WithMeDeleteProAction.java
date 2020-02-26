package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.WithMeDeleteProService;
import vo.ActionForward;

public class WithMeDeleteProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{	 

		ActionForward forward = null;//�׼� ���� ���� null�� �ʱ�ȭ
		int num=Integer.parseInt(request.getParameter("num"));//�Խñ� ��ȣ ���� String Ÿ�� �Ķ���͸� Integer�� ����ȯ
		String nowPage = request.getParameter("page");//������ �Խñ��� �ִ� ��������ȣ ������ ����
				
		WithMeDeleteProService DeleteProService = new WithMeDeleteProService();//WithMeDeleteProService ��ü ����
		DeleteProService.removeArticle(num);//WithMeDeleteProService ��ü�� ���� removeArticle �޼ҵ带 ȣ���ϰ� ������ �Խñ� ��ȣ�� ������
	
		forward = new ActionForward();//��ü ����
		forward.setRedirect(true);//������ �̵� Redirect�� true���� �־� �����������̾ƴ� �������̵��� �Ѵ�
		forward.setPath("WithMe.do?page=" + nowPage);// �̵��� url�ּ� ����

		return forward;
	}

}