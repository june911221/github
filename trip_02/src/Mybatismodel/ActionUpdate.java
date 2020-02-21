package Mybatismodel;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.Map;
import vo.BoardDto;

public class ActionUpdate {
	static ActionUpdate model = new ActionUpdate();
	public static ActionUpdate instance(){
		return model;
	}


	private SqlSessionFactory factory = Map.getSqlSession(); //Map.java �뙆�씪�쓣 李얠븘�?��
	
	public void Update(BoardDto list) {
	
	SqlSession sqlSession = factory.openSession();
	sqlSession.update("updateDB",list);
	//mapper.xml ���� updateDB �� id�λ���ϴ� update ������ ������ �����ָ鼭 ȣ��("id",����) 
	
	sqlSession.commit();
	sqlSession.close();
	
	}
}
