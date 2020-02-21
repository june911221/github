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


	private SqlSessionFactory factory = Map.getSqlSession(); //Map.java ?뙆?씪?쓣 李얠븘?샂

	public List<CommentDto> commentlist(int boardnum){
		
		List<CommentDto> list = null;//List<CommentDto> 객체 생성후   null값으로 초기화
		CommentDto li=new CommentDto();//CommentDto 객체생성
		li.setB_number(boardnum);//CommentDto 에 게시글 번호 셋팅
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("CommentList",li);
		//mapper.xml 에서 CommentList를 id로 사용하는 select 구문에 변수를 보내주면서 호출("id",변수) list 변수에 값을담아준다
		
		sqlSession.close();
		return list;
	}
}
