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


	private SqlSessionFactory factory = Map.getSqlSession(); //Map.java ?뙆?씪?쓣 李얠븘?샂

	public List<CommentDto> commentModify(CommentDto li){
		
		List<CommentDto> list = null;//List<CommentDto> 객체 생성후   null값으로 초기화
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("commentModify",li);
		//mapper.xml 에서 commentModify를 id로 사용하는 select 구문에 변수를 보내주면서 호출("id",변수) list 변수에 값을담아준다
		
		sqlSession.close();
		return list;
	}
}
