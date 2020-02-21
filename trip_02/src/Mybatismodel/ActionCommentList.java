package Mybatismodel;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.Map;
import vo.CommentDto;

public class ActionCommentList {
	static ActionCommentList model = new ActionCommentList();
	public static ActionCommentList instance(){
		return model;
	}


	private SqlSessionFactory factory = Map.getSqlSession(); //Map.java ?��?��?�� 찾아?��

	public List<CommentDto> commentlist(int boardnum){
		
		List<CommentDto> list = null;//List<CommentDto> ��ü ������   null������ �ʱ�ȭ
		CommentDto li=new CommentDto();//CommentDto ��ü����
		li.setB_number(boardnum);//CommentDto �� �Խñ� ��ȣ ����
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("CommentList",li);
		//mapper.xml ���� CommentList�� id�� ����ϴ� select ������ ������ �����ָ鼭 ȣ��("id",����) list ������ ��������ش�
		
		sqlSession.close();
		return list;
	}
}
