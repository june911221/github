package Mybatismodel;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.Map;
import vo.BoardDto;

public class ActionList {
	static ActionList model = new ActionList();

	public static ActionList instance() {
		return model;
	}

	private SqlSessionFactory factory = Map.getSqlSession();

	public int boardlistcount(BoardDto li) {
		SqlSession sqlSession = factory.openSession();
		int listcount = 0;

		listcount = sqlSession.selectOne("boardListcount", li);
		// mapper.xml 에서 boardListcount 를 id로사용하는 select 구문에 변수를 보내주면서 호출("id",변수)
		// listcount변수에 게시글의 수를 담아준다

		sqlSession.close();
		return listcount;
	}

	public List<BoardDto> boardlist(BoardDto li, int page, int limit) {
		List<BoardDto> list = null;// List<BoardDto> 객체 생성후 null로 초기화 시켜준다

		int startrow = (page - 1) * limit; // 읽기 시작할 row 번호..
		li.setPagerow(startrow);// BoardDto 에 읽기시작할 row번호값을 셋팅

		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("boardList", li);
		// mapper.xml 에서 boardList 를 id로사용하는 select 구문에 변수를 보내주면서 호출("id",변수) list변수에
		// select값들을 담아준다

		sqlSession.close();
		return list;
	}
}
