package svc;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.WithMeDao;

public class WithMeSinchungCheckService {
	
	public int sinchungCheck(int boardnum,String id) throws Exception{
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		WithMeDao withmeDAO = WithMeDao.getInstance();//WithMeDao ��ü ����
		int check=0; //���� check ����		
		withmeDAO.setConnection(con);//withmDAO�� Ŀ�ؼ��� set���ش�
		check=withmeDAO.cinchugcheck(boardnum, id);//��û�� üũ�� ���� ���� ���� �޴´�
		
		return check;
	}

}
