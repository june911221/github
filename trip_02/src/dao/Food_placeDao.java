package dao;

import static db.JdbcUtil.close;

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
		} catch (Exception e) {
		}

	}

	public Connection Drive() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/data?useSSL=false&useUnicode=true&characterEncoding=utf8", "root",
					"911221");
		} catch (Exception e) {
		}
		return conn;
	}

	public void close() {// DB�떕�뒗 �븿�닔
		try {

			stmt.close();

		} catch (Exception e) {

		}
		try {

			conn.close();

		} catch (Exception e) {

		}

	}

	// 移댄뀒怨좊━�뿉 �빐�떦�븯�뒗 �쟾泥� 湲��쓽 媛쒖닔 援ы븯湲�.
	public int selectcategoryListCount(String category) {

		int listCount = 0;
		ResultSet rs = null;

		try {
			conn = Drive();
			stmt = conn.createStatement();
			String command = "select count(*) from food_place where category='" + category + "';";

			rs = stmt.executeQuery(command);

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return listCount;

	}

	// 移댄뀒怨좊━�� 寃��깋�뼱�뿉 �빐�떦�븯�뒗 湲��쓽 媛쒖닔 援ы븯湲�.
	public int SearchselectcategoryListCount(String category, String cityname) {

		int listCount = 0;
		ResultSet rs = null;

		try {
			conn = Drive();
			stmt = conn.createStatement();
			String command = "select count(*) from food_place where category='" + category + "' and cityname like '%"
					+ cityname + "%';";

			rs = stmt.executeQuery(command);
			// System.out.println(command);
			if (rs.next()) {
				listCount = rs.getInt(1);
			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return listCount;

	}

	public Food_placeDto SelectPlace(int num) { // 寃뚯떆湲� �긽�꽭蹂닿린

		Food_placeDto dto = null;

		try {
			conn = Drive();
			stmt = conn.createStatement();
			String command = "select * from food_place where num=" + num + ";";
			ResultSet rs = stmt.executeQuery(command);

			if (rs.next()) {
				dto = new Food_placeDto();
				dto.setCategory(rs.getString("category"));
				dto.setSubtitle(rs.getString("subtitle"));
				dto.setTitle(rs.getString("title"));
				dto.setCityname(rs.getString("cityname"));
				dto.setContents(rs.getString("contents"));
				dto.setTel(rs.getString("tel"));
				dto.setPic(rs.getString("pic"));
				dto.setPlace(rs.getString("place"));
				dto.setTime(rs.getString("time"));
				dto.setNum(rs.getInt("num"));
				dto.setLat(rs.getString("lat"));
				dto.setLng(rs.getString("lng"));
			}

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return dto;

	}

	public ArrayList<Food_placeDto> Food_placeDto(String category, int page, int limit) {// 移댄뀒怨좊━�뿉 �빐�떦�븯�뒗 �쟾泥� 寃뚯떆湲��쓣 由ъ뒪�듃�뿉 �떞�뒗�떎

		ArrayList<Food_placeDto> fp = new ArrayList<Food_placeDto>();
		int startrow = (page - 1) * limit; // �씫湲� �떆�옉�븷 row 踰덊샇..

		try {
			conn = Drive();
			stmt = conn.createStatement();
			String command = "select * from food_place where category='" + category + "' order by num desc limit "
					+ startrow + "," + limit + ";";
			ResultSet rs = stmt.executeQuery(command);

			while (rs.next()) {
				Food_placeDto dto = new Food_placeDto();
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

		} catch (Exception e) {
		}
		close();
		return fp;

	}

	public ArrayList<Food_placeDto> Search_Food_placeDto(String category, int page, int limit, String cityname) {
		// 寃��깋�뼱媛�  �뱾�뼱�솕�쓣寃쎌슦 �빐�떦 �룄�떆�뿉 �빐�떦�븯�뒗  湲��뱾�쓣 由ъ뒪�듃�뿉�떞�뒗�떎

		ArrayList<Food_placeDto> fp = new ArrayList<Food_placeDto>();
		int startrow = (page - 1) * limit; // �씫湲� �떆�옉�븷 row 踰덊샇..

		try {
			conn = Drive();
			stmt = conn.createStatement();
			String command = "select * from food_place where category='" + category + "' and cityname like'%" + cityname
					+ "%' order by num desc limit " + startrow + "," + limit + ";";
			ResultSet rs = stmt.executeQuery(command);
			// System.out.println(command);
			while (rs.next()) {
				Food_placeDto dto = new Food_placeDto();
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

		} catch (Exception e) {
		}
		close();
		return fp;

	}

	public ArrayList<Food_placeDto> BestCity(String cityname) { // �룄�떆�꽑�깮 硫붾돱�뿉�꽌 �긽�떒�뿉 BEST 3 由ъ뒪�듃 異쒕젰

		ArrayList<Food_placeDto> Food_place = new ArrayList<Food_placeDto>();

		try {
			conn = Drive();
			stmt = conn.createStatement();
			String command = "select * from food_place where cityname='" + cityname + "' order by num desc limit 3;";
			ResultSet rs = stmt.executeQuery(command);

			while (rs.next()) {
				Food_placeDto F_P = new Food_placeDto();
				F_P.setCategory(rs.getString("category"));
				F_P.setCityname(rs.getString("cityname"));
				F_P.setContents(rs.getString("contents"));
				F_P.setNum(rs.getInt("num"));
				F_P.setPic(rs.getString("pic"));
				F_P.setPlace(rs.getString("place"));
				F_P.setTel(rs.getString("tel"));
				F_P.setTime(rs.getString("time"));
				F_P.setTitle(rs.getString("title"));
				Food_place.add(F_P);
			}

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return Food_place;
	}

	public ArrayList<Food_placeDto> foodCitylist(String cityname) { // �룄�떆�꽑�깮 硫붾돱�뿉�꽌 �빐�떦�룄�떆�뿉�꽌 留쏆쭛 由ъ뒪�듃 6媛� 蹂댁뿬二쇨린

		ArrayList<Food_placeDto> Food_place = new ArrayList<Food_placeDto>();

		try {
			conn = Drive();
			stmt = conn.createStatement();
			String command = "select * from food_place where cityname='" + cityname
					+ "' and category='留쏆쭛' order by num desc limit 6;";
			ResultSet rs = stmt.executeQuery(command);

			while (rs.next()) {
				Food_placeDto F_P = new Food_placeDto();
				F_P.setCategory(rs.getString("category"));
				F_P.setCityname(rs.getString("cityname"));
				F_P.setContents(rs.getString("contents"));
				F_P.setNum(rs.getInt("num"));
				F_P.setPic(rs.getString("pic"));
				F_P.setPlace(rs.getString("place"));
				F_P.setTel(rs.getString("tel"));
				F_P.setTime(rs.getString("time"));
				F_P.setTitle(rs.getString("title"));
				Food_place.add(F_P);
			}

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return Food_place;
	}

	public ArrayList<Food_placeDto> placeCitylist(String cityname) { // �룄�떆�꽑�깮 硫붾돱�뿉�꽌 �빐�떦�룄�떆�뿉�꽌 紐낆냼 由ъ뒪�듃 6媛� 蹂댁뿬二쇨린

		ArrayList<Food_placeDto> Food_place = new ArrayList<Food_placeDto>();

		try {
			conn = Drive();
			stmt = conn.createStatement();
			String command = "select * from food_place where cityname='" + cityname
					+ "' and category='紐낆냼' order by num desc limit 6;";
			ResultSet rs = stmt.executeQuery(command);

			while (rs.next()) {
				Food_placeDto F_P = new Food_placeDto();
				F_P.setCategory(rs.getString("category"));
				F_P.setCityname(rs.getString("cityname"));
				F_P.setContents(rs.getString("contents"));
				F_P.setNum(rs.getInt("num"));
				F_P.setPic(rs.getString("pic"));
				F_P.setPlace(rs.getString("place"));
				F_P.setTel(rs.getString("tel"));
				F_P.setTime(rs.getString("time"));
				F_P.setTitle(rs.getString("title"));
				Food_place.add(F_P);
			}

			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return Food_place;
	}

	public int ScrapList(String id) { // �뒪�겕�옪 寃뚯떆臾� 媛쒖닔瑜� 援ы븳�떎

		int listCount = 0;
		ResultSet rs = null;
		String sql = "select count(*) from scrap where id='"+id+"';";
		try {
			conn = Drive();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				listCount = rs.getInt(1);
			}
			
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return listCount;
	}

	public int ScrapCount(String id, int num,String category) { // 留쏆쭛怨� 紐낆냼  寃뚯떆湲� �긽�꽭蹂닿린�뿉�꽌 濡쒓렇�씤 id�� 寃뚯떆湲� 踰덊샇濡� �뒪�겕�옪 �쑀臾대�� �솗�씤 count蹂��닔 瑜� 由ы꽩�븳�떎
		int count = 0;
		ResultSet rs = null;
		String sql = "select * from scrap where num=" + num + " and id='"+id+"' and category='"+category+"';";
		try {
			conn = Drive();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				count = 1; //�빐�떦湲��쓣 �뒪�겕�옪�뻽�쓣�떆 count=1
			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return count;
	}

	public ArrayList<Food_placeDto> Mainlist() {
//System.out.println("a");
		ResultSet rs = null;
		ArrayList<Food_placeDto> list = new ArrayList<Food_placeDto>();
		try {
		String sql = "select num,pic,subtitle from food_place order by rand() limit 4 ;";
		conn = Drive();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		//System.out.println(stmt);
		while(rs.next()) {
			Food_placeDto dto = new Food_placeDto();
			dto.setNum(rs.getInt("num"));
			dto.setPic(rs.getString("pic"));
			dto.setSubtitle(rs.getString("subtitle"));
			list.add(dto);
			
		}
		stmt.close();
	} catch (Exception e) {
		System.out.println(e);
	}
		//System.out.println(list.size());
		return list;
	}
	
}
