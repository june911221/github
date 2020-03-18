package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.AirDao;
import vo.AirDto;

public class FlightListAction {
	
	public ArrayList<AirDto> Airlist(AirDto list) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SVC");
		Connection con = getConnection();
		AirDao DAO = AirDao.getInstance();
		DAO.setConnection(con);
		ArrayList<AirDto> airlist = DAO.airlist(list);
		close(con);
		return airlist;
	}
}
