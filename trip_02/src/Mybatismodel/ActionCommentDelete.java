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
	//mapper.xml ���� deleteDB�� id�� ����ϴ� delete ������ ������ �����ָ鼭 ȣ��("id",����)
	
	sqlSession.commit();
	sqlSession.close();
	}
}
