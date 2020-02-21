package Mybatismodel;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.Map;
import vo.CommentDto;

public class ActionCommentModify {
	static ActionCommentModify model = new ActionCommentModify();
	public static ActionCommentModify instance(){
		return model;
	}


	private SqlSessionFactory factory = Map.getSqlSession(); //Map.java ?��?��?�� 찾아?��

	public List<CommentDto> commentModify(CommentDto li){
		
		List<CommentDto> list = null;//List<CommentDto> ��ü ������   null������ �ʱ�ȭ
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("commentModify",li);
		//mapper.xml ���� commentModify�� id�� ����ϴ� select ������ ������ �����ָ鼭 ȣ��("id",����) list ������ ��������ش�
		
		sqlSession.close();
		return list;
	}
}
