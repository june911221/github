package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.BoardDto;

public class BoardDao {
	private static final int ArrayList = 0;
	private static final int BoardDto = 0;
	Connection conn=null; 
	Statement stmt=null;

	public BoardDao(){
	try{//�����ڷ� ����̹� ȣ��
		Class.forName("com.mysql.jdbc.Driver");
	}catch(Exception e){
	}
}
	
	public Connection Drive(){
	try{//DB����
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useSSL=false&useUnicode=true&characterEncoding=utf8","root","911221");
	}catch(Exception e){
		
	}
	return conn;
}
	
	public void close() {//DB�ݴ� �Լ�
		try{
		
			
			stmt.close();
			
		}catch(Exception e) {
			
		}try{
			
			conn.close();
			
		}catch(Exception e) {
			
		}
			
	}
	
	
	public ArrayList<BoardDto> List() {//�����ı� �Խ��� ������� ���
		ArrayList<BoardDto> boarderlist=new ArrayList<BoardDto>(); 
		try{
			conn=Drive();
		stmt=conn.createStatement();//�����ı� �ԽǱ� ��ü������� order by num desc �Խù���ȣ�� ������������ ����
		String command = "select * from board where category='�����ı�' order by num desc;";
		ResultSet rs=stmt.executeQuery(command);
		while(rs.next()) {
			
			BoardDto dto=new BoardDto();
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
	
	public ArrayList<BoardDto> List(String opt,String sel) {//�˻����ǰ� �˻������� �޾� ����Ʈ ���
		ArrayList<BoardDto> boarderlist=new ArrayList<BoardDto>();
		
		try{
			conn=Drive();
		if(opt.equals("none")) {
			stmt=conn.createStatement();//�ı� ��ü �����Ϳ���(����,�۾���,����) DB�˻�
			String command = "select * from board where title like '%"+sel+"%' or writer like "+"'%"+sel+"%' or contents like "+"'%"+sel+"%' order by num desc;";
			//System.out.print(command);
			ResultSet rs=stmt.executeQuery(command);
			while(rs.next()) {
				
				BoardDto dto=new BoardDto();
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
			stmt=conn.createStatement();//����+�������� DB�˻�
			String command = "select * from board where title like '%"+sel+"%' or contents like '%"+sel+"%' order by num desc;";
			//System.out.print(command);
			ResultSet rs=stmt.executeQuery(command);
			while(rs.next()) {
				
				BoardDto dto=new BoardDto();
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
			stmt=conn.createStatement();//select�ɼǰ� �˻������ DB�˻� ���
			String command = "select * from board where "+opt+" like '%"+sel+"%' order by num desc;";
			//System.out.print(command);
			ResultSet rs=stmt.executeQuery(command);
			
			while(rs.next()) {
			
			BoardDto dto=new BoardDto();
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
	
	public int hits(String hits) {//�������� Ŭ���� ��ȸ�����޾� +1�� ���ؼ� ��ȯ
		int num=Integer.parseInt(hits)+1;
		return num;
	}
	
	public void hitsUpdate(String hits,String num) {//��ȸ�� ������Ʈ�ϱ����� ���� ��ȸ���� �Խñ۹�ȣ�� �޾ƿͼ� �Խñ۹�ȣ���ǿ��ش��ϴ� hits�� ������Ʈ�Ѵ�
		int hitsnum=hits(hits);//��ȸ���� ������Ʈ �ϱ����� hits�� �Ű������� �޾ƿ� hits() �޼ҵ忡 ���� hits�� �־ +1���Ѽ� ���Ϲ޴´�
		int NO=Integer.parseInt(num);
		try {
			conn=Drive();
			stmt = conn.createStatement();
			String command = "update board set hits="+hitsnum+" where num="+NO+";";
			//System.out.print(command);
			int rowNum = stmt.executeUpdate(command);
			if(rowNum<1)
			throw new Exception("�����͸� DB�� �Է��� �� �����ϴ�."); 
			
			stmt.close();
	} catch (Exception e) {
		System.out.println(e);
	}
		
	close();
	}
	
	
	
	public  ArrayList<BoardDto> BoardContentsView(String num) {//�������� �Խñ۹�ȣ�� �޾Ƽ� ����Ʈ�� ���
		ArrayList<BoardDto> boarderView = new ArrayList<BoardDto>();
		int number;
		number=Integer.parseInt(num);
		try {
			conn=Drive();
		stmt = conn.createStatement();
			String command = "select * from board where num="+number+";";
			ResultSet rs = stmt.executeQuery(command);	
			
			while(rs.next()){
				BoardDto dto = new BoardDto();
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
	
		
	public void BoardWrite(String category,String title,String writer,String contents){//DB�� �Խñ� �Է�
			String date="now()";//�ۼ����� DB���� ����ð����� ó���ϱ����� now()��ɾ ��Ʈ�������� �־��ش�
		    int hits=0;
		try {
			conn=Drive();
			stmt = conn.createStatement();
			String command = "insert into board (category,title,writer,date,hits,contents) values('"+category+"','"+title+"','"+writer+"',"+date+","+hits+",'"+contents+"');";
			System.out.println(command);
			int rowNum = stmt.executeUpdate(command);
			if(rowNum<1)
			throw new Exception("�����͸� DB�� �Է��� �� �����ϴ�."); 
			
			stmt.close();
	} catch (Exception e) {
		System.out.println(e);
	}
		
	close();
}
	
	public void Boardupdate(String num,String category,String title,String contents) {//�Խñ� ������ DB ������Ʈ
		int number=Integer.parseInt(num);
		try {
			conn=Drive();
			stmt = conn.createStatement();
			String command = "update board set category='"+category+"',"+"title='"+title+"',"+"contents='"+contents+"'"+"where num="+number+";";
			System.out.println(command);
			int rowNum = stmt.executeUpdate(command);
			if(rowNum<1)
			throw new Exception("�����͸� DB�� �Է��� �� �����ϴ�."); 
			
			stmt.close();
	} catch (Exception e) {
		System.out.println(e);
	}
		
	close();
	}
	

	
	public void BoardDelete(String num) {//�Խñ� ����
		int number=Integer.parseInt(num);
		try {
			conn=Drive();
			stmt = conn.createStatement();
			String command = "delete from board where number="+number+";";
			
			int rowNum = stmt.executeUpdate(command);
			if(rowNum<1)
			throw new Exception("�����͸� DB�� �Է��� �� �����ϴ�."); 
			
			stmt.close();
	} catch (Exception e) {
		System.out.println(e);
	}
		
	close();
	}

}




