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

	
	public void close() {//DB�ݴ� �Լ�
		try{
		
			
			stmt.close();
			
		}catch(Exception e) {
			
		}try{
			
			conn.close();
			
		}catch(Exception e) {
			
		}
			
	}
	public void SelectPlace(int num, String title, String contents, String pic, String place, String tel, String time, String category, String cityname) {
		try {
			conn=Drive();
			stmt = conn.createStatement();
			String command = "select * from food_place where category='"+category+" and cityname="+cityname +"';";
		    ResultSet rs=stmt.executeQuery(command);
		    
		    if(rs.next()) {
		    	String Cityname = rs.getString("cityname");
		    			}
		    stmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public ArrayList<Food_placeDto> Food_placeDto(String title){
		ArrayList<Food_placeDto> fp = new ArrayList<Food_placeDto>();
		try {
			conn=Drive();
			stmt=conn.createStatement();
			String command = "select * from food_place where title='"+title+"';";
			ResultSet rs= stmt.executeQuery(command);
			while(rs.next()) {
				Food_placeDto dto= new Food_placeDto();
				dto.setCategory(rs.getString("category"));
				dto.setTitle(rs.getString("title"));
				dto.setCityname(rs.getString("cityname"));
				dto.setContents(rs.getString("contents"));
				dto.setTel(rs.getString("tel"));
			}
		
		
	}catch(Exception e) {
	}close(); return fp;
	
}
}