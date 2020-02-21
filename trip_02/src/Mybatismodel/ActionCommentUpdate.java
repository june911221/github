package Mybatismodel;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.Map;
import vo.CommentDto;

public class ActionCommentUpdate {
	static ActionCommentUpdate model = new ActionCommentUpdate();
	public static ActionCommentUpdate instance(){
		return model;
	}

	private SqlSessionFactory factory = Map.getSqlSession();
	
	public void commentUpdate(CommentDto list) {
	
	SqlSession sqlSession = factory.openSession();
	sqlSession.update("commentupdateDB",list);
	//mapper.xml 에서 commentupdateDB를 id로 사용하는 update 구문에 변수를 보내주면서 호출("id",변수)
	
	sqlSession.commit();
	sqlSession.close();
	
	}
}
