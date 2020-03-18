package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.WithMeDao;
import vo.WithMeBean;
import vo.With_UserBean;

public class With_UserCountListService {

	public ArrayList<With_UserBean> countList(int num) throws Exception {

		ArrayList<With_UserBean> articleList = null;

		Connection con = getConnection();
		WithMeDao withmeDAO = WithMeDao.getInstance();
		withmeDAO.setConnection(con);
		articleList = withmeDAO.cinchugList(num);
		close(con);

		return articleList;

	}
}
