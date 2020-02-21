package Mybatismodel;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.Map;
import vo.CommentDto;

public class ActionCommentInsert {
	static ActionCommentInsert model = new ActionCommentInsert();
	public static ActionCommentInsert instance(){
		return model;
	}
	
	private SqlSessionFactory factory = Map.getSqlSession();
	public void commentInsert(CommentDto comment){
		
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("commentInsert",comment);
		//mapper.xml 에서 commentInsert를 id로 사용하는 insert 구문에 변수를 보내주면서 호출("id",변수)
		
		sqlSession.commit();
		sqlSession.close();
	}
}
