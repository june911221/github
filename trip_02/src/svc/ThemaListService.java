package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ThemaDao;
import vo.ThemaDto;

public class ThemaListService {

	public int getListCount() throws Exception {// 전체 글의 개수 구하기(전체보기)
		int listCount = 0;
		Connection con = getConnection();
		ThemaDao DAO = ThemaDao.getInstance();
		DAO.setConnection(con);
		listCount = DAO.selectListCount();
		close(con);
		return listCount;

	}

	public int CategorygetListCount(String category) throws Exception {// 카테고리별 글의 개수 구하기(카테고리별보기)
		int listCount = 0;
		Connection con = getConnection();
		ThemaDao DAO = ThemaDao.getInstance();
		DAO.setConnection(con);
		listCount = DAO.selectcategoryListCount(category);
		close(con);
		return listCount;

	}

	public ArrayList<ThemaDto> getcategoryArticleList(int page, int limit, String category) throws Exception {// 카테고리 에
																												// 맞는 글
																												// 리스트에
																												// 담기

		ArrayList<ThemaDto> articleList = null;
		Connection con = getConnection();
		ThemaDao DAO = ThemaDao.getInstance();
		DAO.setConnection(con);
		articleList = DAO.selectcategoryArticleList(page, limit, category);
		close(con);
		return articleList;

	}

	public ArrayList<ThemaDto> getArticleList(int page, int limit) throws Exception {// 전체글 리스트에 담기

		ArrayList<ThemaDto> articleList = null;
		Connection con = getConnection();
		ThemaDao DAO = ThemaDao.getInstance();
		DAO.setConnection(con);
		articleList = DAO.selectArticleList(page, limit);
		close(con);
		return articleList;

	}
}
