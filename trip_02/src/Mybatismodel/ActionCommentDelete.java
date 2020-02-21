package Mybatismodel;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.Map;
import vo.CommentDto;

public class ActionCommentDelete {
	static ActionCommentDelete model = new ActionCommentDelete();
	public static ActionCommentDelete instance(){
		return model;
	}

	private SqlSessionFactory factory = Map.getSqlSession();
	
	public void commentDelete(CommentDto list) {	
	
	SqlSession sqlSession = factory.openSession();
	sqlSession.delete("commentdeleteDB",list);
	//mapper.xml 에서 deleteDB를 id로 사용하는 delete 구문에 변수를 보내주면서 호출("id",변수)
	
	sqlSession.commit();
	sqlSession.close();
	}
}
