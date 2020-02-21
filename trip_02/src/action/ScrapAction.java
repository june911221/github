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
		HttpSession httpSession = request.getSession(true);//������ �����´�
		ScrapService scrapservice = new ScrapService();//��ũ�� ���� ��ü����
		ScrapDto scrap=new ScrapDto();//��ũ�� Dto ��ü ����
		scrap.setNum(Integer.parseInt(request.getParameter("boardnum")));//�Խñ۹�ȣ  �Ķ���� ���� String �����̱⿡ IntŸ����������ȯ
		scrap.setId((String)httpSession.getAttribute("ID"));//���ǰ����� �α��� ID��  ��������  ��ü�� ����
		scrap.setCategory(request.getParameter("category"));//ī�װ��� �����ͼ� ��ü�� ����
		scrap.setCityname(request.getParameter("cityname"));//�����̸��� �����ͼ� ��ü�� ����
		scrapservice.Scrap(scrap);//scrapService ��ȣ���ؼ� ���õ� ScrapDto ��ü���� �����ش�
				
		ActionForward forward = new ActionForward();//�׼� ��ü����
		forward.setRedirect(true);//�׼ǿ� forward �� �ƴ� ������ �̵� Redirect�� �־��ش�
		forward.setPath("do.?num="+scrap.getNum());//url����
		
		return forward;
	}

}
