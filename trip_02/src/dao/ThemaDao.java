package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.ThemaDto;

public class ThemaDao {
	DataSource ds;
	Connection con;
	private static ThemaDao ThemaDAO;

	private ThemaDao() {
		// TODO Auto-generated constructor stub
	}
	

	public static ThemaDao getInstance(){
		if(ThemaDAO == null){
			ThemaDAO = new ThemaDao();
		}
		return ThemaDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	
	//ī���� ���� ���ϱ�.
	public int selectListCount() {

		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			//System.out.println("getConnection");
			pstmt=con.prepareStatement("select count(*) from thema");
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

	//ī�װ��� ���� ���� ���ϱ�.
	public int selectcategoryListCount(String category) {

		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			//System.out.println("getConnection");
			pstmt=con.prepareStatement("select count(*) from thema where category=?");
			pstmt.setString(1, category);
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
	public ArrayList<ThemaDto> selectArticleList(int page,int limit){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql="select * from thema order by num desc limit ?,?";
		ArrayList<ThemaDto> articleList = new ArrayList<ThemaDto>();
		ThemaDto thema = null;
		int startrow=(page-1)*limit; //�б� ������ row ��ȣ..	

		try{
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);
			//System.out.println(pstmt);
			rs = pstmt.executeQuery();		
			
			while(rs.next()){
				thema = new ThemaDto();
				thema.setNum(rs.getInt("num"));
				thema.setTitle(rs.getString("title"));
				thema.setCategory(rs.getString("category"));
				thema.setContents(rs.getString("contents"));
				thema.setPic(rs.getString("pic"));
				articleList.add(thema);
			}
			
		}catch(Exception ex){
		}finally{
			close(rs);
			close(pstmt);
		}
		return articleList;
	}
	
	//ī�װ��� �� ��� ����.	
		public ArrayList<ThemaDto> selectcategoryArticleList(int page,int limit,String category){

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String board_list_sql="select * from thema where category=? order by num desc limit ?,?";
			ArrayList<ThemaDto> articleList = new ArrayList<ThemaDto>();
			ThemaDto thema = null;
			int startrow=(page-1)*limit; //�б� ������ row ��ȣ..	

			try{
				pstmt = con.prepareStatement(board_list_sql);
				pstmt.setString(1, category);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, limit);
				//System.out.println(pstmt);
				rs = pstmt.executeQuery();		
				
				while(rs.next()){
					thema = new ThemaDto();
					thema.setNum(rs.getInt("num"));
					thema.setTitle(rs.getString("title"));
					thema.setCategory(rs.getString("category"));
					thema.setContents(rs.getString("contents"));
					thema.setPic(rs.getString("pic"));
					articleList.add(thema);
				}
				
			}catch(Exception ex){
			}finally{
				close(rs);
				close(pstmt);
			}
			return articleList;
		}
		
	
	//�� ���� ����.
			public ThemaDto selectArticle(int num){

				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ThemaDto Thema = null;

				try{
					pstmt = con.prepareStatement(
							"select * from thema where num=?");
					pstmt.setInt(1, num);
					rs= pstmt.executeQuery();

					if(rs.next()){
						Thema = new ThemaDto();
						Thema.setNum(rs.getInt("num"));
						Thema.setTitle(rs.getString("title"));
						Thema.setPic(rs.getString("pic"));
						Thema.setContents(rs.getString("contents"));
						Thema.setCategory(rs.getString("category"));
					}
				}catch(Exception ex){
				}finally{
					close(rs);
					close(pstmt);
				}
				return Thema;

			}
			
		
}
