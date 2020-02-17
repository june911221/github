package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.boardDto;

public class boardDao {
	private static final int ArrayList = 0;
	private static final int BoardDto = 0;
	Connection conn=null; 
	Statement stmt=null;

	public boardDao(){
	try{//생성자로 드라이버 호출
		Class.forName("com.mysql.jdbc.Driver");
	}catch(Exception e){
	}
}
	
	public Connection Drive(){
	try{//DB연결
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useSSL=false&useUnicode=true&characterEncoding=utf8","root","911221");
	}catch(Exception e){
		
	}
	return conn;
}
	
	public void close() {//DB닫는 함수
		try{
		
			
			stmt.close();
			
		}catch(Exception e) {
			
		}try{
			
			conn.close();
			
		}catch(Exception e) {
			
		}
			
	}
	
	
	public ArrayList<boardDto> List() {//여행후기 게시판 순서대로 출력
		ArrayList<boardDto> boarderlist=new ArrayList<boardDto>(); 
		try{
			conn=Drive();
		stmt=conn.createStatement();//여행후기 게실글 전체출력으로 order by num desc 게시물번호로 내림차순으로 정렬
		String command = "select * from board where category='여행후기' order by num desc;";
		ResultSet rs=stmt.executeQuery(command);
		while(rs.next()) {
			
			boardDto dto=new boardDto();
			dto.setNum(rs.getInt("num"));
			dto.setCategory(rs.getString("category"));
			dto.setTitle(rs.getString("title"));
			dto.setWriter(rs.getString("writer"));
			dto.setDate(rs.getDate("date"));
			dto.setHits(rs.getInt("hits"));
			
			boarderlist.add(dto);
		}
		stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		close();
		return boarderlist;
	}
	
	public ArrayList<boardDto> List(String opt,String sel) {//검색조건과 검색내용을 받아 리스트 출력
		ArrayList<boardDto> boarderlist=new ArrayList<boardDto>();
		
		try{
			conn=Drive();
		if(opt.equals("none")) {
			stmt=conn.createStatement();//후기 전체 데이터에서(제목,글쓴이,내용) DB검색
			String command = "select * from board where title like '%"+sel+"%' or writer like "+"'%"+sel+"%' or contents like "+"'%"+sel+"%' order by num desc;";
			//System.out.print(command);
			ResultSet rs=stmt.executeQuery(command);
			while(rs.next()) {
				
				boardDto dto=new boardDto();
				dto.setNum(rs.getInt("num"));
				dto.setCategory(rs.getString("category"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setDate(rs.getDate("date"));
				dto.setHits(rs.getInt("hits"));
				
				boarderlist.add(dto);
			}
			}
		else if(opt.equals("title_contents")) {
			stmt=conn.createStatement();//제목+내용으로 DB검색
			String command = "select * from board where title like '%"+sel+"%' or contents like '%"+sel+"%' order by num desc;";
			//System.out.print(command);
			ResultSet rs=stmt.executeQuery(command);
			while(rs.next()) {
				
				boardDto dto=new boardDto();
				dto.setNum(rs.getInt("num"));
				dto.setCategory(rs.getString("category"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setDate(rs.getDate("date"));
				dto.setHits(rs.getInt("hits"));
				
				boarderlist.add(dto);
			}
			}
		else{
			stmt=conn.createStatement();//select옵션과 검색어에따른 DB검색 명령
			String command = "select * from board where "+opt+" like '%"+sel+"%' order by num desc;";
			//System.out.print(command);
			ResultSet rs=stmt.executeQuery(command);
			
			while(rs.next()) {
			
			boardDto dto=new boardDto();
			dto.setNum(rs.getInt("num"));
			dto.setCategory(rs.getString("category"));
			dto.setTitle(rs.getString("title"));
			dto.setWriter(rs.getString("writer"));
			dto.setDate(rs.getDate("date"));
			dto.setHits(rs.getInt("hits"));
			
			boarderlist.add(dto);
		}
		}
		stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		close();
		return boarderlist;
	}
	
	public int hits(String hits) {//뷰페이지 클릭시 조회수를받아 +1을 더해서 반환
		int num=Integer.parseInt(hits)+1;
		return num;
	}
	
	public void hitsUpdate(String hits,String num) {//조회수 업데이트하기위해 현재 조회수와 게시글번호를 받아와서 게시글번호조건에해당하는 hits를 업데이트한다
		int hitsnum=hits(hits);//조회수를 업데이트 하기위해 hits를 매개변수로 받아와 hits() 메소드에 현재 hits를 넣어서 +1시켜서 리턴받는다
		int NO=Integer.parseInt(num);
		try {
			conn=Drive();
			stmt = conn.createStatement();
			String command = "update board set hits="+hitsnum+" where num="+NO+";";
			//System.out.print(command);
			int rowNum = stmt.executeUpdate(command);
			if(rowNum<1)
			throw new Exception("데이터를 DB에 입력할 수 없습니다."); 
			
			stmt.close();
	} catch (Exception e) {
		System.out.println(e);
	}
		
	close();
	}
	
	
	
	public  ArrayList<boardDto> BoardContentsView(String num) {//뷰페이지 게시글번호를 받아서 리스트를 출력
		ArrayList<boardDto> boarderView = new ArrayList<boardDto>();
		int number;
		number=Integer.parseInt(num);
		try {
			conn=Drive();
		stmt = conn.createStatement();
			String command = "select * from board where num="+number+";";
			ResultSet rs = stmt.executeQuery(command);	
			
			while(rs.next()){
				boardDto dto = new boardDto();
				dto.setNum(rs.getInt("num"));
				dto.setCategory(rs.getString("category"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setDate(rs.getDate("date"));
				dto.setHits(rs.getInt("hits"));
				dto.setContents(rs.getString("contents"));
				
				boarderView.add(dto);
			}

			
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		close();
return boarderView;
	}
	
		
	public void BoardWrite(String category,String title,String writer,String contents){//DB에 게시글 입력
			String date="now()";//작성일을 DB에서 현재시간으로 처리하기위해 now()명령어를 스트링값으로 넣어준다
		    int hits=0;
		try {
			conn=Drive();
			stmt = conn.createStatement();
			String command = "insert into board (category,title,writer,date,hits,contents) values('"+category+"','"+title+"','"+writer+"',"+date+","+hits+",'"+contents+"');";
			System.out.println(command);
			int rowNum = stmt.executeUpdate(command);
			if(rowNum<1)
			throw new Exception("데이터를 DB에 입력할 수 없습니다."); 
			
			stmt.close();
	} catch (Exception e) {
		System.out.println(e);
	}
		
	close();
}
	
	public void Boardupdate(String num,String category,String title,String contents) {//게시글 수정시 DB 업데이트
		int number=Integer.parseInt(num);
		try {
			conn=Drive();
			stmt = conn.createStatement();
			String command = "update board set category='"+category+"',"+"title='"+title+"',"+"contents='"+contents+"'"+"where num="+number+";";
			System.out.println(command);
			int rowNum = stmt.executeUpdate(command);
			if(rowNum<1)
			throw new Exception("데이터를 DB에 입력할 수 없습니다."); 
			
			stmt.close();
	} catch (Exception e) {
		System.out.println(e);
	}
		
	close();
	}
	

	
	public void BoardDelete(String num) {//게시글 삭제
		int number=Integer.parseInt(num);
		try {
			conn=Drive();
			stmt = conn.createStatement();
			String command = "delete from board where number="+number+";";
			
			int rowNum = stmt.executeUpdate(command);
			if(rowNum<1)
			throw new Exception("데이터를 DB에 입력할 수 없습니다."); 
			
			stmt.close();
	} catch (Exception e) {
		System.out.println(e);
	}
		
	close();
	}

}




