<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
String name=request.getParameter("namea");
String gender=request.getParameter("chk_male");
String year=request.getParameter("year");
String month=request.getParameter("month");
String day=request.getParameter("day");
String phone2=request.getParameter("phone_2");
String phone3=request.getParameter("phone_3");
String phone4=request.getParameter("phone_4");
String id=request.getParameter("idd");
String pw=request.getParameter("pw_1");
String birth=year+"-"+month+"-"+day;
String phone=phone2+"-"+phone3+"-"+phone4;
Connection conn=null; 
Statement stmt=null;
try{
Class.forName("com.mysql.jdbc.Driver");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hjy","root","911221");

if(conn == null)
	throw new Exception("데이터베이스에 연결할 수 없습니다.<br>");
stmt=conn.createStatement();
String command = String.format("insert into sign values"+"('"+name+"','"+gender+"','"+birth+"','"+phone+"','"+id+"','"+pw+"');");
int rowNum = stmt.executeUpdate(command);
if(rowNum<1)
throw new Exception("데이터를 DB에 입력할 수 없습니다."); 
}finally{
	try{
		stmt.close();
		}catch(Exception ignored){
		}
		try{
			conn.close();}
		catch(Exception ignored){
		}
	}
	response.sendRedirect("InsertRead.jsp?name="+name);
	%>