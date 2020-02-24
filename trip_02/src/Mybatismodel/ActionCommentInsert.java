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
		System.out.print("b");
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("commentInsert",comment);
		//mapper.xml ���� commentInsert�� id�� ����ϴ� insert ������ ������ �����ָ鼭 ȣ��("id",����)
		
		sqlSession.commit();
		sqlSession.close();
	}
}
