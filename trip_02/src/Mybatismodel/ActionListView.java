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


	private SqlSessionFactory factory = Map.getSqlSession(); //Map.java ?뙆?씪?쓣 李얠븘?샂

	public List<BoardDto> boardlist(BoardDto li){
		List<BoardDto> list = null;//List<BoardDto> 객체 생성후 null로 초기화 시켜준다
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("boardView",li);
		//mapper.xml 에서 boardView 를 id로사용하는 select 구문에 변수를 보내주면서 호출("id",변수) list변수에 select값들을 담아준다
		
		sqlSession.close();
		return list;
	}
}
