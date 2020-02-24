package controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Connection extends HttpServlet{

	@Override

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		Cominterface inter = null;
		String viewName = "";

		
		try {
			if(command.equals("list")){//�Խñ� ����Ʈ
				inter = Select.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("view")){//�Խñ� �󼼺���
				inter = SelectView.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("insert")) {//�Խñ۾���
				inter = Insert.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;
				//request.getRequestDispatcher(viewName).forward(request, response);
				response.sendRedirect(viewName);
			}
			else if(command.equals("del")) {//�Խñۻ���
				inter = Delete.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;
				request.getRequestDispatcher(viewName).forward(request, response);
				//response.sendRedirect(viewName);
			}
			else if(command.equals("update")) {//�Խñ� ����
				inter = Update.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;
				//request.getRequestDispatcher(viewName).forward(request, response);
				response.sendRedirect(viewName);
			}
			else if(command.equals("commentModify")) {//��� ���� �˾�â�� ������ ��۳��� ����
				inter = CommentModify.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;				
			    request.getRequestDispatcher(viewName).forward(request, response);
			    //response.sendRedirect(viewName);
			}
			else if(command.equals("commentupdate")) {//��� ����
				inter = CommentUpdate.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;
				//request.getRequestDispatcher(viewName).forward(request, response);
				response.sendRedirect(viewName);
			}
			else if(command.equals("commentdel")) {//��� ����
				inter = CommentDelete.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;
				//request.getRequestDispatcher(viewName).forward(request, response);
				response.sendRedirect(viewName);
			}
			else if(command.equals("commentinsert")) {//��� ����
				System.out.print("d");
				inter = CommentInsert.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;
				//request.getRequestDispatcher(viewName).forward(request, response);
				response.sendRedirect(viewName);
			}else {
				viewName = "error.html";
				response.sendRedirect(viewName);
			}
		} catch (Exception e) {
			System.out.println("service err : " + e);
		}
	}
}
