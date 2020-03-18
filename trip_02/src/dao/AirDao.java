package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.AirDto;
import vo.WithMeBean;

public class AirDao {
	DataSource ds;
	Connection con;
	private static AirDao airDAO;

	private AirDao() {
		// TODO Auto-generated constructor stub
	}

	public static AirDao getInstance() {
		if (airDAO == null) {
			airDAO = new AirDao();
		}
		return airDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public ArrayList<AirDto> airlist(AirDto air) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from air where kind=? and dcity=? and acity=? and dday=? and aday=? and seat=?";
		ArrayList<AirDto> airlist = new ArrayList<AirDto>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, air.getKind());
			pstmt.setString(2, air.getDcity());
			pstmt.setString(3, air.getAcity());
			pstmt.setDate(4, air.getDday());
			pstmt.setDate(5, air.getAday());
			pstmt.setString(6, air.getSeat());
			
			System.out.println(pstmt);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				AirDto list = new AirDto();
				list.setAcity(rs.getString("acity"));
				System.out.println(list.getAcity());
				list.setAday(rs.getDate("aday"));
				System.out.println(list.getAday());
				list.setDcity(rs.getString("dcity"));
				list.setDday(rs.getDate("dday"));
				list.setAirline(rs.getString("airline"));
				list.setAirnum(rs.getString("airnum"));
				list.setFare(rs.getInt("fare"));
				list.setKind(rs.getString("kind"));
				list.setOil(rs.getInt("oil"));
				list.setPer(rs.getInt("per"));
				list.setSeat(rs.getString("seat"));
				list.setTax(rs.getInt("tax"));
				list.setTictax(rs.getInt("tictax"));
				list.setAll(rs.getInt("all"));
				airlist.add(list);
			}
		} catch (Exception ex) {
		} finally {
			close(rs);
			close(pstmt);
		}
		return airlist;
	}

}
