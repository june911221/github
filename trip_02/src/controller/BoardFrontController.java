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

		if(command.equals("/WithMeWrite.do")){//함께해요 글등록
			action  = new WithMeWriteProAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        else if(command.equals("/WithMePeopleCountPage.do")){//함께해요 신청 팝업페이지
        	forward=new ActionForward();
			forward.setPath("/with_user.jsp");
		}
        else if(command.equals("/With_userDel.do")){//함께해요 신청 취소
        	action  = new With_UserCountDel();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/WithMePeopleCount.do")){//함께해요 신청
			action  = new WithMePeopleCountAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/With_UserPeopleCountInfo.do")){//함께해요 신청자 리스트 팝업창
			action  = new With_UserPeopleCountInfoAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/WithMeWriteForm.do")){//함께해요 글쓰기페이지
			forward=new ActionForward();
			forward.setPath("/WithMeWrite.jsp");
		}
		else if(command.equals("/WithMe.do")){//함께해요 페이지
			action = new WithMeListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/WithMeDetail.do")){//함께해요 상세보기
			action = new WithMeDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/WithMeDeletePro.do")){//함께해요 게시글삭제
			//System.out.println("control");
			action = new WithMeDeleteProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}			
		}
		else if(command.equals("/WithMeModifyPro.do")){//함께해요 게시글수정
			action = new WithMeModifyProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}	
		else if(command.equals("/Thema.do")){//테마 페이지
			action = new ThemaListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/ThemaView.do")){//테마 상세보기 페이지
			action = new ThemaDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/Scrap.do")){//테마 상세보기 페이지
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