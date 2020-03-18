package Mybatismodel;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.Map;
import vo.BoardDto;

public class ActionSearch {
	static ActionSearch model = new ActionSearch();

	public static ActionSearch instance() {
		return model;
	}

	private SqlSessionFactory factory = Map.getSqlSession();

	public int boardlistcountnone(BoardDto li) {// 검색옵션 전체 글의개수
		int listcount = 0;
		SqlSession sqlSession = factory.openSession();
		listcount = sqlSession.selectOne("countnone", li);
		// mapper.xml 에서 searchnone 를 id로사용하는 select 구문에 변수를 보내주면서 호출("id",변수) 변수에
		// select값들을 담아준다

		sqlSession.close();
		return listcount;
	}

	public List<BoardDto> boardlistnone(BoardDto li) {// 검색옵션 전체
		List<BoardDto> list = null;// List<BoardDto> 객체 생성후 null로 초기화 시켜준다
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("searchnone", li);
		// mapper.xml 에서 searchnone 를 id로사용하는 select 구문에 변수를 보내주면서 호출("id",변수) list변수에
		// select값들을 담아준다

		sqlSession.close();
		return list;
	}

	public int boardlistcounttitle(BoardDto li) {// 검색옵션 제목의 글의개수
		int listcount = 0;
		SqlSession sqlSession = factory.openSession();
		listcount = sqlSession.selectOne("counttitle", li);
		// mapper.xml 에서 searchnone 를 id로사용하는 select 구문에 변수를 보내주면서 호출("id",변수) list변수에
		// select값들을 담아준다

		sqlSession.close();
		return listcount;
	}

	public List<BoardDto> boardlisttitle(BoardDto li) {// 검색옵션 제목
		List<BoardDto> list = null;// List<BoardDto> 객체 생성후 null로 초기화 시켜준다
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("search_title", li);
		// mapper.xml 에서 search_title 를 id로사용하는 select 구문에 변수를 보내주면서 호출("id",변수) list변수에
		// select값들을 담아준다

		sqlSession.close();
		return list;
	}

	public int boardlistcounttitle_contents(BoardDto li) {// 검색옵션 제목+내용 글의개수
		int listcount = 0;
		SqlSession sqlSession = factory.openSession();
		listcount = sqlSession.selectOne("counttitle_contents", li);
		// mapper.xml 에서 searchnone 를 id로사용하는 select 구문에 변수를 보내주면서 호출("id",변수) list변수에
		// select값들을 담아준다

		sqlSession.close();
		return listcount;
	}

	public List<BoardDto> boardlisttitle_contents(BoardDto li) {// 검색옵션 제목+내용
		List<BoardDto> list = null;// List<BoardDto> 객체 생성후 null로 초기화 시켜준다
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("searchtitle_contents", li);
		// mapper.xml 에서 searchtitle_contents 를 id로사용하는 select 구문에 변수를 보내주면서 호출("id",변수)
		// list변수에 select값들을 담아준다

		sqlSession.close();
		return list;
	}

	public int boardlistcountcontents(BoardDto li) {// 검색옵션 내용 글의개수
		int listcount = 0;
		SqlSession sqlSession = factory.openSession();
		listcount = sqlSession.selectOne("countcontents", li);
		// mapper.xml 에서 searchnone 를 id로사용하는 select 구문에 변수를 보내주면서 호출("id",변수) list변수에
		// select값들을 담아준다

		sqlSession.close();
		return listcount;
	}

	public List<BoardDto> boardlistcontents(BoardDto li) {// 검색옵션 내용
		List<BoardDto> list = null;// List<BoardDto> 객체 생성후 null로 초기화 시켜준다
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("searchcontents", li);
		// mapper.xml 에서 searchcontents 를 id로사용하는 select 구문에 변수를 보내주면서 호출("id",변수)
		// list변수에 select값들을 담아준다

		sqlSession.close();
		return list;
	}

	public int boardlistcountwriter(BoardDto li) {// 검색옵션 작성자 글의개수
		int listcount = 0;
		SqlSession sqlSession = factory.openSession();
		listcount = sqlSession.selectOne("countwriter", li);
		// mapper.xml 에서 searchnone 를 id로사용하는 select 구문에 변수를 보내주면서 호출("id",변수) list변수에
		// select값들을 담아준다

		sqlSession.close();
		return listcount;
	}

	public List<BoardDto> boardlistwriter(BoardDto li) {// 검색옵션 작성자
		List<BoardDto> list = null;// List<BoardDto> 객체 생성후 null로 초기화 시켜준다
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("searchwriter", li);
		// mapper.xml 에서 searchwriter 를 id로사용하는 select 구문에 변수를 보내주면서 호출("id",변수) list변수에
		// select값들을 담아준다

		sqlSession.close();
		return list;
	}

}
