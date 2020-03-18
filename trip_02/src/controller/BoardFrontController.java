package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.FlightGo;
import action.ScrapPageAction;
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
import svc.ScrapService;
import svc.ScrapdeleteService;
import vo.ActionForward;
import vo.ScrapDto;

@WebServlet("*.do")
public class BoardFrontController extends javax.servlet.http.HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/WithMeWrite.do")) {// �④��댁�� 湲��깅�
			action = new WithMeWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/WithMePeopleCountPage.do")) {// �④��댁�� ��泥� �������댁�
			forward = new ActionForward();
			forward.setPath("/with_user.jsp");
		} else if (command.equals("/With_userDel.do")) {// �④��댁�� ��泥� 痍⑥��
			action = new With_UserCountDel();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/WithMePeopleCount.do")) {// �④��댁�� ��泥�
			action = new WithMePeopleCountAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/With_UserPeopleCountInfo.do")) {// �④��댁�� ��泥��� 由ъ�ㅽ�� ����李�
			action = new With_UserPeopleCountInfoAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/WithMeWriteForm.do")) {// �④��댁�� 湲��곌린���댁�
			forward = new ActionForward();
			forward.setPath("/WithMeWrite.jsp");
		} else if (command.equals("/WithMe.do")) {// �④��댁�� ���댁�
			action = new WithMeListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/WithMeDetail.do")) {// �④��댁�� ���몃낫湲�
			action = new WithMeDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/WithMeDeletePro.do")) {// �④��댁�� 寃���湲�����
			action = new WithMeDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/WithMeModifyPro.do")) {// �④��댁�� 寃���湲�����
			action = new WithMeModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Thema.do")) {// ��留� ���댁�
			action = new ThemaListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/ThemaView.do")) {// ��留� ���몃낫湲� ���댁�
			action = new ThemaDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/scrappage.do")) {// ��留� ���몃낫湲� ���댁�
			action = new ScrapPageAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 	else if(command.equals("/flight.do")) {//占쏙옙占� 占쏙옙占쏙옙
			System.out.println("dd");
			action = new FlightGo();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (command.equals("/Scrap.do")) {// 寃���湲� �ㅽ�щ��

			HttpSession httpSession = request.getSession(true);// �몄���� 媛��몄�⑤��
			ScrapService scrapservice = new ScrapService();// �ㅽ�щ�� ��鍮��� 媛�泥댁����
			ScrapDto scrap = new ScrapDto();// �ㅽ�щ�� Dto 媛�泥� ����
			scrap.setNum(Integer.parseInt(request.getParameter("number")));// 寃���湲�踰��� ���쇰�명�� 媛��� String �����닿린�� Int�����쇰���蹂���
			scrap.setId((String) httpSession.getAttribute("ID"));// �몄��媛����� 濡�洹몄�� ID瑜� 媛��몄�⑦�� 媛�泥댁�� ����

			int insertcount = 0;// insertcount 蹂��� ����
			if (request.getParameter("table").equals("food_place")) {// ���대��� �곕�� �ㅽ�щ�⑹�� �ㅻⅤ寃�����(food_place)�ㅽ�щ��
				try {
					insertcount = scrapservice.Scrapfoodplace(scrap);
					// scrapService 瑜쇳�몄��댁�� ������ ScrapDto 媛�泥닿��� 蹂대�댁���
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {// ��留� �ㅽ�щ��
					insertcount = scrapservice.Scrapthema(scrap);
					// scrapService 瑜쇳�몄��댁�� ������ ScrapDto 媛�泥닿��� 蹂대�댁���
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			response.getWriter().print(insertcount);
		} else if (command.equals("/ScrapDel.do")) {// 寃���湲� �ㅽ�щ�� ����

			HttpSession httpSession = request.getSession(true);// �몄���� 媛��몄�⑤��
			ScrapdeleteService scrapdeleteservice = new ScrapdeleteService();// �ㅽ�щ�� ��鍮��� 媛�泥댁����
			ScrapDto scrap = new ScrapDto();// �ㅽ�щ�� Dto 媛�泥� ����
			scrap.setNum(Integer.parseInt(request.getParameter("number")));// 寃���湲�踰��� ���쇰�명�� 媛��� String �����닿린�� Int�����쇰���蹂���
			scrap.setId((String) httpSession.getAttribute("ID"));// �몄��媛����� 濡�洹몄�� ID瑜� 媛��몄�⑦�� 媛�泥댁�� ����
			scrap.setCategory(request.getParameter("category"));// 寃��ㅺ� 移댄��怨�由� 媛��� 媛��몄�⑤��
			int insertcount = 1;// insertcount 蹂��� ����
			if (request.getParameter("table").equals("food_place")) {
				try {
					insertcount = scrapdeleteservice.Scrapdel(scrap);
					// scrapService 瑜쇳�몄��댁�� ������ ScrapDto 媛�泥닿��� 蹂대�댁���
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					insertcount = scrapdeleteservice.Scrapdel(scrap);
					// scrapService 瑜쇳�몄��댁�� ������ ScrapDto 媛�泥닿��� 蹂대�댁���
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			response.getWriter().print(insertcount);
		}

		if (forward != null) {

			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}