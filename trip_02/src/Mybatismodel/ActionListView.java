package Mybatismodel;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.Map;
import vo.BoardDto;

public class ActionListView {
	static ActionListView model = new ActionListView();
	public static ActionListView instance(){
		return model;
	}


	private SqlSessionFactory factory = Map.getSqlSession(); //Map.java ?��?��?�� 찾아?��

	public List<BoardDto> boardlist(BoardDto li){
		List<BoardDto> list = null;//List<BoardDto> ��ü ������ null�� �ʱ�ȭ �����ش�
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("boardView",li);
		//mapper.xml ���� boardView �� id�λ���ϴ� select ������ ������ �����ָ鼭 ȣ��("id",����) list������ select������ ����ش�
		
		sqlSession.close();
		return list;
	}
}
