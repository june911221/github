package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ScrapDao;
import vo.Food_placeDto;
import vo.ScrapDto;
import vo.ThemaDto;

public class ScrapPageService {
	
	public ArrayList<Food_placeDto> Scrapfood(ScrapDto scrap) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Food_placeDto> food=null;
		Connection con = getConnection();
		ScrapDao DAO = ScrapDao.getInstance();
		DAO.setConnection(con);
		food = DAO.Scrapfood(scrap);
		close(con);
		return food;
	}
	
	public ArrayList<Food_placeDto> Scrapplace(ScrapDto scrap) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Food_placeDto> place=null;
		Connection con = getConnection();
		ScrapDao DAO = ScrapDao.getInstance();
		DAO.setConnection(con);
		place = DAO.Scrapplace(scrap);
		close(con);
		return place;
	}
	
	public ArrayList<ThemaDto> Scrapthema(ScrapDto scrap) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<ThemaDto> thema=null;
		Connection con = getConnection();
		ScrapDao DAO = ScrapDao.getInstance();
		DAO.setConnection(con);
		thema = DAO.ScrapThemalist(scrap);
		close(con);
		return thema;
	}

}
