package Mybatismodel;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.Map;
import vo.BoardDto;

public class ActionDelete {
	static ActionDelete model = new ActionDelete();
	public static ActionDelete instance(){
		return model;
	}


	private SqlSessionFactory factory = Map.getSqlSession();
	
	public void Delete(BoardDto list) {
	
	SqlSession sqlSession = factory.openSession();
	sqlSession.delete("deleteDB",list);
	//mapper.xml ���� deleteDB �� id�λ���ϴ� delete ������ ������ �����ָ鼭 ȣ��("id",����)
	
	sqlSession.commit();
	sqlSession.close();
	}
}
