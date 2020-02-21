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
	//mapper.xml ���� commentupdateDB�� id�� ����ϴ� update ������ ������ �����ָ鼭 ȣ��("id",����)
	
	sqlSession.commit();
	sqlSession.close();
	
	}
}
