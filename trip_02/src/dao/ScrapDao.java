package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import vo.ScrapDto;

public class ScrapDao {
	DataSource ds;
	Connection con;
	private static ScrapDao scrapDAO;

	private ScrapDao() {
		// TODO Auto-generated constructor stub
	}
	

	public static ScrapDao getInstance(){
		if(scrapDAO == null){
			scrapDAO = new ScrapDao();
		}
		return scrapDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	public void Scrap(ScrapDto scrap) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(
					"insert into thema ");
			//pstmt.setInt(1, num);
			rs= pstmt.executeQuery();
			
			
		}
		catch(Exception ex){
		}finally{
			close(rs);
			close(pstmt);
		}
		
	}
}
