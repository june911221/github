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
	//mapper.xml 에서 deleteDB 를 id로사용하는 delete 구문에 변수를 보내주면서 호출("id",변수)
	
	sqlSession.commit();
	sqlSession.close();
	}
}
