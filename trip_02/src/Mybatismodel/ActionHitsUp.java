package Mybatismodel;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.Map;
import vo.BoardDto;

public class ActionHitsUp {
	static ActionHitsUp model = new ActionHitsUp();
	public static ActionHitsUp instance(){
		return model;
	}
private SqlSessionFactory factory = Map.getSqlSession();
	
	public void HitsUp(BoardDto list) {
	
	SqlSession sqlSession = factory.openSession();
	sqlSession.update("hitsupdate",list);
	//mapper.xml ���� hitsupdate �� id�λ���ϴ� update ������ ������ �����ָ鼭 ȣ��("id",����)
	
	sqlSession.commit();
	sqlSession.close();
	}
}
