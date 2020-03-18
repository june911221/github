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
			if(command.equals("list")){//게시글 리스트
				inter = Select.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("view")){//게시글 상세보기
				inter = SelectView.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;
				request.getRequestDispatcher(viewName).forward(request, response);
			}
			else if(command.equals("insert")) {//게시글쓰기
				inter = Insert.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;
				//request.getRequestDispatcher(viewName).forward(request, response);
				response.sendRedirect(viewName);
			}
			else if(command.equals("del")) {//게시글 삭제
				inter = Delete.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;
				request.getRequestDispatcher(viewName).forward(request, response);
				//response.sendRedirect(viewName);
			}
			else if(command.equals("update")) {//게시글 수정
				inter = Update.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;
				//request.getRequestDispatcher(viewName).forward(request, response);
				response.sendRedirect(viewName);
			}
			else if(command.equals("commentModify")) {//댓글 수정 팝업창에 수정할 댓글 내용 띄우기
				inter = CommentModify.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;				
			    request.getRequestDispatcher(viewName).forward(request, response);
			    //response.sendRedirect(viewName);
			}
			else if(command.equals("commentupdate")) {//댓글 수정
				inter = CommentUpdate.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;
				//request.getRequestDispatcher(viewName).forward(request, response);
				response.sendRedirect(viewName);
			}
			else if(command.equals("commentdel")) {//댓글 삭제
				inter = CommentDelete.instance();
				viewName = inter.showData(request, response);
				viewName = viewName;
				//request.getRequestDispatcher(viewName).forward(request, response);
				response.sendRedirect(viewName);
			}
			else if(command.equals("commentinsert")) {//占쏙옙占� 占쏙옙占쏙옙
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
