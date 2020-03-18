package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.ScrapDao;
import vo.ScrapDto;

public class ScrapdeleteService {

	public int Scrapdel(ScrapDto scrap) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ScrapDao DAO = ScrapDao.getInstance();
		DAO.setConnection(con);
		int insertcount = DAO.ScrapDel(scrap);
		close(con);
		return insertcount;
	}
}