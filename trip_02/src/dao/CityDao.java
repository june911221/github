package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import vo.CityDto;

public class CityDao {
	Connection conn=null; 
	Statement stmt=null;

	public CityDao(){
	try{//생성자로 드라이버 호출
		Class.forName("com.mysql.jdbc.Driver");
	}catch(Exception e){
	}
}
	
	public Connection Drive(){
	try{//DB연결
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dataex?useSSL=false&useUnicode=true&characterEncoding=utf8","root","123456789a");
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
		
		public CityDto City(String cityname) {
			CityDto city = new CityDto();
			
			conn=Drive();
			try{
			    conn=Drive();
				stmt=conn.createStatement();
			    String command = "select * from city where cityname='"+cityname+"';";
			    ResultSet rs = stmt.executeQuery(command);	
			    
				if(rs.next()){
					city.setCityname(rs.getString("cityname"));
					city.setCity_info(rs.getString("city_info"));
					city.setCity_img(rs.getString("city_img"));
				}
				
			stmt.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			
				return city;
			}

}
