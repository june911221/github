package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;

import vo.WithMeBean;
import vo.With_UserBean;

public class WithMeDao {
	DataSource ds;
	Connection con;
	private static WithMeDao withmeDAO;

	private WithMeDao() {
		// TODO Auto-generated constructor stub
	}

	public static WithMeDao getInstance() {
		if (withmeDAO == null) {
			withmeDAO = new WithMeDao();
		}
		return withmeDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	// 글의 개수 구하기.
	public int selectListCount() {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("select count(*) from withme");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception ex) {

		} finally {
			close(rs);
			close(pstmt);
		}

		return listCount;

	}

	// 글의 개수 구하기.
	public int selectcateListCount() {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// System.out.println("getConnection");
			pstmt = con.prepareStatement("select count(*) from withme");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception ex) {

		} finally {
			close(rs);
			close(pstmt);
		}

		return listCount;

	}

	// 글 목록 보기.
	public ArrayList<WithMeBean> selectArticleList(int page, int limit) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql = "select withme.*,(select sum(count) from with_user where num=withme.num) as peoplecount from withme,with_user group by withme.num order by withme.num desc limit ?,8";
		ArrayList<WithMeBean> articleList = new ArrayList<WithMeBean>();
		WithMeBean board = null;
		int startrow = (page - 1) * 8; // 읽기 시작할 row 번호..

		try {
			pstmt = con.prepareStatement("select count(*) from with_user");// 함께해요 신청자 테이블 데이터 개수를 확인
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);// 데이터 개수를 listCount 변수에 담아둔다
			}

			if (listCount == 0) { // 신청자 데이터가 없을시 쿼리문
				board_list_sql = "select *,concat(0) as peoplecount from withme group by num order by withme.num desc limit ?,8";
				pstmt = con.prepareStatement(board_list_sql);
				pstmt.setInt(1, startrow);
				// System.out.println(pstmt);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					board = new WithMeBean();
					board.setNum(rs.getInt("num"));
					board.setTitle(rs.getString("title"));
					board.setDate(rs.getDate("date"));
					board.setPeople(rs.getInt("people"));
					board.setLim(rs.getString("lim"));
					board.setPhoto(rs.getString("photo"));
					board.setPic1(rs.getString("pic1"));
					board.setPic2(rs.getString("pic2"));
					board.setPic3(rs.getString("pic3"));
					board.setPic4(rs.getString("pic4"));
					board.setWritedate(rs.getDate("writedate"));
					board.setLimitdate(rs.getDate("limitdate"));
					board.setWriter(rs.getString("writer"));
					board.setLocalcontenct(rs.getString("localcontenct"));
					board.setContents(rs.getString("contents"));
					board.setPeoplecount(rs.getInt("peoplecount"));
					articleList.add(board);
				}
			} else {// 데이터가 있을시 쿼리
				pstmt = con.prepareStatement(board_list_sql);
				pstmt.setInt(1, startrow);
				// System.out.println(pstmt);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					board = new WithMeBean();
					board.setNum(rs.getInt("num"));
					board.setTitle(rs.getString("title"));
					board.setDate(rs.getDate("date"));
					board.setPeople(rs.getInt("people"));
					board.setLim(rs.getString("lim"));
					board.setPhoto(rs.getString("photo"));
					board.setPic1(rs.getString("pic1"));
					board.setPic2(rs.getString("pic2"));
					board.setPic3(rs.getString("pic3"));
					board.setPic4(rs.getString("pic4"));
					board.setWritedate(rs.getDate("writedate"));
					board.setLimitdate(rs.getDate("limitdate"));
					board.setWriter(rs.getString("writer"));
					board.setLocalcontenct(rs.getString("localcontenct"));
					board.setContents(rs.getString("contents"));
					board.setPeoplecount(rs.getInt("peoplecount"));
					articleList.add(board);
				}
			}

		} catch (Exception ex) {
		} finally {
			close(rs);
			close(pstmt);
		}
		return articleList;
	}

	// 글 내용 보기.
	public WithMeBean selectArticle(int num) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		WithMeBean board = null;

		try {
			pstmt = con.prepareStatement(
					"select withme.*,ifnull(sum(count),0) as peoplecount from withme,with_user where withme.num = ? and with_user.num=?");
			pstmt.setInt(1, num);
			pstmt.setInt(2, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new WithMeBean();
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setDate(rs.getDate("date"));
				board.setPeople(rs.getInt("people"));
				board.setLim(rs.getString("lim"));
				board.setPhoto(rs.getString("photo"));
				board.setPic1(rs.getString("pic1"));
				board.setPic2(rs.getString("pic2"));
				board.setPic3(rs.getString("pic3"));
				board.setPic4(rs.getString("pic4"));
				board.setWritedate(rs.getDate("writedate"));
				board.setLimitdate(rs.getDate("limitdate"));
				board.setWriter(rs.getString("writer"));
				board.setLocalcontenct(rs.getString("localcontenct"));
				board.setContents(rs.getString("contents"));
				board.setPeoplecount(rs.getInt("peoplecount"));
			}
		} catch (Exception ex) {
		} finally {
			close(rs);
			close(pstmt);
		}
		return board;

	}

	// 글 등록.
	public int insertArticle(WithMeBean article) {
		PreparedStatement pstmt = null;
		String sql = "insert into withme (title,date,people,lim,photo,pic1,pic2,pic3,pic4,limitdate,writer,contents,localcontenct,writedate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,now())";
		int insertCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setDate(2, article.getDate());
			pstmt.setInt(3, article.getPeople());
			pstmt.setString(4, article.getLim());
			pstmt.setString(5, article.getPhoto());
			pstmt.setString(6, article.getPic1());
			pstmt.setString(7, article.getPic2());
			pstmt.setString(8, article.getPic3());
			pstmt.setString(9, article.getPic4());
			pstmt.setDate(10, article.getLimitdate());
			pstmt.setString(11, article.getWriter());
			pstmt.setString(12, article.getContents());
			pstmt.setString(13, article.getLocalcontenct());

			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
		} finally {
			close(pstmt);
		}

		return insertCount;

	}

	// 글 삭제.
	public int deleteArticle(int num) {

		PreparedStatement pstmt = null;
		String board_delete_sql = "delete from withme where num=?";
		int deleteCount = 0;

		try {
			pstmt = con.prepareStatement(board_delete_sql);
			pstmt.setInt(1, num);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception ex) {
		} finally {
			close(pstmt);
		}

		return deleteCount;

	}

	// 신청인원 업데이트
	public int peopleCount(With_UserBean user) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into with_user values(?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setInt(2, user.getNum());
			pstmt.setString(3, user.getTel());
			pstmt.setInt(4, user.getCount());

			// System.out.println("Query="+pstmt);

			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
		} finally {
			close(pstmt);
		}

		return insertCount;

	}

	// 글 수정.
	public int updateArticle(WithMeBean article) {

		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update withme set title=?,date=?,people=?,lim=?,photo=?,pic1=?,pic2=?,pic3=?,pic4=?,limitdate=?,localcontenct=?,contents=? where num=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setDate(2, article.getDate());
			pstmt.setInt(3, article.getPeople());
			pstmt.setString(4, article.getLim());
			pstmt.setString(5, article.getPhoto());
			pstmt.setString(6, article.getPic1());
			pstmt.setString(7, article.getPic2());
			pstmt.setString(8, article.getPic3());
			pstmt.setString(9, article.getPic4());
			pstmt.setDate(10, article.getLimitdate());
			pstmt.setString(11, article.getLocalcontenct());
			pstmt.setString(12, article.getContents());
			pstmt.setInt(13, article.getNum());
			// System.out.println(pstmt);
			updateCount = pstmt.executeUpdate();
		} catch (Exception ex) {

		} finally {
			close(pstmt);
		}

		return updateCount;

	}

	// 함께해요 신청취소
	public int countDel(With_UserBean user) {

		PreparedStatement pstmt = null;
		String board_delete_sql = "delete from with_user where num=? and id=?";
		int deleteCount = 0;

		try {
			pstmt = con.prepareStatement(board_delete_sql);
			pstmt.setInt(1, user.getNum());
			pstmt.setString(2, user.getId());
			// System.out.println(pstmt);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception ex) {
		} finally {
			close(pstmt);
		}

		return deleteCount;

	}

	public int cinchugcheck(int num, String id) {// 해당게시글을 볼때 그게시물을 보는 유저가 신청을 했었는지 안했는지 체크
		PreparedStatement pstmt = null;
		String sql = "select id from with_user where num=? and id=?";
		int check = 0;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				check = 1;
			}

		} catch (Exception ex) {

		} finally {
			close(pstmt);
		}

		return check;
	}

	public ArrayList<With_UserBean> cinchugList(int boardnum) {// 해당게시글 신청인원 보기
		PreparedStatement pstmt = null;
		String sql = "select * from with_user where num=?";
		ResultSet rs = null;
		ArrayList<With_UserBean> articleList = new ArrayList<With_UserBean>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardnum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				With_UserBean list = new With_UserBean();
				list.setId(rs.getString("id"));
				list.setTel(rs.getString("tel"));
				list.setCount(rs.getInt("count"));
				articleList.add(list);
			}

		} catch (Exception ex) {

		} finally {
			close(pstmt);
		}

		return articleList;
	}

}
