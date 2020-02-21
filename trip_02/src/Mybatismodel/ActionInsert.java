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


	private SqlSessionFactory factory = Map.getSqlSession(); //Map.java ï¿½ë™†ï¿½ì”ªï¿½ì“£ ï§¡ì– ë¸˜ï¿½?ƒ‚

	public void boardInsert(BoardDto list) {
				
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("insertDB",list);
		//mapper.xml ¿¡¼­ insertDB ¸¦ id·Î»ç¿ëÇÏ´Â insert ±¸¹®¿¡ º¯¼ö¸¦ º¸³»ÁÖ¸é¼­ È£Ãâ("id",º¯¼ö)
		
		sqlSession.commit();
		sqlSession.close();
	}
}
