package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Food_placeDto;
import vo.ScrapDto;
import vo.ThemaDto;

public class ScrapDao {
	DataSource ds;
	Connection con;
	private static ScrapDao scrapDAO;

	private ScrapDao() {
		// TODO Auto-generated constructor stub
	}

	public static ScrapDao getInstance() {
		if (scrapDAO == null) {
			scrapDAO = new ScrapDao();
		}
		return scrapDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int Scrapfoodplace(ScrapDto scrap) {//�ㅽ�щ�� ��湲�

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectsql = "select * from scrap where id=? and num=? and category=(select category from food_place where num=?)";
		int insertcount = 0;
		try {
			pstmt = con.prepareStatement(selectsql);
			pstmt.setString(1, scrap.getId());
			pstmt.setInt(2, scrap.getNum());
			pstmt.setInt(3, scrap.getNum());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				insertcount = 0;
			} else {
				String sql = "insert into scrap values(?,(select category from food_place where num=?),?,(select cityname from food_place where num=?))";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, scrap.getId());
				pstmt.setInt(2, scrap.getNum());
				pstmt.setInt(3, scrap.getNum());
				pstmt.setInt(4, scrap.getNum());
				insertcount = pstmt.executeUpdate();
				con.commit();// ���곗�댁�� 荑쇰━ 1�� ���ㅼ�留� DB�� ���μ�� �����댁�� ��踰��� 媛���濡� commit(�ㅻ�耳��댁��)
			}
		} catch (Exception ex) {
		} finally {
			close(rs);
			close(pstmt);
		}
		//System.out.println("up"+insertcount);
		return insertcount;
	}
	
	public int Scrapthema(ScrapDto scrap) {//��留��ㅽ�щ�� ��湲�
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectsql = "select * from scrap where id='' and num='' and category=(select category from thema where num='')";
		int insertcount = 0;
		try {
			pstmt = con.prepareStatement(selectsql);
			pstmt.setString(1, scrap.getId());
			pstmt.setInt(2, scrap.getNum());
			pstmt.setInt(3, scrap.getNum());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				insertcount = 0;
			} else {
				String sql = "insert into scrap values('',(select category from thema where num=''),'',(select cityname from thema where num=''))";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, scrap.getId());
				pstmt.setInt(2, scrap.getNum());
				pstmt.setInt(3, scrap.getNum());
				pstmt.setInt(4, scrap.getNum());
				insertcount = pstmt.executeUpdate();
				con.commit();// ���곗�댁�� 荑쇰━ 1�� ���ㅼ�留� DB�� ���μ�� �����댁�� ��踰��� 媛���濡� commit(�ㅻ�耳��댁��)
			}
		} catch (Exception ex) {
		} finally {
			close(rs);
			close(pstmt);
		}
		//System.out.println("up"+insertcount);
		return insertcount;
	}
	
	public int ScrapDel(ScrapDto scrap) {//�ㅽ�щ�� 痍⑥��

		PreparedStatement pstmt = null;
		String selectsql = "delete from scrap where id=? and num=? and category=?";
		int insertcount = 1;
		try {
			pstmt = con.prepareStatement(selectsql);
			pstmt.setString(1, scrap.getId());
			pstmt.setInt(2, scrap.getNum());
			pstmt.setString(3, scrap.getCategory());
				insertcount = pstmt.executeUpdate();
				con.commit();// ���곗�댁�� 荑쇰━ 1�� ���ㅼ�留� DB�� ���μ�� �����댁�� ��踰��� 媛���濡� commit(�ㅻ�耳��댁��)
			
		} catch (Exception ex) {
		} finally {
			close(pstmt);
		}
		//System.out.println("del"+insertcount);
		return insertcount;
	}
	
	public int ScrapCheck(ScrapDto scrap) {//��留� ���몃낫湲고���댁����� 濡�洹몄�명�� ���대��媛� 寃���湲��� 泥댄�ы����吏� ���몄�� insertcount媛��� ���⑹��留�寃� 由ы��
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectsql = "select * from scrap where id=? and num=? and category=?";
		int insertcount = 0;
		try {
			pstmt = con.prepareStatement(selectsql);
			pstmt.setString(1, scrap.getId());
			pstmt.setInt(2, scrap.getNum());
			pstmt.setString(3, scrap.getCategory());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				insertcount = 1;
			} 
				con.commit();// ���곗�댁�� 荑쇰━ 1�� ���ㅼ�留� DB�� ���μ�� �����댁�� ��踰��� 媛���濡� commit(�ㅻ�耳��댁��)
			
		} catch (Exception ex) {
		} finally {
			close(rs);
			close(pstmt);
		}
		//System.out.println("del"+insertcount);
		return insertcount;
	}
	
	public ArrayList<Food_placeDto> Scrapfood(ScrapDto scrap){//�ㅽ�щ�� 寃���臾쇱��� food_place�� 留�吏�留� 李얠���� 由ъ�ㅽ�몄�� �댁���� 由ы�댄����
		ArrayList<Food_placeDto> food=new ArrayList<Food_placeDto>();//ArrayList 留�吏� 媛�泥댁����
		Food_placeDto dto=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectsql = "select * from food_place where num in (select num from scrap where id=? and category='留�吏�')";
		try {
			pstmt = con.prepareStatement(selectsql);
			pstmt.setString(1, scrap.getId());
			//System.out.println("fooddao="+pstmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto= new Food_placeDto();
				dto.setCategory(rs.getString("category"));
				dto.setCityname(rs.getString("cityname"));
				dto.setContents(rs.getString("contents"));
				dto.setNum(rs.getInt("num"));
				dto.setPic(rs.getString("pic"));
				dto.setPlace(rs.getString("place"));
				dto.setTel(rs.getString("tel"));
				dto.setTime(rs.getString("time"));
				dto.setTitle(rs.getString("title"));
				food.add(dto);
			} 
			
		} catch (Exception ex) {
		} finally {
			close(rs);
			close(pstmt);
		}
		//System.out.println("foodsize="+food.size());
		return food;
	}
	
	public ArrayList<Food_placeDto> Scrapplace(ScrapDto scrap){//�ㅽ�щ�� 寃���臾쇱��� food_place�� 紐���留� 李얠���� 由ъ�ㅽ�몄�� �댁���� 由ы�댄����
		ArrayList<Food_placeDto> place=new ArrayList<Food_placeDto>();//ArrayList 紐��� 媛�泥댁����
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectsql = "select * from food_place where num in (select num from scrap where id=? and category='紐���')";
		try {
			pstmt = con.prepareStatement(selectsql);
			pstmt.setString(1, scrap.getId());
			//System.out.println("placedao="+pstmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Food_placeDto dto= new Food_placeDto();
				dto.setCategory(rs.getString("category"));
				dto.setCityname(rs.getString("cityname"));
				dto.setContents(rs.getString("contents"));
				dto.setNum(rs.getInt("num"));
				dto.setPic(rs.getString("pic"));
				dto.setPlace(rs.getString("place"));
				dto.setTel(rs.getString("tel"));
				dto.setTime(rs.getString("time"));
				dto.setTitle(rs.getString("title"));
				place.add(dto);
			}
		} catch (Exception ex) {
		} finally {
			close(rs);
			close(pstmt);
		}
		//System.out.println("placesize="+place.size());
		return place;
	}
	
	
	public ArrayList<ThemaDto> ScrapThemalist(ScrapDto scrap){//�ㅽ�щ�� 寃���臾쇱��� food_place�� 紐���留� 李얠���� 由ъ�ㅽ�몄�� �댁���� 由ы�댄����
		ArrayList<ThemaDto> thema=new ArrayList<ThemaDto>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectsql = "select * from thema where num in (select num from scrap where id=? and category='媛�議�' or category='��留�' or category='�듭�ъ�댄��' or category='�곗��')";
	
		try {
			pstmt = con.prepareStatement(selectsql);
			pstmt.setString(1, scrap.getId());
			rs = pstmt.executeQuery();
			//System.out.println("themadao="+pstmt);
			while (rs.next()) {
				ThemaDto dto= new ThemaDto();
				dto.setPic(rs.getString("pic"));
				dto.setCategory(rs.getString("category"));
				dto.setCityname(rs.getString("cityname"));
				dto.setContents(rs.getString("contents"));
				dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				thema.add(dto);
			}
			
		} catch (Exception ex) {
		} finally {
			close(rs);
			close(pstmt);
		}
		//System.out.println("themasize="+thema.size());
		return thema;
	}


}
