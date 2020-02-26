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
		WithMePeopleCountService Peoplecount = new WithMePeopleCountService();//�Բ��ؿ� ��û�� ���� ��ü����
		
		With_UserBean user=new With_UserBean();//��û�� Dto ��ü ����
		user.setNum(Integer.parseInt(request.getParameter("boardnum")));//�԰Խñ۹�ȣ  �Ķ���� ���� String �����̱⿡ IntŸ����������ȯ
		user.setId(request.getParameter("sessionID"));//��û�� ID ����
		user.setTel(request.getParameter("tel"));//��û�� ����ó ����
		user.setCount(Integer.parseInt(request.getParameter("peoplecount")));//��û�ο� ���� �Ķ���� ���� String �����̱⿡ IntŸ����������ȯ
		
		Peoplecount.peoplecount(user);// WithMePeopleCountService ��ȣ���ؼ� ���õ� Withm_UserBean ��ü���� �����ش�
		
		System.out.println(request.getParameter("page"));
		
		ActionForward forward = new ActionForward();//�׼� ��ü����
		forward.setRedirect(true);//�׼ǿ� forward �� �ƴ� ������ �̵� Redirect�� �־��ش�
		forward.setPath("WithMeDetail.do?num="+user.getNum()+"&page="+request.getParameter("page")+"&ID="+user.getId());//url����
		
		return forward;

	}

}
