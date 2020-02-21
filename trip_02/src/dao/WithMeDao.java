package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	

	public static WithMeDao getInstance(){
		if(withmeDAO == null){
			withmeDAO = new WithMeDao();
		}
		return withmeDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}

	//���� ���� ���ϱ�.
	public int selectListCount() {

		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			System.out.println("getConnection");
			pstmt=con.prepareStatement("select count(*) from withme");
			rs = pstmt.executeQuery();

			if(rs.next()){
				listCount=rs.getInt(1);
			}
		}catch(Exception ex){

		}finally{
			close(rs);
			close(pstmt);
		}

		return listCount;

	}
	
	//���� ���� ���ϱ�.
		public int selectcateListCount() {

			int listCount= 0;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try{
				System.out.println("getConnection");
				pstmt=con.prepareStatement("select count(*) from withme");
				rs = pstmt.executeQuery();

				if(rs.next()){
					listCount=rs.getInt(1);
				}
			}catch(Exception ex){

			}finally{
				close(rs);
				close(pstmt);
			}

			return listCount;

		}

	//�� ��� ����.	
	public ArrayList<WithMeBean> selectArticleList(int page,int limit){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql="select withme.*,(select sum(count) from with_user where num=withme.num) as peoplecount from withme,with_user group by withme.num order by withme.num desc limit ?,8";
		ArrayList<WithMeBean> articleList = new ArrayList<WithMeBean>();
		WithMeBean board = null;
		int startrow=(page-1)*8; //�б� ������ row ��ȣ..	

		try{
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			//System.out.println(pstmt);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			while(rs.next()){
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
				board.setLocalcontect(rs.getString("localcontect"));
				board.setContents(rs.getString("contents"));
				board.setPeoplecount(rs.getInt("peoplecount"));
				articleList.add(board);
			}
			}else {
				board_list_sql="select *,concat(0) as peoplecount from withme order by num desc";
				pstmt = con.prepareStatement(board_list_sql);
				//System.out.println("else ������="+pstmt);
				rs = pstmt.executeQuery();
				while(rs.next()){
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
					board.setLocalcontect(rs.getString("localcontect"));
					board.setContents(rs.getString("contents"));
					board.setPeoplecount(rs.getInt("peoplecount"));
					articleList.add(board);
				}
			}

		}catch(Exception ex){
		}finally{
			close(rs);
			close(pstmt);
		}
		return articleList;
	}

	//�� ���� ����.
		public WithMeBean selectArticle(int num){

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			WithMeBean board = null;

			try{
				pstmt = con.prepareStatement(
						"select withme.*,ifnull(sum(count),0) as peoplecount from withme,with_user where withme.num = ? and with_user.num=?");
				pstmt.setInt(1, num);
				pstmt.setInt(2, num);
				rs= pstmt.executeQuery();

				if(rs.next()){
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
					board.setLocalcontect(rs.getString("localcontect"));
					board.setContents(rs.getString("contents"));
					board.setPeoplecount(rs.getInt("peoplecount"));
				}
			}catch(Exception ex){
			}finally{
				close(rs);
				close(pstmt);
			}
			return board;

		}
	

	//�� ���.
	public int insertArticle(WithMeBean article){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		int insertCount=0;

		try{
			sql="insert into withme (title,date,people,lim,photo,pic1,pic2,pic3,pic4,limitdate,writer,contents,localcontect,writedate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,now())";//pic1,pic2,pic3,pic4,writedate,limitdate,writer,localcontent,contents) values(?,?,?,?,?,?,?,?,?,?,now(),?,?,?,?)";
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
			pstmt.setString(13, article.getLocalcontect());

			insertCount=pstmt.executeUpdate();
			
		}catch(Exception ex){
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	//�� ����.
		public int deleteArticle(int num){

			PreparedStatement pstmt = null;
			String board_delete_sql="delete from withme where num=?";
			int deleteCount=0;

			try{
				pstmt=con.prepareStatement(board_delete_sql);
				pstmt.setInt(1, num);
				deleteCount=pstmt.executeUpdate();
			}catch(Exception ex){
			}	finally{
				close(pstmt);
			}

			return deleteCount;
			
		}
		
		//��û�ο� ������Ʈ
		public int peopleCount(With_UserBean user) {
			int insertCount = 0;
			PreparedStatement pstmt = null;
			String sql="insert into with_user values(?,?,?,?)";
			
			try{
				pstmt = con.prepareStatement(sql);
			    pstmt.setString(1, user.getId());
			    pstmt.setInt(2, user.getNum());
			    pstmt.setString(3, user.getTel());
			    pstmt.setInt(4, user.getCount());
			    
			    System.out.println("Query="+pstmt);
				
				insertCount=pstmt.executeUpdate();
				
			}catch(Exception ex){
			}finally{
				close(pstmt);
			}

			return insertCount;

		}

		//�� ����.
		public int updateArticle(WithMeBean article){

			int updateCount = 0;
			PreparedStatement pstmt = null;
			String sql="update withme set title=?,date=?,people=?,lim=?,photo=?,pic1=?,pic2=?,pic3=?,pic4=?,limitdate=?,localcontect=?,contents=? where num=?";

			try{
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
				pstmt.setString(11, article.getLocalcontect());
				pstmt.setString(12, article.getContents());
				pstmt.setInt(13, article.getNum());
				//System.out.println(pstmt);
				updateCount = pstmt.executeUpdate();
			}catch(Exception ex){
				
			}finally{
				close(pstmt);
			}

			return updateCount;

		}
		
		//�Բ��ؿ� ��û���
		public int countDel(With_UserBean user){

			PreparedStatement pstmt = null;
			String board_delete_sql="delete from with_user where num=? and id=?";
			int deleteCount=0;

			try{
				pstmt=con.prepareStatement(board_delete_sql);
				pstmt.setInt(1, user.getNum());
				pstmt.setString(2, user.getId());
				System.out.println(pstmt);
				deleteCount=pstmt.executeUpdate();
			}catch(Exception ex){
			}	finally{
				close(pstmt);
			}

			return deleteCount;
			
		}
		
		public int cinchugcheck(int num,String id) {//�ش�Խñ��� ���� �װԽù��� ���� ������ ��û�� �߾����� ���ߴ��� üũ
			PreparedStatement pstmt = null;
			String sql="select id from with_user where num=? and id=?";
			int check=0;
			ResultSet rs=null;
			try{
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setString(2, id);	
			    rs=pstmt.executeQuery();
					
				if(rs.next()) {
					check=1;
				}
          
		}catch(Exception ex){
			
		}finally{
			close(pstmt);
		}

		return check;
	}
		public ArrayList<With_UserBean> cinchugList(int boardnum) {//�ش�Խñ� ��û�ο� ����
			PreparedStatement pstmt = null;
			String sql="select * from with_user where num=?";
			ResultSet rs=null;
			ArrayList<With_UserBean> articleList = new ArrayList<With_UserBean>();
			try{
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, boardnum);
			    rs=pstmt.executeQuery();
					
				if(rs.next()) {
					With_UserBean list = new With_UserBean();
					list.setId(rs.getString("id"));
					list.setTel(rs.getString("tel"));
					list.setCount(rs.getInt("count"));
					articleList.add(list);
				}
          
		}catch(Exception ex){
			
		}finally{
			close(pstmt);
		}

		return articleList;
	}

}


	

