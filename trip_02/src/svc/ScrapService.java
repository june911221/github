package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.ScrapDao;
import vo.ScrapDto;

public class ScrapService {

	public int Scrapfoodplace(ScrapDto scrap) throws Exception {
		// TODO Auto-generated method stub

		Connection con = getConnection();
		ScrapDao DAO = ScrapDao.getInstance();
		DAO.setConnection(con);
		int insertcount = DAO.Scrapfoodplace(scrap);
		close(con);
		return insertcount;
	}
	
	public int Scrapthema(ScrapDto scrap) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ScrapDao DAO = ScrapDao.getInstance();
		DAO.setConnection(con);
		int insertcount = DAO.Scrapthema(scrap);
		close(con);
		return insertcount;
	}
}
