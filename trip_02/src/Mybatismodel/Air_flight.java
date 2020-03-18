package Mybatismodel;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Mybatis.Map;
import vo.AirDto;

public class Air_flight {
	static Air_flight air = new Air_flight();

	public static Air_flight instance() {
		return air;
	}

	private SqlSessionFactory factory = Map.getSqlSession();

	public List<AirDto> airlist(AirDto li) {
		List<AirDto> list = null;

		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("airDB", li);

		sqlSession.close();
		return list;
	}
}
