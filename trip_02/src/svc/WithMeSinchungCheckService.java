package svc;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.WithMeDao;

public class WithMeSinchungCheckService {

	public int sinchungCheck(int boardnum, String id) throws Exception {
		// TODO Auto-generated method stub

		Connection con = getConnection();
		WithMeDao withmeDAO = WithMeDao.getInstance();// WithMeDao 객체 생성
		int check = 0; // 변수 check 생성
		withmeDAO.setConnection(con);// withmDAO에 커넥션을 set해준다
		check = withmeDAO.cinchugcheck(boardnum, id);// 신청자 체크를 통해 값을 리턴 받는다

		return check;
	}

}
