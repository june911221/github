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
	try{//占쏙옙占쏙옙占쌘뤄옙 占쏙옙占쏙옙譴占� 호占쏙옙
		Class.forName("com.mysql.jdbc.Driver");
	}catch(Exception e){
	}
}
	
	public Connection Drive(){
	try{//DB占쏙옙占쏙옙
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useSSL=false&useUnicode=true&characterEncoding=utf8","root","911221");
	}catch(Exception e){
		
	}
	return conn;
}
	
	public void close() {//DB占쌥댐옙 占쌉쇽옙
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
