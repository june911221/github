package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import action.ScrapAction;
import action.ThemaDetailAction;
import action.ThemaListAction;
import action.WithMeDeleteProAction;
import action.WithMeDetailAction;
import action.WithMeListAction;
import action.WithMeModifyProAction;
import action.WithMePeopleCountAction;
import action.WithMeWriteProAction;
import action.With_UserCountDel;
import action.With_UserPeopleCountInfoAction;
import vo.ActionForward;

@WebServlet("*.do")
public class BoardFrontController extends javax.servlet.http.HttpServlet 
{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action=null;

		if(command.equals("/WithMeWrite.do")){//�Բ��ؿ� �۵��
			action  = new WithMeWriteProAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        else if(command.equals("/WithMePeopleCountPage.do")){//�Բ��ؿ� ��û �˾�������
        	forward=new ActionForward();
			forward.setPath("/with_user.jsp");
		}
        else if(command.equals("/With_userDel.do")){//�Բ��ؿ� ��û ���
        	action  = new With_UserCountDel();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/WithMePeopleCount.do")){//�Բ��ؿ� ��û
			action  = new WithMePeopleCountAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/With_UserPeopleCountInfo.do")){//�Բ��ؿ� ��û�� ����Ʈ �˾�â
			action  = new With_UserPeopleCountInfoAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/WithMeWriteForm.do")){//�Բ��ؿ� �۾���������
			forward=new ActionForward();
			forward.setPath("/WithMeWrite.jsp");
		}
		else if(command.equals("/WithMe.do")){//�Բ��ؿ� ������
			action = new WithMeListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/WithMeDetail.do")){//�Բ��ؿ� �󼼺���
			action = new WithMeDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/WithMeDeletePro.do")){//�Բ��ؿ� �Խñۻ���
			//System.out.println("control");
			action = new WithMeDeleteProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}			
		}
		else if(command.equals("/WithMeModifyPro.do")){//�Բ��ؿ� �Խñۼ���
			action = new WithMeModifyProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}	
		else if(command.equals("/Thema.do")){//�׸� ������
			action = new ThemaListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/ThemaView.do")){//�׸� �󼼺��� ������
			action = new ThemaDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/Scrap.do")){//�׸� �󼼺��� ������
			action = new ScrapAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(forward != null){
			
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher=
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}   
	
}