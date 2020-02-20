package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vo.Food_placeDto;



public class Food_placeDao {

	Connection conn = null;
	Statement stmt = null;
	
	public Food_placeDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {
		}
		
	}
	public Connection Drive() {
		try{
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useSSL=false&useUnicode=true&characterEncoding=utf8","root","911221");
		}catch(Exception e) {
		}
	return conn;
	}

	
	public void close() {//DB´Ý´Â ÇÔ¼ö
		try{
		
			
			stmt.close();
			
		}catch(Exception e) {
			
		}try{
			
			conn.close();
			
		}catch(Exception e) {
			
		}
			
	}
	public Food_placeDto SelectPlace(int num) {
		
		 Food_placeDto dto = null;
		 
		 try {
			conn=Drive();
			stmt = conn.createStatement();
			String command = "select * from food_place where num="+num+";";
		    ResultSet rs=stmt.executeQuery(command);
		   
		    
		    if(rs.next()) {
		    	dto = new Food_placeDto();
		    	dto.setCategory(rs.getString("category"));
				dto.setTitle(rs.getString("title"));
				dto.setCityname(rs.getString("cityname"));
				dto.setContents(rs.getString("contents"));
				dto.setTel(rs.getString("tel"));
				dto.setPic(rs.getString("pic"));
				dto.setPlace(rs.getString("place"));
				dto.setTime(rs.getString("time"));
				dto.setNum(rs.getInt("num"));
		    }
		    
		    stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return dto;
		
	}
	
	public ArrayList<Food_placeDto> Food_placeDto(){
		ArrayList<Food_placeDto> fp = new ArrayList<Food_placeDto>();
		try {
			conn=Drive();
			stmt=conn.createStatement();
			String command = "select * from food_place order by num desc;";
			ResultSet rs= stmt.executeQuery(command);
			while(rs.next()) {
				Food_placeDto dto= new Food_placeDto();
				dto.setCategory(rs.getString("category"));
				dto.setTitle(rs.getString("title"));
				dto.setCityname(rs.getString("cityname"));
				dto.setContents(rs.getString("contents"));
				dto.setTel(rs.getString("tel"));
				dto.setPic(rs.getString("pic"));
				dto.setPlace(rs.getString("place"));
				dto.setTime(rs.getString("time"));
				dto.setNum(rs.getInt("num"));
				fp.add(dto);
			}
		
		
	}catch(Exception e) {
	}close(); return fp;
	
}
}
