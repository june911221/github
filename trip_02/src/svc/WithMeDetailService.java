package svc;

import java.sql.Connection;

import dao.WithMeDao;
import vo.WithMeBean;

import static db.JdbcUtil.*;

public class WithMeDetailService {

	public WithMeBean getArticle(int num) throws Exception {
		// TODO Auto-generated method stub

		WithMeBean article = null;
		Connection con = getConnection();
		WithMeDao withmeDAO = WithMeDao.getInstance();
		withmeDAO.setConnection(con);

		article = withmeDAO.selectArticle(num);
		close(con);
		return article;

	}

}
