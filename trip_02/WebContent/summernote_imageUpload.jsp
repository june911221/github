<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%
    // 이미지 업로드할 경로
	String uploadPath = "D:/project/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/trip_02/upload";
    int size = 10 * 1024 * 1024;  // 업로드 사이즈 제한 10M 이하
	
	String fileName = ""; // 파일명
	
	try{
        // 파일업로드 및 업로드 후 파일명 가져옴
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		Enumeration files = multi.getFileNames();
		String file = (String)files.nextElement(); 
		fileName = multi.getFilesystemName(file); 
		//out.print(fileName);
	}catch(Exception e){
		e.printStackTrace();
	}	
    // 업로드된 경로와 파일명을 통해 이미지의 경로를 생성
	uploadPath = "/upload/" + fileName;
    out.print(uploadPath);
%>