package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.WithMeDao;
import vo.WithMeBean;
import vo.With_UserBean;

public class WithMePeopleCountService {

	public boolean peoplecount(With_UserBean user) throws Exception {

		boolean isWriteSuccess = false;
		Connection con = getConnection();
		WithMeDao withmeDAO = WithMeDao.getInstance();
		withmeDAO.setConnection(con);

		int insertCount = withmeDAO.peopleCount(user);

		if (insertCount > 0) {
			commit(con);
			isWriteSuccess = true;
		} else {
			rollback(con);
		}

		close(con);
		return isWriteSuccess;

	}

}
