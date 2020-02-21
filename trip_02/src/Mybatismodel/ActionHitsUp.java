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
	//mapper.xml 에서 hitsupdate 를 id로사용하는 update 구문에 변수를 보내주면서 호출("id",변수)
	
	sqlSession.commit();
	sqlSession.close();
	}
}
