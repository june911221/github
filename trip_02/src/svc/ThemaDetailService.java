package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.ThemaDao;
import vo.ThemaDto;

public class ThemaDetailService {
	
	public ThemaDto getArticle(int num) throws Exception{
		// TODO Auto-generated method stub
		
		ThemaDto article = null;
		Connection con = getConnection();
		ThemaDao DAO = ThemaDao.getInstance();
		DAO.setConnection(con);
	
		article = DAO.selectArticle(num);
		close(con);
		return article;
		
	}
}
