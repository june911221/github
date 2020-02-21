package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.ScrapDao;
import vo.ScrapDto;

public class ScrapService {
	
	   public void Scrap(ScrapDto scrap) throws Exception{
		// TODO Auto-generated method stub
		   
				Connection con = getConnection();
				ScrapDao DAO = ScrapDao.getInstance();
				DAO.setConnection(con);
				DAO.Scrap(scrap);
				close(con);				
			}
}

