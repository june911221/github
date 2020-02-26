package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.WithMeDao;
import vo.With_UserBean;

public class With_UserCountDelService {

	public void usercountDel(With_UserBean user) throws Exception{
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		WithMeDao withmeDAO = WithMeDao.getInstance();
		withmeDAO.setConnection(con);
		int deleteCount = withmeDAO.countDel(user);
		
		if(deleteCount > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		close(con);
	}
}
