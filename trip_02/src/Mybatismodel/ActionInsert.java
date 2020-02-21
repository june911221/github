package Mybatismodel;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.Map;
import vo.BoardDto;

public class ActionInsert {
	static ActionInsert model = new ActionInsert();
	public static ActionInsert instance(){
		return model;
	}


	private SqlSessionFactory factory = Map.getSqlSession(); //Map.java �뙆�씪�쓣 李얠븘�?��

	public void boardInsert(BoardDto list) {
				
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("insertDB",list);
		//mapper.xml ���� insertDB �� id�λ���ϴ� insert ������ ������ �����ָ鼭 ȣ��("id",����)
		
		sqlSession.commit();
		sqlSession.close();
	}
}
