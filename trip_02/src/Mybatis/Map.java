package Mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Map {
	private static SqlSessionFactory sqlSession;
	public static SqlSessionFactory getSqlSession(){
		return sqlSession;
	}

	static{
		try {
			String resource = "Mybatis/conn.xml"; //DB 연결 내용을 가지고있는 conn.xml 경로
			Reader reader = Resources.getResourceAsReader(resource);
			//System.out.println("독자="+reader);
			//System.out.println("sqlSession="+sqlSession);
			SqlSessionFactoryBuilder factory = new SqlSessionFactoryBuilder();
			sqlSession = factory.build(reader);
			//System.out.println("?븘?옒="+reader);
			//System.out.print("?븘?옒sqlSession="+sqlSession);
		} catch (Exception e) {
			System.out.println("SqlMapConfig err : " + e);
		}
	}
}


